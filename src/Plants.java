import java.util.Random;

public abstract class Plants extends Organizm{
    int weight;
    int maxVoluem;
    int voluem;

    public Plants(int weight, int maxVoluem) {
        this.weight = weight;
        this.maxVoluem = maxVoluem;
        Random random = new Random();
        this.voluem = random.nextInt(maxVoluem);
    }
}
