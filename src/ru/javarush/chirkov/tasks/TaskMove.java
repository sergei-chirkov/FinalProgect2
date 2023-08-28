package ru.javarush.chirkov.tasks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.*;

public class TaskMove {

    private final int oldLocation;
    private final Animal animal;


    public static Queue<TaskMove> queue = new LinkedList<>();

    public TaskMove(Animal animal, int oldLocation) {
        this.animal = animal;
        this.oldLocation = oldLocation;
        queue.add(this);
    }




    public static void run(Island island) {
        island.locations.forEach(location -> location.organizms.stream()
                .filter(organizm -> organizm instanceof Animal)
                .forEach(organizm -> new TaskMove((Animal) organizm, ((Animal) organizm).getLocation())));

        queue.forEach(taskMove -> taskMove.animal.move(taskMove.oldLocation));
        queue.clear();
        }

}


