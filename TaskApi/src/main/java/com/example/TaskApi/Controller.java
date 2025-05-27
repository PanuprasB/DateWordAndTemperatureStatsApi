package com.example.TaskApi;

import com.example.TaskApi.dto.DateRangeDTO;
import com.example.TaskApi.dto.NumberDTO;
import com.example.TaskApi.dto.TemperatureStatsDTO;
import com.example.TaskApi.service.DaysCalculationService;
import com.example.TaskApi.service.NumbersToWordsService;
import com.example.TaskApi.service.TemperatureStatsService;
import com.example.TaskApi.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class Controller {

    @Autowired
    private DaysCalculationService daysCalculationService;
    @Autowired
    private NumbersToWordsService numbersToWordsService;
    @Autowired
    private TemperatureStatsService temperatureStatsService;

    @PostMapping("/numberOfDays")
    public ResponseEntity<?> getNumberOfDays(@RequestBody DateRangeDTO dateRangeDTO) {
        try {
            ValidationUtils.validateDateRange(dateRangeDTO.getDateOne(), dateRangeDTO.getDateTwo());
            int days = daysCalculationService.getNumberOfDays(dateRangeDTO.getDateOne(), dateRangeDTO.getDateTwo());
            return ResponseEntity.ok(days);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/numberToWords")
    public ResponseEntity<?> getNumberToWords(@RequestBody NumberDTO numberDTO) {
        try {
            ValidationUtils.validateNumber(numberDTO.getNumber());
            String words = numbersToWordsService.convertNumberToWords(numberDTO.getNumber());
            return ResponseEntity.ok(words);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/temperatureStatsForVilnius")
    public ResponseEntity<?> getTemperatureStatsForVilnius(@RequestBody DateRangeDTO dateRangeDTO) {
        try {
            ValidationUtils.validateDateRangeForTemperatureStats(dateRangeDTO.getDateOne(), dateRangeDTO.getDateTwo());
            TemperatureStatsDTO stats = temperatureStatsService.getTemperatureStatsForVilnius(dateRangeDTO.getDateOne(), dateRangeDTO.getDateTwo());
            return ResponseEntity.ok(stats);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
