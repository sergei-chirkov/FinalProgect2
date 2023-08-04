package ru.javarush.chirkov.organizm.predator;

import ru.javarush.chirkov.organizm.Animal;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxAnimal, int speed, double needfood) {
        super(weight, maxAnimal, speed, needfood);
    }

}
