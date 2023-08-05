package ru.javarush.chirkov.organizm.plants;

import ru.javarush.chirkov.organizm.Organizm;

public abstract class Plants extends Organizm {
    int weight;
    int maxVoluem;


    public Plants(int weight, int maxVoluem) {
        super(weight,maxVoluem,0,0, sex);
        this.weight = weight;
        this.maxVoluem = maxVoluem;
    }
}
