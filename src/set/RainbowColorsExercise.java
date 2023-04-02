package set;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//Rainbow colors: red, orange, yellow, green, blue, indigo, violet.

public class RainbowColorsExercise {
    public static void main(String[] args) {

        //Creating set and adding rainbow colors sorted by insertion order
        System.out.println("Display all colors one below the other: ");
        Set<String> rainbowColors = new LinkedHashSet<>();
        rainbowColors.add("red");
        rainbowColors.add("orange");
        rainbowColors.add("yellow");
        rainbowColors.add("green");
        rainbowColors.add("blue");
        rainbowColors.add("indigo");
        rainbowColors.add("violet");
        for (String color : rainbowColors) {
            System.out.println(color);
        }

        //Using the size method to display the elements number
        System.out.println("\nDisplay how many colors has the rainbow: ");
        System.out.println("The raibow has " + rainbowColors.size() + " colors.");

        //Using TreeSet to sort rainbow colors by alphabetical order
        System.out.println("\nDisplay the colors in alphabetical order: ");
        Set<String> rainbowColors1 = new TreeSet<>(rainbowColors);
        System.out.println(rainbowColors1);

        //Using LinkedList and reverse method of Collections to invert colors order
        System.out.println("\nDisplay the colors in the reverse order they were entered: ");
        List<String> rainbowColors2 = new LinkedList<>(rainbowColors);
        Collections.reverse(rainbowColors2);
        System.out.println(rainbowColors2);

        //Using For-Each to go through each color and display all colors that start with letter v
        System.out.println("\nDisplay all colors that start with the letter v: ");
        for (String color : rainbowColors1) {
            if (color.startsWith("v")) {
                System.out.println(color);
            }
        }
        
        //Using iterator to go trough each color(Important: not storing next in a variable when using a collection because it may throw an exception that prevents the program from running) and remove all colors that don't start with letter v
        System.out.println("\nRemove all colors that don't start with the letter v: ");
        Iterator<String> iterator = rainbowColors1.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) 
            iterator.remove();
        }
        System.out.println(rainbowColors1);
        
        //Using clear method to clean the set
        System.out.println("\nClean set: ");
        rainbowColors.clear();
        System.out.println(rainbowColors);

        //Using isEmpty mtehod to check if the set is empty
        System.out.println("\nCheck if the set is empty: ");
        System.out.println(rainbowColors.isEmpty());
    }
}