package ru.javarush.chirkov.entity.predator;

import java.util.HashMap;
import java.util.Map;

public class Wolf extends Predator{
    private static final int WEIGHT = 50;
    private static final int MAXANIMAL = 30;
    private static final int SPEED = 3;
    private static final int NEEDFOOD = 8;
    private static final Map<String,Integer> mapForWolf = new HashMap<>();

    static {
        mapForWolf.put("Horse" , 10);
        mapForWolf.put("Deer" , 15);
        mapForWolf.put("Rabbit" , 60);
        mapForWolf.put("Mouse" , 80);
        mapForWolf.put("Goat" , 60);
        mapForWolf.put("Sheep" , 70);
        mapForWolf.put("Wild boar" , 15);
        mapForWolf.put("Buffalo" , 10);
        mapForWolf.put("Dug" , 40);
        mapForWolf.put("Caterpillar" , 0); //гусеница
        mapForWolf.put("Eagle" , 0);
    }



    public Wolf() {
        super(WEIGHT,MAXANIMAL,SPEED,NEEDFOOD,mapForWolf);
    }

    @Override
    public String toString() {
        return "Wolf " ;
    }
}
