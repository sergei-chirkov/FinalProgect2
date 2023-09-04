package ru.javarush.chirkov.tasks;

import java.util.concurrent.locks.ReentrantLock;

public  class Tasks implements Runnable{
    private static final ReentrantLock lockTask = new ReentrantLock(true);
    @Override
    public void run() {

    }

    public static ReentrantLock getLockTask() {
        return lockTask;
    }
}
