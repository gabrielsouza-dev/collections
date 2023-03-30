package list;

/*Given the following information about my cats, create a list
and sort this list by displaying:
(name - age - color);

Cat 1 = name: Jon, age: 18, color: black
Cat 2 = name: Simba, age: 6, color: brindle
Cat 3 = name: Jon, age: 12, color: yellow
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleSortingList {
    public static void main(String[] args) {
        List<Cat> myCats = new ArrayList<>(){{
            add(new Cat("Jon", 12, "black"));
            add(new Cat("Simba", 6, "brindle"));
            add(new Cat("Jon", 18, "yellow"));
        }};
        myCats.sort(Comparator.comparing(Cat::getName));


        System.out.println("--\tInsertion Order\t---");
        System.out.println(myCats);

        System.out.println("--\tRandom order\t---");
        Collections.shuffle(myCats);
        System.out.println(myCats);

        System.out.println("--\tNatural Order (Name)\t---");
        Collections.sort(myCats);
        System.out.println(myCats);

        System.out.println("--\tAge Order\t---");
// Collections.sort(myCats, new ComparatorAge());
        myCats.sort(new ComparatorAge());
        System.out.println(myCats);

        System.out.println("--\tColor Order\t---");
// Collections.sort(myCats, new ComparatorColor());
        myCats.sort(new ComparatorColor());
        System.out.println(myCats);

        System.out.println("--\tOrder Name/Color/Age\t---");
// Collections.sort(myCats, new ComparatorNameColorIdade());
        myCats.sort(new ComparatorNameColorAge());
        System.out.println(myCats);
    }
}

class Cat implements Comparable<Cat>{
    private String name;
    private Integer age;
    private String color;

    public Cat(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareToIgnoreCase(cat.getName());
    }
}

class ComparatorAge implements Comparator<Cat> {
    @Override
    public int compare(Cat c1, Cat c2) {
        return Integer.compare(c1.getAge(), c2.getAge());
    }
}

class ComparatorColor implements Comparator<Cat> {

    @Override
    public int compare(Cat c1, Cat c2) {
        return c1.getColor().compareToIgnoreCase(c2.getColor());
    }
}

class ComparatorNameColorAge implements Comparator<Cat> {

    @Override
    public int compare(Cat c1, Cat c2) {
        int name = c1.getName().compareToIgnoreCase(c2.getName());
        if (name != 0) return name;

        int color = c1.getColor().compareToIgnoreCase(c2.getColor());
        if(color !=0) return color;

        return Integer.compare(c1.getAge(), c2.getAge());
    }
}
