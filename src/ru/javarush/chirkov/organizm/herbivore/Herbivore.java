package ru.javarush.chirkov.organizm.herbivore;

import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Animal;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.organizm.plants.Plants;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class Herbivore extends Animal {
    public Herbivore(int weight, int maxAnimal, int speed, double needfood) {
        super(weight, maxAnimal, speed, needfood);
    }


    @Override
    public void eat(Location location) {

        List<Organizm> plantsList = location.organizms.stream().filter(organizm -> organizm instanceof Plants).collect(Collectors.toList());
        plantsList.forEach(organizm -> {
            int weight = organizm.getWeight();
            if (this.getFoodStatus() < this.getNeedfood()) {
                setFoodStatus(weight);
                organizm.setStausLifeIsDead();
                organizm.setWeight(0);
            }
        });
    }
}