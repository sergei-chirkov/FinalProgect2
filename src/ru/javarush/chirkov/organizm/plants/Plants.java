package ru.javarush.chirkov.organizm.plants;

import ru.javarush.chirkov.FactoryAnimal;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.servesice.Reproduction;
import ru.javarush.chirkov.view.Statistics;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Plants extends Organizm implements Reproduction {

    public Plants(int weight, int maxVoluem) {
        super(weight,
                maxVoluem,
                0,
                0, null);
    }

}
