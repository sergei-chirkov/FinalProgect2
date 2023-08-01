package Organizm.Animals;
import Organizm.Organizm;

import java.util.Random;

public abstract class Animal extends Organizm {
    int weight;
    int maxAnimal;
    int speed;
    double needfood;
    int voluem;

    @Override
    public String toString() {
        return Animal.class + "voluem=" + voluem +
                '}';
    }

    abstract void eat();

    void move(){
        Random random = new Random();
        int step = random.nextInt(speed)  + 1;

    }

    abstract void reproduction();

    abstract void dead();


}
