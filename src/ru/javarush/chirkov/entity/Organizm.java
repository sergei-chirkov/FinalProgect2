package ru.javarush.chirkov.entity;

import ru.javarush.chirkov.repository.FactoryAnimal;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.servesice.Reproduction;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Organizm implements Reproduction {
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    private final Map<String, Integer> mapForEat;
    private double weight;
    private final int maxAnimal;
    private final int speed;
    private final double needfood;

    // if true - male else false female
    private final String gender;

    private boolean isLife;
    private double foodStatus;
    private final double needFoodEveryDay;

    {
        Random random = new Random();
        if (random.nextBoolean()) {
            gender = MALE;
        } else {
            gender = FEMALE;
        }

        isLife = true;
    }

    public Organizm(double weight, int maxAnimal, int speed, double needfood, Map<String, Integer> mapForEat) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
        this.foodStatus = needfood / 2;
        this.mapForEat = mapForEat;
        this.needFoodEveryDay = foodStatus / 2;
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

    public double getNeedFoodEveryDay() {
        return needFoodEveryDay;
    }

    public double getFoodStatus() {
        return foodStatus;
    }

    public Map<String, Integer> getMapForEat() {
        return mapForEat;
    }

    public String isGender() {
        String man = "Male";
        String woman = "Female";

        return gender.equals(MALE) ? man : woman;
    }


    public void setFoodStatus(double weightFood) {
//        double residue = weightFood - needfood + foodStatus;
//        this.foodStatus = Math.min(foodStatus + weightFood, needfood);
//
//        return residue > 0 ? residue : 0;

        foodStatus = weightFood;
    }

    public void setStausLifeIsDead() {
        this.isLife = false;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxAnimal, speed, needfood);
    }

    @Override
    public void reproduction(int countReprodoction, Location location) {

        location.getLock().lock();

        String nameClass = this.getClass().getSimpleName();
        FactoryAnimal.OrganizmType organizmType = FactoryAnimal.OrganizmType.valueOf(nameClass);

        for (int i = 0; i < countReprodoction; i++) {
            if(this.getMaxAnimal() > location.getCountOrganizm(this)) {
                location.organizms.add(FactoryAnimal.createOrganizm(organizmType));
            }
        }
        location.getLock().unlock();


    }
}
