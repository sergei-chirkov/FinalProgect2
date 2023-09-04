package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.entity.Organizm;

public class TaskDay extends Tasks {
    @Override
    public void run() {
        getLockTask().lock();

        Island island = Island.getInstance();

        for(Location location : island.locations){
            location.getLock().lock();

            for (Organizm organizm: location.organizms){

                double foodStatus = organizm.getFoodStatus();
                double newFoodStatus = foodStatus - organizm.getNeedFoodEveryDay();
                organizm.setFoodStatus(newFoodStatus);
            }
            location.getLock().unlock();
        }
        getLockTask().unlock();

    }
}
