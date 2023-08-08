package ru.javarush.chirkov.view;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.island.Location;

import java.util.HashMap;
import java.util.Map;

public class Statistics {


    public void getStatistics(){
        Island island = Island.getInstance();
        island.locations.forEach(Location::print);
    }
}
