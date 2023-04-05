package set;

import java.util.Objects;

public class FavoriteLanguage implements Comparable<FavoriteLanguage> {
    //Create the variables to store the name, year of creation and IDE attributes
    private String name;
    private Integer yearOfCreation;
    private String ide;

    //Turns variables into objects
    public FavoriteLanguage(String name, int yearOfCreation, String ide) {
        this.name = name;
        this.yearOfCreation = yearOfCreation;
        this.ide = ide;
    }

    //Define the getters
    public String getName() {
        return name;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public String getIde() {
        return ide;
    }

    //Formats and organizes the display of the Set collection's add method to make it easier to enter data correctly
    @Override
    public String toString() {
        return "{" + 
        "name:" + name + " - " + 
        "yearOfCreation:" + yearOfCreation + " - " +
        "ide:" + ide + "}";
    }

    //Compares the elements of each language and arranges them in natural order(name)
    @Override
    public int compareTo(FavoriteLanguage favoriteLanguages) {
        return this.name.compareToIgnoreCase(favoriteLanguages.name);
    }
    
    //Ensures that two objects of the same type and with the same content can be considered equal
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FavoriteLanguage language = (FavoriteLanguage) obj;
        return name.equals(language.name) && yearOfCreation.equals(language.yearOfCreation) && ide.equals(language.ide);
    }
    
    //Determines in which memory position each element is avoiding possible false matches for elements with the same number of letters, for example.
    @Override
    public int hashCode() {
        return Objects.hash(name , yearOfCreation, ide);
    }
}