package ru.javarush.chirkov.entity.herbivore;

import java.util.HashMap;
import java.util.Map;

public class Dug extends Herbivore{

    private static final int WEIGHT = 1;
    private static final int MAXANIMAL = 200;
    private static final int SPEED = 4;
    private static final double NEEDFOOD = 0.15;
    private static final Map<String,Integer> mapForDug = new HashMap<>();

    static {
        mapForDug.put("Caterpillar" , 90); //гусеница
        mapForDug.put("Grass" , 100);
    }

    public Dug() {
        super(WEIGHT,MAXANIMAL,SPEED,NEEDFOOD,mapForDug);
    }

    @Override
    public String toString() {
        return "Dug ";
    }
}
