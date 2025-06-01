package edu.ucab.triviaucabapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter maximum time in seconds: ");
        int maxTime = scanner.nextInt();
        
        Timer timer = new Timer(maxTime);
        
        System.out.println("Commands: 'start' to begin timer, 'stop' to end timer, 'exit' to quit");
        String command;
        
        do {
            command = scanner.next().toLowerCase();
            switch (command) {
                case "start":
                    timer.start();
                    break;
                case "stop":
                    timer.stop();
                    break;
                case "exit":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } while (!command.equals("exit"));
        
        scanner.close();
    }
}