package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*Given the following information about my favorite books and their authors,
create a dictionary and sort this dictionary:
displaying (Author Name - Book Name);

Author = Hawking, Stephen - Book = name: A Brief History of Time, pages: 256
Author = Duhigg, Charles - Book = name: The Power of Habit, pages: 408
Author = Harari, Yuval Noah - Book = 21 Lessons for the 21st Century, pages: 432
*/

public class MapSortExample {
    public static void main(String[] args) {
        
        System.out.println("Random Order: ");
        Map<String, Book> myBooks = new HashMap<>(){{
            put("Hawking, Stephen", new Book("A Brief History of Time", 256));
            put("Duhigg, Charles", new Book("The Power of Habit", 408));
            put("Harari, Yuval Noah", new Book("21 Lessons for the 21st Century", 432));
        }};
        for (Map.Entry<String, Book> book : myBooks.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getBookName());
        }

        System.out.println("\nInsertion order: ");
        Map<String, Book> myBooks1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Book("A Brief History of Time", 256));
            put("Duhigg, Charles", new Book("The Power of Habit", 408));
            put("Harari, Yuval Noah", new Book("21 Lessons for the 21st Century", 432));
        }};
        for (Map.Entry<String, Book> book1 : myBooks1.entrySet()) {
            System.out.println(book1.getKey() + " - " + book1.getValue().getBookName());
        }

        System.out.println("\nAlphabetical order by authors: ");
        Map<String, Book> myBooks2 = new TreeMap<>(myBooks1);
        for (Map.Entry<String, Book> book2 : myBooks2.entrySet()) {
            System.out.println(book2.getKey() + " - " + book2.getValue().getBookName());
        }

        System.out.println("\nAlphabetical order by book names: ");
        Set<Map.Entry<String, Book>> myBooks3 = new TreeSet<>(new BookNameComparator());
        myBooks3.addAll(myBooks1.entrySet());
        for (Map.Entry<String,Book> book3 : myBooks3) {
            System.out.println(book3.getKey() + " - " + book3.getValue().getBookName());
        }

        System.out.println("\nOrder by page number: "); //challenge - challenge completed
        Set<Map.Entry<String, Book>> myBooks4 = new TreeSet<>(new PageNumberComparator());
        myBooks4.addAll(myBooks1.entrySet());
        for (Map.Entry<String,Book> book4 : myBooks4) {
            System.out.println(book4.getKey() + " - " + book4.getValue().getBookName());
        }
    }
}

class Book {
    private String bookName;
    private Integer pageNumber;

    public Book(String bookName, Integer pageNumber) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return bookName.equals(book.bookName) && pageNumber.equals(book.pageNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName, pageNumber);
    }

    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", pageNumber=" + pageNumber + "]";
    }
}

class BookNameComparator implements Comparator<Map.Entry<String, Book>>{

    @Override
    public int compare(Entry<String, Book> b1, Entry<String, Book> b2) {
        return b1.getValue().getBookName().compareToIgnoreCase(b2.getValue().getBookName());
    }
}

class PageNumberComparator implements Comparator<Map.Entry<String, Book>>{

    @Override
    public int compare(Entry<String, Book> b1, Entry<String, Book> b2) {
        return Integer.compare(b1.getValue().getPageNumber(), b2.getValue().getPageNumber());
    }
}