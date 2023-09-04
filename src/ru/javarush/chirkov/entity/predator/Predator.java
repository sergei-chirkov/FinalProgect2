package ru.javarush.chirkov.entity.predator;

import ru.javarush.chirkov.entity.Animal;

import java.util.Map;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxAnimal, int speed, double needfood, Map<String,Integer> mapForEat) {
        super(weight, maxAnimal, speed, needfood,mapForEat);
    }


}
