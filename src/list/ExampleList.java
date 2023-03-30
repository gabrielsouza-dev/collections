package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExampleList {
    public static void main(String[] args) {
// Given a list of 7 student notes [7, 8.5, 9.3, 5, 7, 0, 3.6], do:

//  List notes = new ArrayList(); // before java 5
//  ArrayList<Double> notes = new ArrayList<>();
//  List<Double> notes = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
  /*List<Double> notes = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
    notes.add(10d);
    System.out.println(notes);*/
  /*List<Double> notes = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
    notes.add(1d);
    notes.remove(5d);
    System.out.println(notes);*/

    System.out.println("Create a list and add the seven notes: ");

    List<Double> notes = new ArrayList<>(); //Generics(jdk 5) - Diamond Operator(jdk 7)
    notes.add(7.0);
    notes.add(8.5);
    notes.add(9.3);
    notes.add(5.0);
    notes.add(7.0);
    notes.add(0.0);
    notes.add(3.6);
    System.out.println(notes.toString());

    System.out.println("Display note 5.0 position: " + notes.indexOf(5d));

    System.out.println("Add the note 8.0 in position 4 to the list: ");
    notes.add(4, 8d);
    System.out.println(notes);

    System.out.println("Replace the 5.0 note with the 6.0 note: ");
    notes.set(notes.indexOf(5d), 6.0);
    System.out.println(notes);

    System.out.println("Check if the 5.0 note is in the list: " + notes.contains(5d));

    System.out.println("Display all notes in the order they were entered: ");
    for (Double note : notes) System.out.println(note);

    System.out.println("Display the third added note: " + notes.get(2));
    System.out.println(notes.toString());

    System.out.println("Display the lowest note: " + Collections.min(notes));

    System.out.println("Display the highest note: " + Collections.max(notes));

    Iterator<Double> iterator = notes.iterator();
    Double sum = 0d;
    while(iterator.hasNext()){
        Double next = iterator.next();
        sum += next;
    }
    System.out.println("Display the sum of values: " + sum);

    System.out.println("Display the average note: " + (sum/notes.size()));

    System.out.println("Remove the note 0: ");
    notes.remove(0d);
    System.out.println(notes);

    System.out.println("Remove note from position 0: ");
    notes.remove(0);
    System.out.println(notes);

    System.out.println("Remove notes less than 7 and display the list: ");
    Iterator<Double> iterator1 = notes.iterator();
    while(iterator1.hasNext()) {
        Double next = iterator1.next();
        if(next < 7) iterator1.remove();
    }
    System.out.println(notes);

    /*System.out.println("Delete the entire list");
    notes.clear();
    System.out.println(notes);
    */

    System.out.println("Check if the list is empty: " + notes.isEmpty());

    System.out.println("Para você: Resolva esses exercícios utilizando os métodos da implementação LinkedList:" );
    
    System.out.println("Create a list called notes2 " + "and place all the elements of the list Arraylist in this new list: ");
        LinkedList<Double> notes2 = new LinkedList<>();
        notes2.addAll(notes);
        System.out.println(notes2);
    
        System.out.println("Display the first note of the new list without removing it: " + notes2.get(0));
     
        System.out.println("Display the first note of the new list by removing it: " + notes2.get(0));
        notes2.remove(0);
        System.out.println(notes2.toString());

    }
}
