package ru.javarush.chirkov.island;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.organizm.Organizm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Location {
    private int id;

    public List<Organizm> organizms;

    public Location(int id) {
        this.organizms = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void print() {
        organizms.forEach(System.out::println);

    }

    public void addOrganizm() {
        Organizm herbivore = FactoryAnimal.createHerbivore();
        Organizm predator = FactoryAnimal.createPredator();
        Organizm plants = FactoryAnimal.createPlants();
        Random random = new Random();

        if(herbivore!=null){
            int valueHerbivore = random.nextInt(herbivore.getMaxAnimal());
            for (int i = 0; i < valueHerbivore; i++) {
                organizms.add(herbivore);
            }
        }
        if (predator != null){
            int valuePredator = random.nextInt(plants.getMaxAnimal());
            for (int i = 0; i < valuePredator; i++) {
                organizms.add(predator);
            }
        }

        if(plants != null){
            int valuePlants = random.nextInt(plants.getMaxAnimal());
            for (int i = 0; i < valuePlants; i++) {
                organizms.add(plants);
            }
        }
    }



}
