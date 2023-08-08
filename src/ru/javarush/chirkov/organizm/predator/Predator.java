package ru.javarush.chirkov.organizm.predator;

import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Animal;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxAnimal, int speed, double needfood ) {
        super(weight, maxAnimal, speed, needfood);
    }

    @Override
    public void eat(Location location) {

    }
}
