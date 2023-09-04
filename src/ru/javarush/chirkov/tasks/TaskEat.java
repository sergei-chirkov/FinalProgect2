package ru.javarush.chirkov.tasks;

import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.servesice.Eating;



public class TaskEat extends Tasks{

    @Override
    public void run(){
        getLockTask().lock();
        Island island  = Island.getInstance();
     for( Location location : island.locations){
         location.organizms.stream()
                 .filter(organizm -> organizm instanceof Eating)
                 .forEach(organizm -> {
                     try {
                         ((Eating) organizm).eat(location);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 });
     }
        getLockTask().unlock();
    }



}
