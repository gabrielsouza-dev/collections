package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AverageTemperature {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        List<Double> temperatures = new ArrayList<Double>();

        //Adding temperatures to the list:
        int counter = 0;
        while (true) {
            if (counter == 6) break;

            System.out.print("Enter the temperature: ");
            double temp = reader.nextDouble();
            temperatures.add(temp);
            counter++;
        }
        
        //displaying all temperatures:
        System.out.print("\nAll temperatures: ");
        temperatures.forEach(t -> System.out.print(t + " "));

        //calculating and displaying the average of the temperatures:
        double average = temperatures.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nAverage of temperatures: %.1f\n", average);

        //displaying above average temperatures
        System.out.print("Above average temperatures: ");
        temperatures.stream()
                .filter(t -> t > average)
                .forEach(t -> System.out.printf("%.1f ", t));

        //displaying the month of above-average temperatures spelled out:
        System.out.println("\n\nMonths of above-average temperatures: ");
        Iterator<Double> iterator = temperatures.iterator();

        counter = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if (temp > average) {
                switch (counter) {
                    case (0):
                        System.out.printf("1 - january: %.1f\n ", temp);
                        break;
                    case (1):
                        System.out.printf("2 - february: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - march: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - april: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - may: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - june: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("There was no temperature above average.");
                }
            }
            counter++;
        }
    }
}