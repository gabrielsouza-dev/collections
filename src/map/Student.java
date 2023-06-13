package map;

import java.util.Objects;

//To Learn More:

//Create a Student class that has the following attributes: name, registration.

public class Student {
    private String name;
    private Integer registration;

    public Student(String name, Integer registration) {
        this.name = name;
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public Integer getRegistration() {
        return registration;
    }

    @Override
    public String toString() {
        return "Student {name=" + name + ", registration=" + registration + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return name.equals(student.name) && registration.equals(student.registration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, registration);
    }
}
