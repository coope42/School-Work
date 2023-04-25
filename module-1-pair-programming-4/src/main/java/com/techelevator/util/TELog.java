package com.techelevator.util;
import com.techelevator.search.SearchDomain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;


public class TELog {

    private static String logFile = "module-1-pair-programming-4\\logs\\search.log";
//    private File logFileLocation = new File(logFile);

    public static PrintWriter dataOutput;
    public TELog() {}


//    private static void setDataOutput(PrintWriter dataOutput) {
//    }
    public static void log(String message) {

       if (dataOutput == null) {
            try (PrintWriter thisData = new PrintWriter (new FileOutputStream(logFile, true))) {
                thisData.append(message + "\n");
//               dataOutput = thisData;
//              dataOutput = new PrintWriter(thisData);
            } catch (Exception e) {
                throw new TELogException(e.getMessage());
            }
      }
       else {
          dataOutput.append(message + "\n");
        }
    }
}
