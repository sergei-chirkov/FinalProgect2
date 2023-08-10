package ru.javarush.chirkov.organizm.predator;

import java.util.Random;

public class Wolf extends Predator{
    private static final int WEIGHT = 50;
    private static final int MAXANIMAL = 30;
    private static final int SPEED = 3;
    private static final int NEEDFOOD = 8;

    public Wolf() {
        super(WEIGHT,MAXANIMAL,SPEED,NEEDFOOD);
    }

    @Override
    public String toString() {
        return "Wolf " + this.getFoodStatus();
    }
}
