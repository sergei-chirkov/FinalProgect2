package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.entity.Organizm;
import ru.javarush.chirkov.view.Statistics;

import java.util.*;

public class TaskReproduct extends Tasks {

    private static final List<Reproduct> queue = new ArrayList<>();

    public static class Reproduct {
        private final Organizm organizm;
        private final int countReproduct;
        private final Location location;

        public Reproduct(Organizm organizm, int countReproduct, Location location) {
            this.organizm = organizm;
            this.countReproduct = countReproduct;
            this.location = location;
            queue.add(this);
        }
    }

    @Override
    public void run() {
        getLockTask().lock();
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
                        queue.add(new Reproduct(organizm, reproduct, location));
                    }

                }
            }

        }
        queue.forEach(taskReproduct -> taskReproduct.organizm.reproduction(taskReproduct.countReproduct, taskReproduct.location));
        queue.clear();
        getLockTask().unlock();
    }


}






