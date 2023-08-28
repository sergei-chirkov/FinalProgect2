package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.view.Statistics;



public class Tasks implements Runnable {

    @Override
    public void run() {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();

        statistics.getStatistics();
        System.out.println("Task Move");
        TaskMove.run(island);
        statistics.getStatistics();

        System.out.println("Task Eat");
        TaskEat taskEat = new TaskEat();
        taskEat.run(island);
        statistics.getStatistics();

        System.out.println("Task Died");
        TaskDied taskDied = new TaskDied();
        taskDied.run();
        statistics.getStatistics();

        System.out.println("Task Reproduct");
        TaskReproduct.run();
        statistics.getStatistics();

    }
}
