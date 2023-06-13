package map;

import java.util.Objects;

//To Learn More:

//Create a class Discipline that has the attributes: name, duration

public class Discipline implements Comparable<Discipline> {
    private String name;
    private Integer duration;
    
    public Discipline(String discipline, Integer duration) {
        this.name = discipline;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Integer getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Discipline {discipline=" + name + ", duration=" + duration + "}";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Discipline discipline = (Discipline) obj;
        return this.name.equals(discipline.name) && duration.equals(discipline.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }

    @Override
    public int compareTo(Discipline discipline) {
        return this.getName().compareToIgnoreCase(discipline.getName());
    }
}
