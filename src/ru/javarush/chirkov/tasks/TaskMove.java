package ru.javarush.chirkov.tasks;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.*;

public class TaskMove {

    private final int oldLocation;
    private final Animal animal;
    private final int newLocation;

    public static Queue<TaskMove> queue = new LinkedList<>();

    public TaskMove(Animal animal, int oldLocation, int newLocation) {
        this.animal = animal;
        this.oldLocation = oldLocation;
        this.newLocation = newLocation;
        queue.add(this);
    }




    public void run() {
       animal.move(oldLocation,newLocation);
        }
    }

