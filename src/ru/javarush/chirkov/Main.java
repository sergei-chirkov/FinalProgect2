package ru.javarush.chirkov;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.organizm.predator.Wolf;
import ru.javarush.chirkov.tasks.TaskMove;
import ru.javarush.chirkov.tasks.Tasks;
import ru.javarush.chirkov.view.Statistics;

import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
//        statistics.getStatistics();
        Tasks task = new Tasks();
        Thread thread = new Thread(task);
        thread.start();



    }


}