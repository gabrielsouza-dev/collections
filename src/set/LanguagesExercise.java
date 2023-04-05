package set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LanguagesExercise {
    public static void main(String[] args) {
        //Adds each element through a LinkedHashSet to store them in insertion order and finally displays each language organized by a For-Each
        System.out.println("Insertion order: ");
        Set<FavoriteLanguage> languages = new LinkedHashSet<>(){{
            add(new FavoriteLanguage("Java", 1991, "IntelliJ"));
            add(new FavoriteLanguage("JavaScript", 1995, "VsCode"));
            add(new FavoriteLanguage("Python", 1991, "PyCharm"));
        }};
        for (FavoriteLanguage languages1 : languages) {
            System.out.println(languages1.getName() + " - " + languages1.getYearOfCreation() + " - " + languages1.getIde());
        }

        //Adds the elements of the first Language Set, stores each language sorted in natural order(name) with a TreeSet, and displays each language through a For-Each
        System.out.println("\nNatural order(name): ");
        Set<FavoriteLanguage> languages1 = new TreeSet<>(languages);
        for (FavoriteLanguage languages2 : languages1) {
            System.out.println(languages2.getName() + " - " + languages2.getYearOfCreation() + " - " + languages2.getIde());
        }

        //Adds the elements of the first Language Set, stores each language sorted by IDE order with a TreeSet, and displays each language via a For-Each
        System.out.println("\nIDE order: ");
        Set<FavoriteLanguage> languages2 =new TreeSet<>(new IdeComparator());
        languages2.addAll(languages);
        for (FavoriteLanguage languages3 : languages2) {
            System.out.println(languages3.getName() + " - " + languages3.getYearOfCreation() + " - " + languages3.getIde());
        }

        //Adds the elements of the first Language Set, stores each language organized by year of creation with a TreeSet and displays each language through a For-Each
        System.out.println("\nYear of creation and name order: ");
        Set<FavoriteLanguage> languages3 = new TreeSet<>(new YearOfCreationNameComparator());
        languages3.addAll(languages);
        for (FavoriteLanguage languages4 : languages2) {
            System.out.println(languages4.getName() + " - " + languages4.getYearOfCreation() + " - " + languages4.getIde());
        }

        //Adds the elements from the first Language Set, stores each language sorted by name, year of creation and IDE with a TreeSet, and displays each language through a For-Each
        System.out.println("\nName, year of creation and IDE order: ");
        Set<FavoriteLanguage> languages4 = new TreeSet<>(new NameYearOfCreationIdeComparator());
        languages4.addAll(languages);
        for (FavoriteLanguage languages5 : languages2) {
            System.out.println(languages5.getName() + " - " + languages5.getYearOfCreation() + " - " + languages5.getIde());
        }

        //Adds the elements from the first Language Set, stores each language in insertion order with a LinkedHashSet, and displays each language one below the other via a For-Each
        System.out.println("\nDisplay the languages in the console, one below the other: ");
        Set<FavoriteLanguage> languages5 = new LinkedHashSet<>(languages);
        for (FavoriteLanguage favoriteLanguage : languages5) {
            System.out.println(favoriteLanguage.getName());
        }
    }
}

//Compares each ide and returns sorted elements
class IdeComparator implements Comparator<FavoriteLanguage> {
    @Override
    public int compare(FavoriteLanguage l1, FavoriteLanguage l2) {
        int ide = l1.getIde().compareToIgnoreCase(l2.getIde());
        if (ide != 0) return ide;
        return ide;
    }
}

//Compares each year of creation and returns sorted elements
class YearOfCreationNameComparator implements Comparator<FavoriteLanguage> {
    @Override
    public int compare(FavoriteLanguage l1, FavoriteLanguage l2) {
        int yearOfCreation = Integer.compare(l1.getYearOfCreation(), l2.getYearOfCreation());
        if (yearOfCreation != 0) return yearOfCreation;

        return l1.getName().compareToIgnoreCase(l2.getName());
    }
}

//Compares each name, creation year and IDE and returns sorted elements
class NameYearOfCreationIdeComparator implements Comparator<FavoriteLanguage> {
    @Override
    public int compare(FavoriteLanguage l1, FavoriteLanguage l2) {
        int name = l1.getName().compareToIgnoreCase(l2.getName());
        if (name != 0) return name;

        int yearOfCreation = Integer.compare(l1.getYearOfCreation(), l2.getYearOfCreation());
        if (yearOfCreation != 0) return yearOfCreation;

        return l1.getIde().compareToIgnoreCase(l2.getIde());
    }
}
