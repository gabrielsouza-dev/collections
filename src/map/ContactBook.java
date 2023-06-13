package map;

import java.util.Objects;

public class ContactBook {
    private String name;
    private Integer number;

    public ContactBook(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ContactBook contactBook = (ContactBook) obj;
        return name.equals(contactBook.name) && number.equals(contactBook.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Contact{" +
               "name=" + name + 
               ", number=" + number + 
               "}";
    }
}
