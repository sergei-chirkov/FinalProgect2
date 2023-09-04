package ru.javarush.chirkov.servesice;

import ru.javarush.chirkov.entity.island.Location;

public interface Eating {
    void eat(Location location) throws InterruptedException;
}
