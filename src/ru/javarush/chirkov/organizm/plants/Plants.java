package ru.javarush.chirkov.organizm.plants;

import ru.javarush.chirkov.organizm.Organizm;

public abstract class Plants extends Organizm {



    public Plants(int weight, int maxVoluem) {
        super(weight,
                maxVoluem,
                0,
                0, foodStatus);
    }
}
