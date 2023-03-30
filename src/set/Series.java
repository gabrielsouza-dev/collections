package set;

import java.util.Objects;

//Create variables for all series and implement Comparable to make comparisons possible from getters
public class Series implements Comparable<Series> {
    private String name;
    private String genre;
    private Integer episodeTime;

    //Turns variables into objects
    public Series(String name, String genre, Integer episodeTime) {
        this.name = name;
        this.genre = genre;
        this.episodeTime = episodeTime;
    }

    //Define the getters
    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getEpisodeTime() {
        return episodeTime;
    }

    //Overwrites the attributes using the toString method which returns a more organized representation of the objects
    @Override
    public String toString() {
        return "{" + 
               "name:" + name + " - " +
               "genre:" + genre + " - " +
               "episodeTime:" + episodeTime +
               "}";
    }

    //Overwrites the equals method for each object to resolve false equality conflicts in comparisons
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Series serie = (Series) obj;
        return name.equals(serie.name) && genre.equals(serie.genre) && episodeTime.equals(serie.episodeTime);
    }
    
    //Overwrites the hashCode method for each object to resolve false equality conflicts in comparisons
    @Override
    public int hashCode() {
        return Objects.hash(name, genre, episodeTime);
    }

    //Overwrites the objects and make the series comparisons to later return sorted by episode time
    @Override
    public int compareTo(Series serie) {
        int episodeTime = Integer.compare(this.getEpisodeTime(), serie.getEpisodeTime());
        if (episodeTime != 0) return episodeTime;

        return this.getGenre().compareTo(serie.getGenre());
    }
}
