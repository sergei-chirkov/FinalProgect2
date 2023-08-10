package ru.javarush.chirkov.organizm.herbivore;

public class Dug extends Herbivore{
    private static final int WEIGHT = 1;
    private static final int MAXANIMAL = 200;
    private static final int SPEED = 4;
    private static final double NEEDFOOD = 0.15;

    public Dug() {
        super(WEIGHT,MAXANIMAL,SPEED,NEEDFOOD);
    }

    @Override
    public String toString() {
        return "Dug " + this.getFoodStatus();
    }
}
