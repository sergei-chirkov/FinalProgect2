package ru.javarush.chirkov.resources;

import ru.javarush.chirkov.organizm.Organizm;

import java.util.HashMap;
import java.util.Map;

public class LimitForEating {
    public static Map<String ,Map<String , Integer >> map = new HashMap<>();

    private void addOrganizm(){
        Map<String,Integer> mapForWolf = new HashMap<>();
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
        map.put("Wolf", mapForWolf);
        Map<String,Integer> mapForSnake = new HashMap<>();
        mapForSnake.put("Fox" , 15);
        mapForSnake.put("Rabbit" , 20);
        mapForSnake.put("Mouse" , 40);
        mapForSnake.put("Dug",10);
        Map<String,Integer> mapForFox = new HashMap<>();
        mapForFox.put("Rabbit" , 70);
        mapForFox.put("Mouse" , 90);
        mapForFox.put("Dug",60);
        mapForFox.put("Caterpillar" , 40);
        Map<String,Integer> mapForBeer = new HashMap<>();
        mapForBeer.put("Snake", 80);
        mapForBeer.put("Horse" , 40);
        mapForBeer.put("Deer" , 80);
        mapForBeer.put("Rabbit" , 80);
        mapForBeer.put("Mouse" , 90);
        mapForBeer.put("Goat" , 70);
        mapForBeer.put("Sheep" , 70);
        mapForBeer.put("Wild boar" , 50);
        mapForBeer.put("Buffalo" , 20);
        mapForBeer.put("Dug",10);
        Map<String,Integer> mapForEagler = new HashMap<>();
        mapForEagler.put("Fox" , 10);
        mapForEagler.put("Rabbit" , 90);
        mapForEagler.put("Mouse" , 90);
        mapForEagler.put("Dug",80);
    };
}
