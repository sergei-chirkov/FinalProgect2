package ru.javarush.chirkov.view;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.entity.Organizm;

import java.util.*;

public class Statistics {

    Island island = Island.getInstance();
    public void getStatistics() {

        List<Location> locations = island.locations;

        for (Location location : locations) {
            Map<Organizm, Integer> mapCountOrganizm = getMapCountOrganizm(location.organizms);
            System.out.print("location " + location.getId() + " ");
            mapCountOrganizm.forEach((key, value) -> System.out.print(key + " " + value + " "));
            System.out.print("\n");
        }

    }


    public Map<Organizm, Integer> getMapCountOrganizm(List<Organizm> organizms) {

        Map<Organizm, Integer> map = new HashMap<>();
        Set<Organizm> organizmSet = new HashSet<>(organizms);

        for (Organizm organizm : organizmSet) {
            int count = 0;
            for (Organizm org : organizms) {
                if (org.getClass().equals(organizm.getClass())) {
                    count++;

                }
            }
            map.put(organizm, count);
        }

        return map;
    }

    public Map<Organizm, Integer> getMapOrganizmGender(List<Organizm> organizms, String gender) {
        Map<Organizm, Integer> map = new HashMap<>();
        Set<Organizm> organizmSet = new HashSet<>(organizms);
        for (Organizm organizm : organizmSet) {
            int count = 0;
            for (Organizm org : organizms) {

                if (org.getClass().equals(organizm.getClass()) && org.isGender().equals(gender)) {
                    count++;
                }
            }
            if (count > 0) {
                map.put(organizm, count);
            }
        }
        return map;
    }

    public int getPeriod(){
        return island.getPeriod();
    }

}
