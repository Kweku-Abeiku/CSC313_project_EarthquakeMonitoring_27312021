/*
 * This is a package that contains classes designed to monitor the activities
 * of illegal mining activities in Africa
 */
package GalamseyProject;

import java.util.ArrayList;
import java.util.Scanner;


public class MonitoringIO {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Observatory> monitoring = new ArrayList<>();;
        String input = "";

        while(!input.equals("exit")){
            System.out.println("\nType O for observatory data, M  for  monitoring statistics or exit to exit");
            input = keyboard.nextLine();

            if (input.equals("O")) {
                ArrayList<Galamsey> list = new ArrayList<>();
                System.out.println("\nInput details for Observatory data");
                System.out.println("Please enter Observatory name");
                String name = keyboard.nextLine();
                System.out.println("\nPlease enter the country location of"
                        + " the Observatory");
                String countryLocation = keyboard.nextLine();
                System.out.println("\nPlease enter the year in which galamsey"
                        + " activities were first recorded");
                int yearStarted = keyboard.nextInt();
                System.out.println("\nPlease enter the area covered by the "
                        + "Observatory in decimals");
                double areaCovered = keyboard.nextDouble();


                String cont = "y";
                System.out.println("\nPlease enter galamsey activities");
                while(cont.equals("y")){
                    System.out.println("\nPlease enter the vegetation colour of "
                            + "the galamsey site");
                    String VegColour = keyboard.next();
                    System.out.println("\nPlease enter the colour value of the"
                            + " galamsey activity");
                    int colVal = keyboard.nextInt();
                    System.out.println("\nPlease enter the year in which galamsey "
                            + "activity began");
                    int YearStarted = keyboard.nextInt();
                    System.out.println("\nPlease enter the position (longitude,"
                            + "lattitude in decimals) of the galamsey");
                    float longitude = keyboard.nextFloat();
                    float lattitude = keyboard.nextFloat();
                    Galamsey galamsey = new Galamsey(VegColour,colVal,longitude, lattitude,YearStarted);
                    list.add(galamsey);
                    System.out.println("Input more galamsey data, y or n: ");
                    cont = keyboard.next();
                }
                Observatory observatory = new Observatory(name,countryLocation,
                        yearStarted,areaCovered,list);

                monitoring.add(observatory);
            }

            if (input.equals("M")) {
                if (!monitoring.isEmpty()) {
                    Monitoring monitor = new Monitoring(monitoring);
                    String a = monitor.LargestAverage().toString();
                    System.out.println("The largest average galamsey colour value is "
                            + a);
                    System.out.println("The largest galamsey colour value is " +
                            monitor.MaxColVal());
                    System.out.println("Find list of galamsey with colour "
                            + "value greater than: ");
                    int colorNum = keyboard.nextInt();
                    System.out.println(monitor.LargerThan(colorNum));
                }
                else{
                    System.out.println("There is no observatory activity in record");
                }
            }

        }


    }
}
