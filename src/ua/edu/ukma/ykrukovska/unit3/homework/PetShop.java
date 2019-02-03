package ua.edu.ukma.ykrukovska.unit3.homework;

import java.util.Arrays;

public class PetShop {

    private String address;
    private String name;
    private String workingHours;
    private Employee[] workers;
    private Cat[] cats;
    private Parrot[] parrots;

    public void sellCat(Cat catForSell){
        System.out.println("Cat for sell: " + catForSell);
    }

    public void sellParrot(Parrot parrotForSell){
        System.out.println("Parrot for sell: " + parrotForSell);
    }

    public void getCatForSell(Cat[] newCats){

    }

    public void getParrotForSell(Parrot[] newParrots){

    }

    public void hireEmployee (Employee newEmployee){

    }

    public void listOfPets (){

    }

    @Override
    public String toString() {
        return "PetShop{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", workers=" + Arrays.toString(workers) +
                ", cats=" + Arrays.toString(cats) +
                ", parrots=" + Arrays.toString(parrots) +
                '}';
    }
}
