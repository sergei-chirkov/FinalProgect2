package ru.javarush.chirkov.tasks;

import java.util.LinkedList;
import java.util.Queue;

public class Task implements Runnable{
    public static Queue<Task> queue = new LinkedList<>();

    @Override
    public void run() {
        queue.peek().run();
    }
}
