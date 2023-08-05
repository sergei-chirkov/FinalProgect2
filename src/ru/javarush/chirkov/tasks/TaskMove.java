package ru.javarush.chirkov.tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.*;

public class TaskMove extends Task{
    private final int oldLocation;
    private final Organizm organizm;
    private final int newLocation;

    public TaskMove(Organizm organizm, int oldLocation, int newLocation) {
        this.organizm = organizm;
        this.oldLocation = oldLocation;
        this.newLocation = newLocation;
    }


    public void start() {
        Island island = Island.getInstance();
        // remove organizm in the Old Location;
        island.locations.get(oldLocation).organizms.remove(organizm);

        // get list organizn ij the new location
        List<Organizm> list = island.locations.get(newLocation).organizms;
        long count = list.stream().filter(organizm1 -> organizm1.getClass().equals(organizm.getClass())).count();

        //check and add organizm in the new Location
        if(organizm.getMaxAnimal() > count){
            island.locations.get(newLocation).organizms.add(organizm);
        }
    }
}
