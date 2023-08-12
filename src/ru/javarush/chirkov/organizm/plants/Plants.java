package ru.javarush.chirkov.organizm.plants;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.servesice.Reproduction;

import java.util.*;

public abstract class Plants extends Organizm implements Reproduction {

    public Plants(int weight, int maxVoluem) {
        super(weight,
                maxVoluem,
                0,
                0);
    }

    @Override
    public void reproduction() {

    }

}
