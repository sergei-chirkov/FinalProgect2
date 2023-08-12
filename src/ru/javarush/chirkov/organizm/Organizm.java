package ru.javarush.chirkov.organizm;

import java.util.Random;

public class Organizm {
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    private double weight;
    private final int maxAnimal;
    private final int speed;
    private final double needfood;

    // if true - male else false female
    private final String gender;

    private boolean isLife;
    private double foodStatus;

    {
        Random random = new Random();
        if (random.nextBoolean()) {
            gender = MALE;
        } else {
            gender = FEMALE;
        }

        isLife = true;
    }

    public Organizm(double weight, int maxAnimal, int speed, double needfood) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
        this.foodStatus = needfood / 2;
    }

    public boolean isLife() {
        return isLife;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double newWeight) {
        this.weight = newWeight;
    }

    public int getMaxAnimal() {
        return maxAnimal;
    }

    public int getSpeed() {
        return speed;
    }

    public double getNeedfood() {
        return needfood;
    }


    public double getFoodStatus() {
        return foodStatus;
    }

    public String isGender() {
        String man = "Male";
        String woman = "Female";

        return gender.equals(MALE) ? man : woman;
    }


    public double setFoodStatus(double weightFood) {
        double residue = weightFood - needfood + foodStatus;
        this.foodStatus = Math.min(foodStatus + weightFood, needfood);

        return residue > 0 ? residue : 0;
    }

    public void setStausLifeIsDead() {
        this.isLife = false;
    }
}
