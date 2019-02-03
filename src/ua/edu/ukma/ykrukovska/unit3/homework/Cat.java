package ua.edu.ukma.ykrukovska.unit3.homework;

import java.math.BigDecimal;

public class Cat {

    private int age;
    private String breed;
    private String gender;
    private BigDecimal price;
    private boolean isVaccinated;

    public void eatFood(){

    }

    public void sleep(){

    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", price=" + price +
                ", isVaccinated=" + isVaccinated +
                '}';
    }
}
