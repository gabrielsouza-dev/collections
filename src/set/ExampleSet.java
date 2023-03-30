package set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExampleSet {
    public static void main(String[] args) {
        
        // Notes to work: 7d, 8.5, 9.3, 5d, 7d, 0d, 3.6

        System.out.println("Create a set and add grades: ");
        Set<Double> grades = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(grades);

        // System.out.println("Display the position of grade 5: ");
        // Set doesn't have the get method nor index to acess the elements position
        
        // System.out.println("Add the grade 8.0 on position 4: ");
        // Set doesn't have the get method nor index to acess the elements position

        // System.out.println("Replace grade 5.0 to grade 6.0: ");
        // Set doesn't have the get method nor index to acess the elements position

        System.out.println("Check if the grade 5.0 is in the set: " + grades.contains(5d));

        // System.out.println("Display the third added grade: ");
        // Set doesn't have the get method nor index to acess the elements position

        System.out.println("Display the lowest grade: " + Collections.min(grades));

        System.out.println("Display the biggest grade: " + Collections.max(grades));

        Iterator<Double> iterator = grades.iterator();
        Double sum = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            sum += next;
        }
        System.out.println("Display the sum of values: " + sum);

        System.out.println("Display the grades average: " + (sum/grades.size()));

        System.out.println("Remove grade 0.0: ");
        grades.remove(0d);
        System.out.println(grades);

        // System.out.println("Remove grade on the position 0: ");
        // Set doesn't have the get method nor index to acess the elements position

        System.out.println("Remove grades smaller than 7 and display the list: ");
        Iterator<Double> iterator1 = grades.iterator();
        while (iterator1.hasNext()) {
            Double next1 = iterator1.next();
            if (next1 < 7) iterator1.remove();
        }
        System.out.println(grades);

        System.out.println("Display all grades in the order they were entered: ");
        Set<Double> grades1 = new LinkedHashSet<>();
        grades1.add(7d);
        grades1.add(8.5);
        grades1.add(9.3);
        grades1.add(5d);
        grades1.add(7d);
        grades1.add(0d);
        grades1.add(3.6);
        System.out.println(grades1);

        System.out.println("Display all grades in ascending order: ");
        Set<Double> grades2 = new TreeSet<>(grades1);
        System.out.println(grades2);
    
        System.out.println("Erase the whole set: ");
        grades.clear();

        System.out.println("Check if set is empty: " + grades.isEmpty());
        System.out.println("Check if set 1 is empty: " + grades1.isEmpty());
        System.out.println("Check if set 2 is empty: " + grades2.isEmpty());
    }
}