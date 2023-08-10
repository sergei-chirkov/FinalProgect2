package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.organizm.Animal;
import ru.javarush.chirkov.view.Statistics;

public class Tasks implements Runnable {

    @Override
    public void run() {
        Island island = Island.getInstance();
        Statistics statistics = new Statistics();
        System.out.println("Task Move");
        island.locations.forEach(location -> location.organizms.stream()
                .filter(organizm -> organizm instanceof Animal)
                .forEach(organizm -> new TaskMove((Animal) organizm, ((Animal) organizm).getLocation(), ((Animal) organizm).newLocation())));
        TaskMove.queue.forEach(TaskMove::run);
        TaskMove.queue.clear();

        statistics.getStatistics();
        System.out.println("Task Eat");
        TaskEat taskEat = new TaskEat();
        taskEat.run(island);
        statistics.getStatistics();
        System.out.println("Task Died");
        TaskDied taskDied = new TaskDied();
        taskDied.run();
        statistics.getStatistics();

    }
}
