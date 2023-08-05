package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;

import javax.swing.plaf.multi.MultiSliderUI;

public class TaskEat {
    private Organizm organizm;
    private Location location;

    public TaskEat(Organizm organizm, Location location) {
        this.organizm = organizm;
        this.location = location;
    }

    void start(){
        long count = location.organizms.stream().filter(organizm1 -> organizm1.getClass().equals(organizm.getClass())).count();

    }

}
