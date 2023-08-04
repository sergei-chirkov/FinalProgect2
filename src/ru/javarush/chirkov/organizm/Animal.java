package ru.javarush.chirkov.organizm;


import java.util.Random;
import ru.javarush.chirkov.servesice.*;
public abstract class Animal extends Organizm implements Moving {
    int voluem;

    public Animal(int weight, int maxAnimal, int speed, double needfood) {
        super(weight,maxAnimal,speed,needfood);
    }


    @Override
    public void move() {

        System.out.println("Move");
    }



    public int vectorMove() {
        Random random = new Random();
        int move = random.nextInt(3) - 1;
        return move;
    }



}

