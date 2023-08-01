import java.util.Random;

public class FactoryAnimal {
    public enum PredatorType {
        Wolf, Fox, Beer, Orel
    }
    public enum HerbivoreType {
        Dug, Cow, Horse
    }
    public enum PlantsType{
        Grass
    }


    public static Predator createPredator() {
        Predator predator = null;
        Random random = new Random();
        int value = random.nextInt(PredatorType.values().length) ;
        PredatorType type = PredatorType.values()[value];

        switch (type) {
            case Wolf -> predator = new Wolf();

        }
        return predator;
    }
    public static Plants createPlants() {
        Plants plants = null;
        Random random = new Random();
        int value = random.nextInt(PlantsType.values().length);
        PlantsType type = PlantsType.values()[value];

        switch (type) {
            case Grass -> plants = new Grass();

        }
        return plants;
    }
    public static Herbivore createHerbivore() {
        Herbivore herbivore = null;
        Random random = new Random();
        int value = random.nextInt(HerbivoreType.values().length);
        HerbivoreType type = HerbivoreType.values()[value];

        switch (type) {

        }
        return herbivore;
    }
}
