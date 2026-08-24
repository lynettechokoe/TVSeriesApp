package com.tvseries;

/**
 * SeriesModel class - stores TV series data
 * 
 * @author Your Name
 * @version 1.0
 */
public class SeriesModel {
    
    // Variables - information hiding (private)
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;
    
    // Constructor
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.numberOfEpisodes = numberOfEpisodes;
    }
    
    // Getters and Setters
    public String getSeriesId() {
        return seriesId;
    }
    
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }
    
    public String getSeriesName() {
        return seriesName;
    }
    
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
    
    public int getSeriesAge() {
        return seriesAge;
    }
    
    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }
    
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    
    // Display series details
    public String displayDetails() {
        return "SERIES ID: " + seriesId + "\n" +
               "SERIES NAME: " + seriesName + "\n" +
               "SERIES AGE RESTRICTION: " + seriesAge + "\n" +
               "NUMBER OF EPISODES: " + numberOfEpisodes;
    }
}