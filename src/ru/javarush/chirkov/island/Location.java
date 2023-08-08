package ru.javarush.chirkov.island;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.organizm.Organizm;

import java.util.*;
import java.util.stream.Collectors;

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
            int valuePredator = random.nextInt(predator.getMaxAnimal());
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

    public void  print(){
        System.out.println("location " + id);
        Map<Organizm,Integer> map = new HashMap<>();
        Set<Organizm> organizmSet = new HashSet<>(organizms);
        for (Organizm organizm : organizmSet) {
            int count = 0;
            for (Organizm org : organizms){
                if(org.getClass().equals(organizm.getClass())){
                    count++;
                }

            }
            map.put(organizm,count);
        }
      map.forEach((key, value)-> System.out.println(key + " " + value));

    }



}
