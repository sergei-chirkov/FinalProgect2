

import java.util.Random;

public abstract class Herbivore extends Animal {
    public Herbivore(int weight, int maxAnimal, int speed, double needfood) {
        super(weight, maxAnimal, speed, needfood);
    }


    @Override
    void eat(){}


}
