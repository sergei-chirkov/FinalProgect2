package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.servesice.Died;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskDied {
    void run() {
        Island island = Island.getInstance();
        island.locations.forEach(location -> location.organizms.stream()
                .filter(organizm -> organizm instanceof Died)
                .forEach(organizm -> ((Died) organizm).died()));
        List<Location> locationList = island.locations;
       for (int i = 0; i < locationList.size(); i++){
            for (int j = 0; j < locationList.get(i).organizms.size(); j++){
                if(!locationList.get(i).organizms.get(j).isLife()){
                    Organizm organizm = locationList.get(i).organizms.get(j);
                    locationList.get(i).organizms.remove(organizm);
                }

                }
            }

//        Island island1 = Island.getInstance();
    }

}
