package Organizm.Animals;

import java.util.Random;

public class Dug extends Herbivore {
    private static final int WEIGHT = 1;
    private static final int MAXANIMAL = 200;
    private static final int SPEED = 4;
    private static final double NEEDFOOD = 0.15;
    public int voluem;

    public Dug() {
        this.weight = WEIGHT;
        this.maxAnimal = MAXANIMAL;
        this.speed = SPEED;
        this.needfood = NEEDFOOD;
        Random random = new Random();
        this.voluem = random.nextInt(MAXANIMAL) + 1;
    }
    @Override
    void eat() {

    }

    @Override
    void reproduction() {

    }

    @Override
    void dead() {

    }
}
