package com.tvseries;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Series class - contains all working methods for the TV series application
 * 
 * @author Your Name
 * @version 1.0
 */
public class Series {
    
    // ArrayList to store all series
    private ArrayList<SeriesModel> seriesList;
    private Scanner scanner;
    
    // Constructor
    public Series() {
        seriesList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Method 1: Capture a new series
     */
    public void captureSeries() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   CAPTURE A NEW SERIES");
        System.out.println("=".repeat(40));
        
        // Get series ID
        System.out.print("Enter the series id: ");
        String id = scanner.nextLine();
        
        // Get series name
        System.out.print("Enter the series name: ");
        String name = scanner.nextLine();
        
        // Get age restriction with validation
        int age = getValidAge();
        
        // Get number of episodes
        System.out.print("Enter the number of episodes for " + name + ": ");
        int episodes = scanner.nextInt();
        scanner.nextLine();
        
        // Create and add series
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        
        System.out.println("\nSeries processed successfully!!!");
    }
    
    /**
     * Method to get valid age restriction (2-18)
     */
    private int getValidAge() {
        int age = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print("Enter the series age restriction: ");
            String input = scanner.nextLine();
            
            // Check if input is a number
            try {
                age = Integer.parseInt(input);
                
                // Check if age is between 2 and 18
                if (age >= 2 && age <= 18) {
                    valid = true;
                } else {
                    System.out.println("You have entered an incorrect series age!!!");
                    System.out.print("Please re-enter the series age >> ");
                }
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect series age!!!");
                System.out.print("Please re-enter the series age >> ");
            }
        }
        return age;
    }
    
    /**
     * Method 2: Search for a series
     */
    public void searchSeries() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   SEARCH FOR A SERIES");
        System.out.println("=".repeat(40));
        
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        
        SeriesModel found = findSeriesById(id);
        
        if (found != null) {
            System.out.println("\n" + found.displayDetails());
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }
    
    /**
     * Method 3: Update a series
     */
    public void updateSeries() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   UPDATE A SERIES");
        System.out.println("=".repeat(40));
        
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        
        SeriesModel found = findSeriesById(id);
        
        if (found != null) {
            // Update series name
            System.out.print("Enter the series name: ");
            String name = scanner.nextLine();
            found.setSeriesName(name);
            
            // Update age restriction
            int age = getValidAge();
            found.setSeriesAge(age);
            
            // Update number of episodes
            System.out.print("Enter the number of episodes: ");
            int episodes = scanner.nextInt();
            scanner.nextLine();
            found.setNumberOfEpisodes(episodes);
            
            System.out.println("\nSeries updated successfully!");
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }
    
    /**
     * Method 4: Delete a series
     */
    public void deleteSeries() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   DELETE A SERIES");
        System.out.println("=".repeat(40));
        
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        
        SeriesModel found = findSeriesById(id);
        
        if (found != null) {
            System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("y")) {
                seriesList.remove(found);
                System.out.println("\n---");
                System.out.println("Series with Series Id: " + id + " WAS deleted!");
                System.out.println("---");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with Series Id: " + id + " was not found!");
        }
    }
    
    /**
     * Method 5: Print series report
     */
    public void seriesReport() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   SERIES REPORT - 2025");
        System.out.println("=".repeat(40));
        
        if (seriesList.isEmpty()) {
            System.out.println("No series found in the system.");
            return;
        }
        
        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel series = seriesList.get(i);
            System.out.println("\n---");
            System.out.println("Series " + (i + 1));
            System.out.println("---");
            System.out.println(series.displayDetails());
        }
    }
    
    /**
     * Method 6: Exit application
     */
    public void exitSeriesApplication() {
        System.out.println("\nThank you for using the TV Series Management Application!");
        System.exit(0);
    }
    
    /**
     * Helper method to find series by ID
     */
    public SeriesModel findSeriesById(String id) {
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equals(id)) {
                return series;
            }
        }
        return null;
    }
    
    /**
     * Helper method to check if series exists (for testing)
     */
    public boolean seriesExists(String id) {
        return findSeriesById(id) != null;
    }
    
    /**
     * Helper method to get series list (for testing)
     * @return 
     */
    public ArrayList<SeriesModel> getSeriesList() {
        return seriesList;
    }
    
    /**
     * Helper method to clear all data (for testing)
     */
    public void clearAllData() {
        seriesList.clear();
    }
    
    /**
     * Helper method to add test data (for testing)
     * @param series
     */
    public void addTestSeries(SeriesModel series) {
        seriesList.add(series);
    }
}
