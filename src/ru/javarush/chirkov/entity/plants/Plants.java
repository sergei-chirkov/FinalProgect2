package ru.javarush.chirkov.entity.plants;

import ru.javarush.chirkov.entity.Organizm;
import ru.javarush.chirkov.servesice.Reproduction;

public abstract class Plants extends Organizm implements Reproduction {

    public Plants(int weight, int maxVoluem) {
        super(weight,
                maxVoluem,
                0,
                0, null);
    }

}
