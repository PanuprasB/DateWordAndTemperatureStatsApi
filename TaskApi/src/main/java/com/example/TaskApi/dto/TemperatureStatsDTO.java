package com.example.TaskApi.dto;

public class TemperatureStatsDTO {

   private Double averageTemperature;
   private double minTemperature;
   private double maxTemperature;

   private String lithuanianTextAverageTemperature;
   private String lithuanianTextMinTemperature;
   private String lithuanianTextMaxTemperature;

    public TemperatureStatsDTO() {
    }
   public TemperatureStatsDTO(double averageTemperature, double minTemperature, double maxTemperature, String lithuanianTextAverageTemperature, String lithuanianTextMinTemperature, String lithuanianTextMaxTemperature) {


      this.averageTemperature = averageTemperature;
      this.minTemperature = minTemperature;
      this.maxTemperature = maxTemperature;
      this.lithuanianTextAverageTemperature = lithuanianTextAverageTemperature;
      this.lithuanianTextMinTemperature = lithuanianTextMinTemperature;
      this.lithuanianTextMaxTemperature = lithuanianTextMaxTemperature;
   }

   public Double getAverageTemperature() {
      return averageTemperature;
   }

   public void setAverageTemperature(Double averageTemperature) {
      this.averageTemperature = averageTemperature;
   }

   public double getMinTemperature() {
      return minTemperature;
   }

   public void setMinTemperature(double minTemperature) {
      this.minTemperature = minTemperature;
   }

   public double getMaxTemperature() {
      return maxTemperature;
   }

   public void setMaxTemperature(double maxTemperature) {
      this.maxTemperature = maxTemperature;
   }

   public String getLithuanianTextAverageTemperature() {
      return lithuanianTextAverageTemperature;
   }

   public void setLithuanianTextAverageTemperature(String lithuanianTextAverageTemperature) {
      this.lithuanianTextAverageTemperature = lithuanianTextAverageTemperature;
   }

   public String getLithuanianTextMinTemperature() {
      return lithuanianTextMinTemperature;
   }

   public void setLithuanianTextMinTemperature(String lithuanianTextMinTemperature) {
      this.lithuanianTextMinTemperature = lithuanianTextMinTemperature;
   }

   public String getLithuanianTextMaxTemperature() {
      return lithuanianTextMaxTemperature;
   }

   public void setLithuanianTextMaxTemperature(String lithuanianTextMaxTemperature) {
      this.lithuanianTextMaxTemperature = lithuanianTextMaxTemperature;
   }
}
