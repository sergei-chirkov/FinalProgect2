package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.view.Statistics;

public class TaskView extends Tasks{
    private  static int day = 0;
    @Override
    public void run() {
        getLockTask().lock();
        day++;
        Statistics statistics = new Statistics();
        System.out.println("-------Day: " + day + " --------");
        statistics.getStatistics();
        getLockTask().unlock();
    }
}
