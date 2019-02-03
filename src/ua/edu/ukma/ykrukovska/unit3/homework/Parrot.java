package ua.edu.ukma.ykrukovska.unit3.homework;

import java.math.BigDecimal;

public class Parrot {

    private int age;
    private String breed;
    private String gender;
    private BigDecimal price;

    public void eatFood(){

    }

    public void makeNoise(){

    }

    @Override
    public String toString() {
        return "Parrot{" +
                "age=" + age +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                '}';
    }
}
