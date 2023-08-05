package ru.javarush.chirkov.organizm;


import java.util.Optional;
import java.util.Random;

import ru.javarush.chirkov.island.Island;
import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.servesice.*;
import ru.javarush.chirkov.tasks.TaskMove;

public abstract class Animal extends Organizm implements Moving {
    int voluem;

    public Animal(int weight, int maxAnimal, int speed, double needfood) {
        super(weight,maxAnimal,speed,needfood);
    }


    @Override
    public void move() {
        int oldLocation = getLocation();
        int newLocation = newLocation();
        if(oldLocation!=newLocation){
            TaskMove.queue.add(new TaskMove(this,oldLocation,newLocation));
        }
    }
    //location is the Animal located
    private int getLocation(){
        Island island = Island.getInstance();
        Optional<Location> loc = island.locations.stream().filter(x->x. organizms.contains(this)).findFirst();
        return loc.get().getId();
    }
    //get new Location for Animal
    private int newLocation(){
        Island island = Island.getInstance();
        int length = island.getLenght();
        int heigth = island.getHeight();
        int oldlocation = getLocation();
        Random random = new Random();
        // Step
        int step = random.nextInt(this.getSpeed());
        int shiftX = this.vectorMove();
        int shiftY = this.vectorMove();
        int newLocalX = ((oldlocation)%length + step*shiftX) < length ?  (oldlocation)%length + step*shiftX : length -1;
        int localY = oldlocation / (length - 1) + shiftY * step;
        int newLocalY = localY < heigth ? (localY - 1) * length : (heigth - 1)*length;
        if((newLocalX + newLocalY) < 0){
            newLocalX = Math.max(newLocalX, 0);
            newLocalY =Math.max(newLocalY,0);
        }

        return newLocalX + newLocalY;
    }



    public int vectorMove() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return move;
    }



}

