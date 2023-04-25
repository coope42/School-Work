package com.techelevator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class SalesLog {
    private static File logFileLocation;
    private static PrintWriter writeToLog;
    private static Date date;


    public void salesLogFile() {
        logFileLocation = new File(
                "module-1-capstone/src/main/java/com/techelevator/logs/Log.txt");
    }

    // logs all transactions and start up.
    public static void logToSales(String sale)  {
        date = new Date();
        String messageToLog = date + " " + sale + "\n";
            try (PrintWriter newLogWriter =  new PrintWriter(new FileWriter(logFileLocation, true), true)) {
                writeToLog = newLogWriter;
                writeToLog.append(messageToLog);
            } catch (Exception e) {
                System.out.println("Failed to create sales log. " + e.getMessage());
            }
        }
    }

