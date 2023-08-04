package ru.javarush.chirkov.organizm.plants;

import ru.javarush.chirkov.organizm.Organizm;

import java.util.Random;

public abstract class Plants extends Organizm {
    int weight;
    int maxVoluem;


    public Plants(int weight, int maxVoluem) {
        super(weight,maxVoluem,0,0);
        this.weight = weight;
        this.maxVoluem = maxVoluem;
    }
}
