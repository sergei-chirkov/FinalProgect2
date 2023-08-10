package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.servesice.Eating;

import javax.swing.plaf.multi.MultiSliderUI;

public class TaskEat {


    void run(Island island){

     for( Location location : island.locations){
         location.organizms.stream()
                 .filter(organizm -> organizm instanceof Eating)
                 .forEach(organizm -> ((Eating) organizm).eat(location));
     }

    }

}
