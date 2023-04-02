package set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// According to my favorite serie create and order a set displaying:
// (name - genre - episode time);

// Serie 1 = name: got, genre: fantasy, episodeTime: 60
// Serie 2 = name: dark, genre: drama, episodeTime: 60
// Serie 3 = name: that '70s show, genre: comedy, episodeTime: 25

public class ExampleSortSet {
    public static void main(String[] args) {
        
        //Sorts and shows all series in random order
        System.out.println("Random order: ");
        Set<Series> mySeries = new HashSet<>(){{
            add(new Series("got", "fantasy", 60));
            add(new Series("dark", "drama", 60));
            add(new Series("that '70s", "comedy", 25));
        }};
        for (Series serie : mySeries) {
            System.out.println(serie.getName() + " - "
            + serie.getGenre() + " - " + serie.getEpisodeTime());
        }

        //Sorts and shows all series in insertion order
        System.out.println("\nInsertion order: ");
        Set<Series> mySeries1 = new LinkedHashSet<>(){{
            add(new Series("got", "fantasy", 60));
            add(new Series("dark", "drama", 60));
            add(new Series("that '70s show", "comedy", 25));
        }};
        for (Series serie1 : mySeries1) {
            System.out.println(serie1.getName() + " - "
            + serie1.getGenre() + " - " + serie1.getEpisodeTime());
        }

        //Sorts and shows all series in natural order by episodeTime value
        System.out.println("\nNatural order(episodeTime): ");
        Set<Series> mySeries2 = new TreeSet<>(mySeries1);
        for (Series serie2 : mySeries2) {
            System.out.println(serie2.getName() + " - "
            + serie2.getGenre() + " - " + serie2.getEpisodeTime());
        }
        
        //Sorts and shows all series by name, genre and episode time order
        System.out.println("\nOrder of Name/Genre/EpisodeTime: ");
        Set<Series> mySeries3 = new TreeSet<>(new NameGenreEpisodeTimeComparator());
        mySeries3.addAll(mySeries);
        for (Series serie3 : mySeries3) {
            System.out.println(serie3.getName() + " - "
            + serie3.getGenre() + " - " + serie3.getEpisodeTime());
        }
        
        //Sorts and shows all series by genre order
        System.out.println("\nGenre order: ");
        Set<Series> mySeries4 = new TreeSet<>(new GenreComparator());
        mySeries4.addAll(mySeries);
        for (Series serie4 : mySeries4) {
            System.out.println(serie4.getName() + " - "
            + serie4.getGenre() + " - " + serie4.getEpisodeTime());            
        }

        //Sorts and shows all series by episode time order
        System.out.println("\nepisodeTime order: ");
        Set<Series> mySeries5 = new TreeSet<>(new EpisodeTimeComparator());
        mySeries5.addAll(mySeries);
        for (Series serie5 : mySeries5) {
            System.out.println(serie5.getName() + " - "
            + serie5.getGenre() + " - " + serie5.getEpisodeTime());
        }
    }
}

//Implements the Comparator and makes the comparisons to later return the series sorted by name, genre and episode time
class NameGenreEpisodeTimeComparator implements Comparator<Series> {

    @Override
    public int compare(Series s1, Series s2) {
        int name = s1.getName().compareTo(s2.getName());
        if (name != 0) return name;

        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre != 0) return genre;

        return Integer.compare(s1.getEpisodeTime(), s2.getEpisodeTime());
    }
}

//Implements the Comparator and makes the comparisons to later return the series sorted by genre
class GenreComparator implements Comparator<Series> {

    @Override
    public int compare(Series s1, Series s2) {
        int genre = s1.getGenre().compareTo(s2.getGenre());
        if (genre != 0) return genre;
        return genre;
    }
}

//Implements the Comparator and makes the series comparisons to later return the series sorted by episode time
class EpisodeTimeComparator implements Comparator<Series> {

    @Override
    public int compare(Series s1, Series s2) {
        int episodeTime = s1.getEpisodeTime().compareTo(s2.getEpisodeTime());
        if (episodeTime != 0) return episodeTime;
        
        return s1.getName().compareTo(s2.getName());
    }
}