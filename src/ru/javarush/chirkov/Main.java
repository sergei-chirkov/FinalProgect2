package ru.javarush.chirkov;

import ru.javarush.chirkov.island.*;

import ru.javarush.chirkov.tasks.Tasks;

import ru.javarush.chirkov.view.Statistics;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        statistics.getStatistics();

        Tasks task = new Tasks();
//        task.run();
        Thread thread = new Thread(task);
        thread.start();


    }


}