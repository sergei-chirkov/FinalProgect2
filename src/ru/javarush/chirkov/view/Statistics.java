package ru.javarush.chirkov.view;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;

import java.util.*;

public class Statistics {


    public void getStatistics() {
        Island island = Island.getInstance();
        List<Location> locations = island.locations;
        for (Location location : locations) {
            Map<Organizm, Integer> mapCountOrganizm = getMapCountOrganizm(location.organizms);
            System.out.print("location " + location.getId() + " ");
            mapCountOrganizm.forEach((key, value) -> System.out.print(key + " " + value + " "));
            System.out.print("\n");
//            Map<Organizm, Integer> mapOrganizmGenderMale = getMapOrganizmGender(location.organizms, Organizm.MALE);
//            Map<Organizm, Integer> mapOrganizmGenderFemale = getMapOrganizmGender(location.organizms, Organizm.FEMALE);
//            mapOrganizmGenderMale.forEach((key, value) -> System.out.print("\tMale " + key + " " + value + " "));
//            System.out.print("\n");
//            mapOrganizmGenderFemale.forEach((key, value) -> System.out.print("\tFemale " + key + " " + value + " "));
//            System.out.print("\n");
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

}
