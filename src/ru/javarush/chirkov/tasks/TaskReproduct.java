package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.view.Statistics;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class TaskReproduct {
    void reproduct(){
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        for(Location location:island.locations){
            Set<Organizm> organizmSet = new HashSet<>(location.organizms);
            Map<Organizm, Integer> mapOrganizmGenderMale = statistics.getMapOrganizmGender(location.organizms, Organizm.FEMALE);
            Map<Organizm, Integer> mapOrganizmGenderFemale = statistics.getMapOrganizmGender(location.organizms, Organizm.MALE);
            for(Organizm organizm: organizmSet){
                int female = 0 ,male = 0;

                if(mapOrganizmGenderFemale.get(organizm) != null){
                    female = mapOrganizmGenderFemale.get(organizm);
                }
                if(mapOrganizmGenderMale.get(organizm) != null){
                    male = mapOrganizmGenderMale.get(organizm);
                }
                System.out.println(Math.min(male, female));
                int countForReproduction = Math.min(male, female);
                if(countForReproduction > 0) {
                    Random random = new Random();
                    int reproduct = random.nextInt(countForReproduction);
                    System.out.println(organizm.getClass());
                    location.organizms.add(organizm);
                }
            }
        }

    }


}
