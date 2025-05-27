package com.example.TaskApi.service;

import com.example.TaskApi.dto.TemperatureStatsDTO;
import com.example.TaskApi.utils.NumberToTextUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service

public class TemperatureStatsService {

    private final RestTemplate restTemplate;

    public TemperatureStatsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public TemperatureStatsDTO getTemperatureStatsForVilnius(String startDate, String endDate) {
        String apiUrl = String.format("https://archive-api.open-meteo.com/v1/archive?latitude=54.6892&longitude=25.2798&start_date=%s&end_date=%s&daily=temperature_2m_mean,temperature_2m_min,temperature_2m_max&timezone=auto", startDate, endDate);
        String response = restTemplate.getForObject(apiUrl, String.class);


        double[] avgTemperatures = extractTemperatureArray(response, "temperature_2m_mean");
        double[] minTemperatures = extractTemperatureArray(response, "temperature_2m_min");
        double[] maxTemperatures = extractTemperatureArray(response, "temperature_2m_max");

        if (minTemperatures.length == 0 || maxTemperatures.length == 0) {
            throw new IllegalArgumentException("No temperature data available");
        }
        Arrays.sort(minTemperatures);
        Arrays.sort(maxTemperatures);

        double minimalTemperature = minTemperatures[0];
        double maximalTemperature = maxTemperatures[maxTemperatures.length - 1];
        double averageTemperature = Arrays.stream(avgTemperatures).average().orElse(1000.0);

        averageTemperature = Math.round(averageTemperature * 10.0) / 10.0;
        minimalTemperature = Math.round(minimalTemperature * 10.0) / 10.0;
        maximalTemperature = Math.round(maximalTemperature * 10.0) / 10.0;


        TemperatureStatsDTO temperatureStatsDTO = createTemperatureStatsDTO(averageTemperature, minimalTemperature, maximalTemperature);
        if (temperatureStatsDTO.getAverageTemperature() == 1000.0) {
            temperatureStatsDTO.setAverageTemperature(null);
        }
        return temperatureStatsDTO;
    }

    private double[] extractTemperatureArray(String jsonResponse, String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            JsonNode dailyNode = rootNode.get("daily");
            if (dailyNode == null) return new double[0];

            JsonNode tempArray = dailyNode.get(key);
            if (tempArray == null || !tempArray.isArray()) return new double[0];

            int validCount = 0;
            for (JsonNode node : tempArray) {
                if (!node.isNull()) validCount++;
            }

            double[] temps = new double[validCount];
            int index = 0;
            for (JsonNode node : tempArray) {
                if (!node.isNull()) {
                    temps[index++] = node.asDouble();
                }
            }

            return temps;
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return new double[0];
        }
    }

    private TemperatureStatsDTO createTemperatureStatsDTO(double averageTemperature, double minTemperature, double maxTemperature) {
        String lithuanianTextAverageTemperature;

        if (averageTemperature == 1000.0) {
            lithuanianTextAverageTemperature = "Nėra duomenų";
        } else {
            lithuanianTextAverageTemperature = convertToLithuanianText(averageTemperature);
        }
        String lithuanianTextMinTemperature = convertToLithuanianText(minTemperature);
        String lithuanianTextMaxTemperature = convertToLithuanianText(maxTemperature);

        TemperatureStatsDTO temperatureStatsDTO = new TemperatureStatsDTO(averageTemperature, minTemperature, maxTemperature, lithuanianTextAverageTemperature, lithuanianTextMinTemperature, lithuanianTextMaxTemperature);


        return temperatureStatsDTO;
    }

    private String convertToLithuanianText(double temperature) {
        StringBuilder words = new StringBuilder();
        int integerPart = (int) Math.abs(temperature);
        int decimalPart = (int) Math.round((Math.abs(temperature) - integerPart) * 10);

        if (decimalPart == 10) {
            integerPart++;
            decimalPart = 0;
        }
        if (temperature < 0) {
            words.append("minus ");
        }
        if (integerPart == 0) {
            words.append("nulis ");
        } else {
            words.append(NumberToTextUtils.processTens(integerPart));
        }
        if (decimalPart > 0) {
            words.append("kablelis ").append(NumberToTextUtils.processOnes(decimalPart));

        }
        return words.toString().trim();
    }
}
