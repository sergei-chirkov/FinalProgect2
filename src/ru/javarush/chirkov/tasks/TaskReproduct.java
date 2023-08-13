package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.servesice.Eating;
import ru.javarush.chirkov.servesice.Reproduction;
import ru.javarush.chirkov.view.Statistics;

import java.util.*;

public class TaskReproduct {
    private final Organizm organizm;
    private final int countReproduct;
    private final int idLocation;
    private static Queue<TaskReproduct> queue = new LinkedList<>();

    public TaskReproduct(Organizm organizm, int countReproduct, int location) {
        this.organizm = organizm;
        this.countReproduct = countReproduct;
        this.idLocation = location;
        queue.add(this);
    }

    static void run() {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        for (Location location : island.locations) {
            Set<Organizm> organizmSet = new HashSet<>(location.organizms);
            Map<Organizm, Integer> mapOrganizmGenderMale = statistics.getMapOrganizmGender(location.organizms, Organizm.FEMALE);
            Map<Organizm, Integer> mapOrganizmGenderFemale = statistics.getMapOrganizmGender(location.organizms, Organizm.MALE);
            for (Organizm organizm : location.organizms) {
                int female = 0, male = 0;
                if (organizmSet.contains(organizm)) {
                    if (mapOrganizmGenderFemale.get(organizm) != null) {
                        female = mapOrganizmGenderFemale.get(organizm);
                    }

                    if (mapOrganizmGenderMale.get(organizm) != null) {
                        male = mapOrganizmGenderMale.get(organizm);
                    }
                    int countForReproduction = Math.min(male, female);

                    if (countForReproduction > 0) {
                        Random random = new Random();
                        int reproduct = random.nextInt(2);
                        queue.add(new TaskReproduct(organizm, reproduct, location.getId()));
                    }

                }
            }

        }
        queue.forEach(taskReproduct -> taskReproduct.organizm.reproduction(taskReproduct.countReproduct, taskReproduct.idLocation));
        queue.clear();

    }


}






