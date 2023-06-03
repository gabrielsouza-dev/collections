package map;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/*
1. Make a program that simulates a roll of the dice.

2. Roll the dice 100 times and store it.

3. Then, show how many times each value was entered.
*/

public class DiceThrowingChallenge {
    public static void main(String[] args) {
        //defining the number of dice throws
        int throwings = 100;
        //defining the dice thrower
        Random thrower = new Random();
        //defining a variable to store each random number
        int randomNumber = 0;
        //defining counters
        int times1 = 0;
        int times2 = 0;
        int times3 = 0;
        int times4 = 0;
        int times5 = 0;
        int times6 = 0;

        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < throwings; i++) {
            //generating random numbers for each dice throw
            randomNumber = thrower.nextInt(1, 7);
            //adding random number to values List
            values.add(randomNumber);
        }
        //using counters to know each time a value is entered
        for (Integer value : values) {
            if (value.equals(1)) times1++;
            else if (value.equals(2)) times2++;
                else if (value.equals(3)) times3++;
                    else if (value.equals(4)) times4++;
                        else if (value.equals(5)) times5++;
                            else if (value.equals(6)) times6++;
        }
        //Showing the results of counters
        System.out.println("Each value was entered= " +"number 1: " + times1 + " times, " + "number 2: " + times2 + " times, " + "number 3: " + times3 + " times, " + "number 4: " + times4 + " times, " + "number 5: " + times5 + " times, " + "number 6: " + times6 + " times.");
    }
}
