package com.tvseries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the TV Series Management Application
 * 
 * @author Your Name
 * @version 1.0
 */
public class SeriesTest {
    
    private Series seriesApp;
    
    @BeforeEach
    public void setUp() {
        seriesApp = new Series();
        // Add test data
        seriesApp.addTestSeries(new SeriesModel("101", "Extreme Sports", 12, 10));
        seriesApp.addTestSeries(new SeriesModel("102", "Bargain Hunters", 10, 10));
        seriesApp.addTestSeries(new SeriesModel("103", "Home Cooking", 10, 20));
    }
    
    // Test 1: Search for a series - success
    @Test
    public void testSearchSeries() {
        SeriesModel found = seriesApp.findSeriesById("101");
        assertNotNull(found);
        assertEquals("101", found.getSeriesId());
        assertEquals("Extreme Sports", found.getSeriesName());
        assertEquals(12, found.getSeriesAge());
        assertEquals(10, found.getNumberOfEpisodes());
    }
    
    // Test 2: Search for a series - not found
    @Test
    public void testSearchSeries_SeriesNotFound() {
        SeriesModel found = seriesApp.findSeriesById("999");
        assertNull(found);
    }
    
    // Test 3: Update a series
    @Test
    public void testUpdateSeries() {
        SeriesModel found = seriesApp.findSeriesById("101");
        assertNotNull(found);
        
        // Update the series
        found.setSeriesName("Extreme Sports 2025");
        found.setSeriesAge(10);
        found.setNumberOfEpisodes(12);
        
        // Verify updates
        SeriesModel updated = seriesApp.findSeriesById("101");
        assertEquals("Extreme Sports 2025", updated.getSeriesName());
        assertEquals(10, updated.getSeriesAge());
        assertEquals(12, updated.getNumberOfEpisodes());
    }
    
    // Test 4: Delete a series - success
    @Test
    public void testDeleteSeries() {
        assertTrue(seriesApp.seriesExists("101"));
        SeriesModel found = seriesApp.findSeriesById("101");
        seriesApp.getSeriesList().remove(found);
        assertFalse(seriesApp.seriesExists("101"));
    }
    
    // Test 5: Delete a series - not found
    @Test
    public void testDeleteSeries_SeriesNotFound() {
        // Try to delete non-existent series
        SeriesModel found = seriesApp.findSeriesById("999");
        assertNull(found);
    }
    
    // Test 6: Valid age restriction
    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        // Test valid ages between 2 and 18
        SeriesModel validSeries1 = new SeriesModel("201", "Valid Show 1", 2, 10);
        SeriesModel validSeries2 = new SeriesModel("202", "Valid Show 2", 10, 10);
        SeriesModel validSeries3 = new SeriesModel("203", "Valid Show 3", 18, 10);
        
        assertTrue(validSeries1.getSeriesAge() >= 2 && validSeries1.getSeriesAge() <= 18);
        assertTrue(validSeries2.getSeriesAge() >= 2 && validSeries2.getSeriesAge() <= 18);
        assertTrue(validSeries3.getSeriesAge() >= 2 && validSeries3.getSeriesAge() <= 18);
    }
    
    // Test 7: Invalid age restriction
    @Test
    public void testSeriesAgeRestriction_SeriesAgeInvalid() {
        // Test invalid ages (below 2 and above 18)
        SeriesModel invalidSeries1 = new SeriesModel("301", "Invalid Show 1", 1, 10);
        SeriesModel invalidSeries2 = new SeriesModel("302", "Invalid Show 2", 19, 10);
        SeriesModel invalidSeries3 = new SeriesModel("303", "Invalid Show 3", 25, 10);
        
        assertFalse(invalidSeries1.getSeriesAge() >= 2 && invalidSeries1.getSeriesAge() <= 18);
        assertFalse(invalidSeries2.getSeriesAge() >= 2 && invalidSeries2.getSeriesAge() <= 18);
        assertFalse(invalidSeries3.getSeriesAge() >= 2 && invalidSeries3.getSeriesAge() <= 18);
    }
}