package ru.javarush.chirkov.organizm.predator;

public class Wolf extends Predator{
    private static final int WEIGHT = 50;
    private static final int MAXANIMAL = 30;
    private static final int SPEED = 3;
    private static final int NEEDFOOD = 8;

    public Wolf() {
        super(WEIGHT,MAXANIMAL,SPEED,NEEDFOOD);
    }
}
