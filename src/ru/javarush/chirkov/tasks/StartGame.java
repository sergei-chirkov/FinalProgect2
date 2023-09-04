package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.tasks.*;
import ru.javarush.chirkov.view.Statistics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class StartGame extends Thread {
    private static final Queue<Tasks> tasksList = new LinkedList<>();


    @Override
    public void run() {
        Statistics statistics = new Statistics();

        tasksList.add(new TaskEat());
        tasksList.add(new TaskDied());
        tasksList.add(new TaskMove());
        tasksList.add(new TaskReproduct());
        tasksList.add(new TaskDay());
        tasksList.add(new TaskView());

        ExecutorService service = Executors.newFixedThreadPool(4);
        for (int i = 0; i < statistics.getPeriod(); i++) {
            tasksList.forEach(service::submit);
        }
        service.shutdown();

    }
}
