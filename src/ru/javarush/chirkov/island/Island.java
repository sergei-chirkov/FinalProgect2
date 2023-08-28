package ru.javarush.chirkov.island;

import ru.javarush.chirkov.FactoryAnimal;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private final int lenght = 2;
    private final int height = 2;
    private static Island island;

    public List<Location> locations = new ArrayList<>();

    private Island() {
        //creat island
        for (int i = 0; i < lenght * height; i++) {
            locations.add(new Location(i));
        }
        //add Organizm to Isaland
        locations.forEach(Location::addOrganizm);

    }

    public static Island getInstance() {
        if (island == null) {
            island = new Island();
        }
        return island;
    }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() {
        return height;
    }



}
