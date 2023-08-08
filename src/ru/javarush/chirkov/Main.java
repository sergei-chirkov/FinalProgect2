package ru.javarush.chirkov;

import ru.javarush.chirkov.island.*;
import ru.javarush.chirkov.organizm.herbivore.*;
import ru.javarush.chirkov.organizm.predator.*;
import ru.javarush.chirkov.servesice.*;
import ru.javarush.chirkov.organizm.Animal;
import ru.javarush.chirkov.tasks.Task;
import ru.javarush.chirkov.tasks.TaskMove;
import ru.javarush.chirkov.view.Statistics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        statistics.getStatistics();
        island.locations.stream().
                forEach(location -> location.organizms.forEach(organizm -> {
        if (organizm instanceof Animal){((Animal) organizm).move();}}));
        Task task = new Task();
//        task.run();
        Thread thread = new Thread(task);
        thread.start();
        statistics.getStatistics();
    }


}