import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = new LinkedList<>();
        locations.add(new Location(0));
        locations.add(new Location(1));
        Wolf wolf = new Wolf();
        Location one = new Location(2);
        locations.add(new Location(3));
        locations.add(new Location(4));
        locations.add(new Location(5));
        locations.add(new Location(6));
        locations.add(new Location(7));
        locations.add(new Location(8));
        for (int i = 0; i < 5; i++) {
            locations.stream().map(x ->x.organizms).forEach(x ->x.add(new Wolf()));
        }
        for (int i = 0; i < 4; i++) {
            one.organizms.add(new Wolf());
//            one.organizms.add(new Grass());
        }
        one.organizms.add(wolf);
      locations.add(one);

        locations.stream().map(x -> x.organizms).forEach(System.out::println);
//        System.out.println("----------------");
//        locations.stream().map(x -> x.organizms).forEach( x1-> x1.forEach(System.out::println));
        System.out.println("----------------");

        System.out.println(locations.stream().count());
        locations.stream().map(x -> x.organizms).forEach(System.out::println);
        System.out.println("---------3-move----------");
        System.out.println("Find id Local");
        Optional<Location> loc = locations.stream().filter(x->x.organizms.contains(wolf)).findFirst();
        int local = loc.get().getX();
        System.out.println("local" + local);
        System.out.println("Add Animal in the new Local");
        Random random = new Random();
        int step = random.nextInt(wolf.speed);
        System.out.println("step " + step);
        int shiftX = wolf.vectorMove();
        int shiftY = wolf.vectorMove();

        int newLocalX = ((local)%(3 + 1) + shiftX * step)%3;
        System.out.println("shiftX + shiftY " + shiftX + " " + shiftY + " " + ((local )%(3 + 1)));
        int newLocalY = (local/3 + shiftY * step) * 3;
        int newLocal = newLocalX + newLocalY;
        System.out.println("newLocal " + newLocal + " = " + newLocalX + " + " + newLocalY);
        locations.stream().filter(x->x.organizms.contains(wolf));
        System.out.println("--------------");







    }

}