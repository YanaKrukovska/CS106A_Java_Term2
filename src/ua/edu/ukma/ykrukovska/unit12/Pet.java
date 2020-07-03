package ua.edu.ukma.ykrukovska.unit12;

import java.util.Objects;

public class Pet implements Comparable{

    private String kind;
    private String name;

    public Pet(String kind, String name) {
        this.kind = kind;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(kind, pet.kind) &&
                Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, name);
    }

    @Override
    public String toString() {
        return kind + " " + name;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
