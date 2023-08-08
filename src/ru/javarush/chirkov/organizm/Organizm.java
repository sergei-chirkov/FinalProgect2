package ru.javarush.chirkov.organizm;

import java.util.Random;

public class Organizm {
    private int weight;
    private final int maxAnimal;
    private final int speed;
    private final double needfood;
    private final boolean sex;
    private  boolean isLife;
    private  double foodStatus;

    {
        Random random = new Random();
        sex = random.nextBoolean();
        isLife = true;
    }

    public Organizm(int weight, int maxAnimal, int speed, double needfood) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
        this.foodStatus = 0.0;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int newWeight){this.weight = newWeight;}
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
    public void setFoodStatus(double weightFood){
        this.foodStatus = Math.min(foodStatus + weightFood, needfood);
        double differen = needfood - foodStatus;
        return ;
    }
    public void setStausLifeIsDead(){
        this.isLife = false;
    }
}
