package com.tvseries;

import java.util.Scanner;

/**
 * Main class - runs the TV Series Management Application
 * 
 * @author Your Name
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Series seriesApp = new Series();
        
        // Display initial menu
        System.out.println("\n" + "=".repeat(40));
        System.out.println("   LATEST SERIES - 2025");
        System.out.println("=".repeat(40));
        System.out.println("Enter (1) to launch menu or any other key to exit");
        System.out.print(">> ");
        
        String choice = scanner.nextLine();
        
        if (!choice.equals("1")) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        
        boolean running = true;
        
        while (running) {
            // Display main menu
            System.out.println("\n" + "=".repeat(40));
            System.out.println("Please select one of the following menu items:");
            System.out.println("=".repeat(40));
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");
            System.out.print(">> ");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:
                    seriesApp.captureSeries();
                    break;
                case 2:
                    seriesApp.searchSeries();
                    break;
                case 3:
                    seriesApp.updateSeries();
                    break;
                case 4:
                    seriesApp.deleteSeries();
                    break;
                case 5:
                    seriesApp.seriesReport();
                    break;
                case 6:
                    seriesApp.exitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            
            // Ask to return to menu
            System.out.println("\nEnter (1) to launch menu or any other key to exit");
            System.out.print(">> ");
            String back = scanner.nextLine();
            if (!back.equals("1")) {
                seriesApp.exitSeriesApplication();
            }
        }
    }
}