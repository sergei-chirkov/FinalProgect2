package ru.javarush.chirkov.island;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.organizm.Organizm;

import java.util.*;

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
        int length = FactoryAnimal.OrganizmType.values().length;
        Random random = new Random();
        for(int i = 0; i < 3; i ++){
            FactoryAnimal.OrganizmType organizmType = FactoryAnimal.generatorTypeOrganizm();
            Organizm organizm = FactoryAnimal.createOrganizm(organizmType);
            int maxAnimal = organizm.getMaxAnimal();
            for (int j = 0; j < random.nextInt(maxAnimal); j++){
                organizms.add(FactoryAnimal.createOrganizm(organizmType));
            }
        }
    }
}
