
import java.util.Random;

public abstract class Animal extends Organizm implements Moving {
    int x;
    int y;
    int weight;
    int maxAnimal;
    int speed;
    double needfood;
    int voluem;

    public Animal(int weight, int maxAnimal, int speed, double needfood) {
        this.weight = weight;
        this.maxAnimal = maxAnimal;
        this.speed = speed;
        this.needfood = needfood;
        Random random = new Random();
        this.voluem = random.nextInt(maxAnimal);
    }

    abstract void eat();

    public void move(Location location) {
        Random random = new Random();
        int step = random.nextInt(speed);
        if(step > 0) {
            int xShift = vectorMove();
            int yShift = vectorMove();
            Island island = Island.getInstance();
            int height = island.getHeight();
            int length = island.getLenght();
            int x = location.getX();
            int y = location.getY();
            int newX = (x + step + xShift) % length;
            int newY = (y + step + yShift) % height;
            newX = Math.max(newX, 0);
            newY = Math.max(newY,0);



        }






    }

    public int vectorMove() {
        Random random = new Random();
        int move = random.nextInt(2) - 1;
        return move;
    }

    void reproduction() {

    }

    abstract void dead();


}
