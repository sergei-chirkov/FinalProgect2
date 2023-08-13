package ru.javarush.chirkov.organizm;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.servesice.Reproduction;
import ru.javarush.chirkov.view.Statistics;

import java.util.*;

public class Organizm implements Reproduction{
    public static final String MALE = "Male";
    public static final String FEMALE = "Female";
    private Map<String,Integer> mapForEat;
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

    public Organizm(double weight, int maxAnimal, int speed, double needfood, Map<String,Integer> mapForEat) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
        this.foodStatus = needfood / 2;
        this.mapForEat = mapForEat;
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

    public Map<String, Integer> getMapForEat() {
        return mapForEat;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organizm organizm = (Organizm) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxAnimal, speed, needfood);
    }

    @Override
    public void reproduction(int countReprodoction, int idLocation) {
        Island island = Island.getInstance();
        Location location = island.locations.get(idLocation);
        String nameClass = this.getClass().getSimpleName();
        FactoryAnimal.OrganizmType organizmType = FactoryAnimal.OrganizmType.valueOf(nameClass);
        for (int i = 0; i < countReprodoction; i++){
            location.organizms.add(FactoryAnimal.createOrganizm(organizmType));
        }
    }
}
