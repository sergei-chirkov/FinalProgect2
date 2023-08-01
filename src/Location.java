import java.util.ArrayList;
import java.util.List;

public class Location {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    List<Organizm> organizms;

    public Location(int i, int j) {
        this.organizms = new ArrayList<>();
        x = i;
        y = j;
    }

    void print() {
       organizms.forEach(System.out::println);

    }
}
