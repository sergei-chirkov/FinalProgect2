package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.Animal;
import ru.javarush.chirkov.view.Statistics;

import java.util.function.BiConsumer;

public class Tasks implements Runnable {

    @Override
    public void run() {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        statistics.getStatistics();
//        System.out.println("Task Move");
//        TaskMove.run(island);
//        TaskMove.queue.forEach(TaskMove::run);
//        TaskMove.queue.clear();

//        statistics.getStatistics();
//        System.out.println("Task Eat");
//        TaskEat taskEat = new TaskEat();
//        taskEat.run(island);
//        statistics.getStatistics();
//        System.out.println("Task Died");
//        TaskDied taskDied = new TaskDied();
//        taskDied.run();
        TaskReproduct taskReproduct = new TaskReproduct();
        taskReproduct.reproduct();
        statistics.getStatistics();

    }
}
