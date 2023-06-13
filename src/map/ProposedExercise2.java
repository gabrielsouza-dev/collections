package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Given the following id and contact information, create a dictionary and
sort this dictionary by displaying (Name id - Name contact);

id = 1 - Contact = name: Simba, number: 2222;
id = 4 - Contact = name: Cami, number: 5555;
id = 3 - Contact = name: Jon, number: 1111;
*/

public class ProposedExercise2 {
    public static void main(String[] args) {
        System.out.println("Ordered by random order: ");
        Map<Integer, ContactBook> myContactBook = new HashMap<>(){{
            put(1, new ContactBook("Simba", 2222));            
            put(4, new ContactBook("Cami", 5555));
            put(3, new ContactBook("Jon", 1111));
        }};
        for (Map.Entry<Integer, ContactBook> contact : myContactBook.entrySet()) {
            System.out.println("id = " + contact.getKey() + " - Contact = name: " + contact.getValue().getName() + ", number: " + contact.getValue().getNumber());
        }

        System.out.println("\nOrdered by insertion order: ");
        Map<Integer, ContactBook> myContactBook1 = new LinkedHashMap<>(){{
            put(1, new ContactBook("Simba", 2222));
            put(4, new ContactBook("Cami", 5555));
            put(3, new ContactBook("Jon", 1111));
        }};
        for (Map.Entry<Integer, ContactBook> contact1 : myContactBook1.entrySet()) {
            System.out.println("id = " + contact1.getKey() + " - Contact = name: " + contact1.getValue().getName() + ", number: " + contact1.getValue().getNumber());
        }

        System.out.println("\nOrdered by id: ");
        Map<Integer, ContactBook> myContactBook2 = new TreeMap<>(myContactBook1);
        for (Map.Entry<Integer, ContactBook> contact2 : myContactBook2.entrySet()) {
            System.out.println("id = " + contact2.getKey() + " - Contact = name: " + contact2.getValue().getName() + ", number: " + contact2.getValue().getNumber());
        }

        System.out.println("\nOrdered by contact name: ");
        Set<Map.Entry<Integer, ContactBook>> myContactBookSet = new TreeSet<>(new ContactNameComparator());
        myContactBookSet.addAll(myContactBook1.entrySet());
        for (Map.Entry<Integer,ContactBook> contact3 : myContactBookSet) {
            System.out.println("id = " + contact3.getKey() + " - Contact = name: " + contact3.getValue().getName() + ", number: " + contact3.getValue().getNumber());            
        }

        System.out.println("\nOrdered by phone number: ");
        Set<Map.Entry<Integer, ContactBook>> myContactBookSet1 = new TreeSet<>(new PhoneNumberComparator());
        myContactBookSet1.addAll(myContactBook1.entrySet());
        for (Map.Entry<Integer,ContactBook> contact4 : myContactBookSet1) {
            System.out.println("id = " + contact4.getKey() + " - Contact = name: " + contact4.getValue().getName() + ", number: " + contact4.getValue().getNumber());
        }
    }
}

class ContactNameComparator implements Comparator<Map.Entry<Integer, ContactBook>> {

    @Override
    public int compare(Entry<Integer, ContactBook> c1, Entry<Integer, ContactBook> c2) {
        return c1.getValue().getName().compareToIgnoreCase(c2.getValue().getName());
    }
    
}

class PhoneNumberComparator implements Comparator<Map.Entry<Integer, ContactBook>> {

    @Override
    public int compare(Entry<Integer, ContactBook> c1, Entry<Integer, ContactBook> c2) {
        return Integer.compare(c1.getValue().getNumber(), c2.getValue().getNumber());
    }
}