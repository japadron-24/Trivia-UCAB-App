package edu.ucab.triviaucabapp;

public class Timer {
    private int maxTimeSeconds;
    private boolean isRunning;

    public Timer(int maxTimeSeconds) {
        this.maxTimeSeconds = maxTimeSeconds;
        this.isRunning = false;
    }

    public void start() {
        isRunning = true;
        System.out.println("Timer started for " + maxTimeSeconds + " seconds");
        
        Thread timerThread = new Thread(() -> {
            int remainingTime = maxTimeSeconds;
            while (isRunning && remainingTime > 0) {
                System.out.println("Time remaining: " + remainingTime + " seconds");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                remainingTime--;
            }
            if (remainingTime <= 0) {
                System.out.println("Time's up!");
            }
            isRunning = false;
        });
        
        timerThread.start();
    }

    public void stop() {
        isRunning = false;
        System.out.println("Timer stopped");
    }
}