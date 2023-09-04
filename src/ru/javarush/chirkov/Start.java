package ru.javarush.chirkov;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.tasks.StartGame;
import ru.javarush.chirkov.view.Statistics;

import java.io.IOException;

public class Start {
    public static void main(String[] args) {

        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        statistics.getStatistics();
        StartGame task = new StartGame();
        task.start();






    }


}