package ru.javarush.chirkov.entity.plants;

public class Grass extends Plants{
    private static final int WEIGTH = 1;
    public static final int MAXVALUEM = 200;

    public Grass() {
        super(WEIGTH, MAXVALUEM);
    }

    @Override
    public String toString() {
        return "Grass";
    }
}
