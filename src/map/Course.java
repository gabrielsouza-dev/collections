package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

//An example of a Map Comparator with objects in key and value.

/*
Create a class Student that has the attributes: name, registration.
Create a Course class that has the attributes: name, course.
Then instantiate 3 objects students and 3 courses, relating them in a dictionary.
Sort the dictionary by:
a) discipline name.
b) Length of discipline.
c) Name of the student.
d) Registration of the student.
*/

public class Course {
    public static void main(String[] args) {
        Student student = new Student("Gabriel", 100);    
        Student student1 = new Student("Renata", 101);
        Student student2 = new Student("Maria Antonia", 102);

        Discipline discipline = new Discipline("Java", 10);
        Discipline discipline1 = new Discipline("Python", 9);
        Discipline discipline2 = new Discipline("JavaScript", 12);

        Map<Discipline, Student> courses = new HashMap<>(){{
            put(discipline, student);
            put(discipline1, student1);
            put(discipline2, student2);
        }};

        System.out.println("Test: ");
        for (Map.Entry<Discipline, Student> course : courses.entrySet()) {
            System.out.println(course.getKey() + " - " + course.getValue());
        }

        System.out.println("\nSort by discipline name: ");
        Map<Discipline, Student> courses1 = new TreeMap<Discipline, Student>(courses);
        for (Map.Entry<Discipline, Student> course1 : courses1.entrySet()) {
            System.out.println(course1.getKey() + " - " + course1.getValue());
        }

        System.out.println("\nSort by lenght of discipline: ");
        Map<Discipline, Student> courses2 = new TreeMap<Discipline, Student>(new LenghtDisciplineComparator());
        courses2.putAll(courses);
        for (Map.Entry<Discipline, Student> course2 : courses2.entrySet()) {
            System.out.println(course2.getKey() + " - " + course2.getValue());
        }

        System.out.println("\nSort by student name: ");
        Set<Map.Entry<Discipline, Student>> courses3 = new TreeSet<Map.Entry<Discipline, Student>>(new StudentNameComparator());
        courses3.addAll(courses.entrySet());
        for (Map.Entry<Discipline, Student> course3 : courses3) {
            System.out.println(course3.getKey() + " - " + course3.getValue());
        }

        System.out.println("\nSort by student registration: ");
        Set<Map.Entry<Discipline, Student>> courses4 = new TreeSet<Map.Entry<Discipline, Student>>(new StudentRegistrationComparator());
        courses4.addAll(courses.entrySet());
        for (Map.Entry<Discipline,Student> course4 : courses4) {
            System.out.println(course4.getKey() + " - " + course4.getValue());
        }
    }
}

class LenghtDisciplineComparator implements Comparator<Discipline> {

    @Override
    public int compare(Discipline d1, Discipline d2) {
        return Integer.compare(d1.getDuration(), d2.getDuration());
    }
}

class StudentNameComparator implements Comparator<Map.Entry<Discipline, Student>> {

    @Override
    public int compare(Entry<Discipline, Student> s1, Entry<Discipline, Student> s2) {
        return s1.getValue().getName().compareToIgnoreCase(s2.getValue().getName());
    }
}

class StudentRegistrationComparator implements Comparator<Map.Entry<Discipline, Student>> {

    @Override
    public int compare(Entry<Discipline, Student> s1, Entry<Discipline, Student> s2) {
        return Integer.compare(s1.getValue().getRegistration(), s2.getValue().getRegistration());
    }
}