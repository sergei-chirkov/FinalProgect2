import java.util.Random;

public abstract class Animal extends Organizm{
    int weight;
    int maxAnimal;
    int speed;
    int food;

    abstract void eat();

    void move(){
        Random random = new Random();
        int r = random.nextInt(speed)  + 1;

    }

    abstract void reproduction();

    abstract void dead();


}
