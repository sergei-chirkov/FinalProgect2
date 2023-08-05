package ru.javarush.chirkov.island;

import ru.javarush.chirkov.organizm.Organizm;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int id;

    public List<Organizm> organizms;

    public Location(int id) {
        this.organizms = new ArrayList<>();
        id = id;
    }
    public int getId() {
        return id;
    }

    public void print() {
       organizms.forEach(System.out::println);

    }
}
