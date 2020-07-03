package ua.edu.ukma.ykrukovska.unit12;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {

    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();
        tasks.add("make dinner");
        tasks.add("make lunch");
        for (String task : tasks) {
            System.out.println(task);
        }

        Set<Integer> accounts = new TreeSet<>();
        accounts.add(1);
        accounts.add(6);
        accounts.add(2);
        accounts.add(1);
        for (Integer account : accounts) {
            System.out.println(account);
        }

        Set<Pet> pets = new TreeSet<>();
        pets.add(new Pet("cat", "Rita"));
        pets.add(new Pet("cat", "Rita"));
        pets.add(new Pet("monkey", "Erzhan"));
        for (Pet pet : pets) {
            System.out.println(pet);
        }

    }
}
