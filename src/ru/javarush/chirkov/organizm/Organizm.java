package ru.javarush.chirkov.organizm;

import java.util.Random;

public class Organizm {
    private final int weight;
    private final int maxAnimal;
    private final int speed;
    private final double needfood;
    private final boolean sex;

    {
        Random random = new Random();
        sex = random.nextBoolean();
    }

    public Organizm(int weight, int maxAnimal, int speed, double needfood) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
    }

    public int getWeight() {
        return weight;
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
}
