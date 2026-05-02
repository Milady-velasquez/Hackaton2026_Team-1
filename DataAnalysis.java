import java.io.*;
import java.util.*;

public class DataAnalysis {
   public static final double SPEED_MAX = 60;
   public static final double SPEED_MID = 40;
   
   public static final double TEMP_MAX = 0;
   public static final double TEMP_MID = 0;
   
   public static final double PRESS_MAX = 0;
   public static final double PRESS_MID = 0;
   
   public static final double VIB_MAX = 0;
   public static final double VIB_MID = 0;
   
   public static final double WEIGHT_MAX = 286000;
   public static final double WEIGHT_MID = 263000;
   
   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner console = new Scanner(System.in); 
      System.out.print("Enter train ID: ");
      String train = console.next();
     
      Scanner input = new Scanner(new File("data.txt"));
            
      while(input.hasNext()) {
         String trainID = input.next();
         String type = input.next();
         double value = input.nextDouble();
         
         if(trainID.equals(train)) {
            if(type.equals("speed")) {
               System.out.println("Speed: " + value);
               System.out.println(riskLevel(value, SPEED_MID, SPEED_MAX));
               System.out.println(speedSol(value));
            
            } else if(type.equals("temperature")) {
               System.out.println("Temperature: " + value);
               System.out.println(riskLevel(value, TEMP_MID, TEMP_MAX));
               System.out.println(tempSol(value));
         
            } else if(type.equals("pressure")) {
               System.out.println("Pressure: " + value);
               System.out.println(riskLevel(value, PRESS_MID, PRESS_MAX));
               System.out.println(pressSol(value));

            } else if(type.equals("vibration")) {
               System.out.println("Vibration: " + value);
               System.out.println(riskLevel(value, VIB_MID, VIB_MAX));
               System.out.println(vibSol(value));

            } else if(type.equals("weight")) {
               System.out.println("Weight: " + value);
               System.out.println(riskLevel(value, WEIGHT_MID, WEIGHT_MAX));
               System.out.println(weightSol(value));

            }

         }
                  
         

      }
      
      
   }
   
   public static String riskLevel(double value, double mid, double max) {
     
      if(value >= max) {
         return "high risk";
      } else if(value >= mid) {
         return "medium risk";
      } else {
         return "safe risk";
      }
   }
   
   public static String speedSol(double value) {
      
      if(value >= SPEED_MAX) {
         return "decrease the speed immediately.";
      } else if(value >= SPEED_MID) {
         return "slow down.";
      } else {
         return "good";
      }

   }
   
   public static String tempSol(double value) {
     
      if(value >= TEMP_MAX) {
         return "cool the tank.";
      } else if(value >= TEMP_MID) {
         return "prepare cooling.";
      } else {
         return "good";
      }

   }
   
   public static String vibSol(double value) {
      
      if(value >= VIB_MAX) {
         return "stop operation.";
      } else if(value >= VIB_MID) {
         return "check and monitor.";
      } else {
         return "safe";
      }

   }
      
         
    public static String pressSol(double value) {
      
      if(value >= PRESS_MAX) {
         return "stop operation.";
      } else if(value >= PRESS_MID) {
         return "check and monitor.";
      } else {
         return "safe";
      }

   }

   
   public static String weightSol(double value) {
      
      if(value >= WEIGHT_MAX) {
         return "reduce load.";
      } else if(value >= WEIGHT_MID) {
         return "check load balance.";
      } else {
         return "good";
      }

   }

}

