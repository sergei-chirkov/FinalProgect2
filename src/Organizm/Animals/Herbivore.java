package Organizm.Animals;

import Organizm.Animals.Animal;

import java.util.Random;

public abstract class Herbivore extends Animal {
    int vectorMove() {
        Random random = new Random();
        int vector = random.nextInt(4) - 2;
        return vector;
    }

}
