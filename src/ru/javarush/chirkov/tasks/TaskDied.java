package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.entity.Organizm;
import ru.javarush.chirkov.servesice.Died;

import java.util.List;


public class TaskDied extends Tasks{
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

        island.locations.forEach(location -> location.organizms.stream()
                .filter(organizm -> organizm instanceof Died)
                .forEach(organizm -> ((Died) organizm).died()));
        List<Location> locationList = island.locations;
        for (Location location : locationList) {
            for (int j = 0; j < location.organizms.size(); j++) {
                if (!location.organizms.get(j).isLife()) {
                    Organizm organizm = location.organizms.get(j);
                    location.organizms.remove(organizm);
                }

            }
        }
        getLockTask().unlock();

    }

}
