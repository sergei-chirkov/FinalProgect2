package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.entity.Animal;

import java.util.ArrayList;
import java.util.List;

public class TaskMove extends Tasks {

    public static List<Move> queue = new ArrayList<>();

    public static class Move {
        private final Location oldLocation;
        private final Animal animal;

        public Move(Animal animal, Location oldLocation) {
            this.oldLocation = oldLocation;
            this.animal = animal;
            queue.add(this);
        }
    }

    @Override
    public void run() {
        getLockTask().lock();
        Island island = Island.getInstance();
        island.locations.forEach(location -> location.organizms.stream()
                .filter(organizm -> organizm instanceof Animal)
                .forEach(organizm -> new Move((Animal) organizm, location)));

        queue.forEach(taskMove -> taskMove.animal.move(taskMove.oldLocation));
        queue.clear();
        getLockTask().unlock();
    }

}


