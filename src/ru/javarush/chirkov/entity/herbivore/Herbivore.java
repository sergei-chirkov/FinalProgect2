package ru.javarush.chirkov.entity.herbivore;

import ru.javarush.chirkov.entity.Animal;

import java.util.Map;

public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int maxAnimal, int speed, double needfood, Map<String,Integer> mapForEat) {
        super(weight, maxAnimal, speed, needfood, mapForEat);
    }

}