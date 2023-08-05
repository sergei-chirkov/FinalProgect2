package ru.javarush.chirkov.view;

import ru.javarush.chirkov.island.Island;

public class Statistics {
    Island island = Island.getInstance();

    public void getStatistics(){
        island.locations.stream().map(location -> location.organizms).forEach(System.out::println);
    }
}
