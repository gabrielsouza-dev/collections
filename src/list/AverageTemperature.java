package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageTemperature {
    
    public static void main(String[] args) {

        int januaryTemperature;
        int februaryTemperature;
        int marchTemperature;
        int aprilTemperature;
        int mayTemperature;
        int juneTemperature;
        int sixMonthAverage;
        String[] sixMonth = {"1 - January", "2 - February", "3 - March", "4 - April", "5 - May", "6 - June"};

        //Using Scanner to read and store user input:
        try (Scanner reader = new Scanner(System.in)) {

            System.out.println("Enter the average temperature for january: ");
            januaryTemperature = reader.nextInt();

            System.out.println("Enter the average temperature for february: ");
            februaryTemperature = reader.nextInt();

            System.out.println("Enter the average temperature for march: ");
            marchTemperature = reader.nextInt();

            System.out.println("Enter the average temperature for april: ");
            aprilTemperature = reader.nextInt();

            System.out.println("Enter the average temperature for may: ");
            mayTemperature = reader.nextInt();

            System.out.println("Enter the average temperature for june: ");
            juneTemperature = reader.nextInt();
            
        }

        //Creating list to store temperatures:
        List<Integer> temperature = new ArrayList<>();

        //Adding temperatures to the list:
        temperature.add(januaryTemperature);
        temperature.add(februaryTemperature);
        temperature.add(marchTemperature);
        temperature.add(aprilTemperature);
        temperature.add(mayTemperature);
        temperature.add(juneTemperature);

        //Displaying all temperatures:
        System.out.println();
        System.out.println("All temperatures: " + temperature);

        //Calculating and displaying average temperatures:
        sixMonthAverage = (januaryTemperature + februaryTemperature + marchTemperature + aprilTemperature + mayTemperature + juneTemperature) / 6;
        System.out.println();
        System.out.println(sixMonthAverage);

        //Using forEach to loop through each element of the temperature list:
        for (Integer temp : temperature) {
            
            //Using if to find temperatures above the half-yearly average:
            if (temp > sixMonthAverage) {

                //Displaying the temperatures above the six-month average and the month in which they occurred respectively:
                System.out.println();
                System.out.println(temp + " " + sixMonth[temperature.indexOf(temp)]);
            
            }

        }

    }

}