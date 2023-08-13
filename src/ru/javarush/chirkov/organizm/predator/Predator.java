package ru.javarush.chirkov.organizm.predator;

import ru.javarush.chirkov.island.Location;
import ru.javarush.chirkov.organizm.Animal;
import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.organizm.herbivore.Herbivore;
import ru.javarush.chirkov.organizm.plants.Plants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Predator extends Animal {
    public Predator(int weight, int maxAnimal, int speed, double needfood, Map<String,Integer> mapForEat) {
        super(weight, maxAnimal, speed, needfood,mapForEat);
    }

//    @Override
//    public void eat(Location location) {
//        List<Organizm> plantsList = location.organizms.stream().filter(organizm -> organizm instanceof Herbivore).collect(Collectors.toList());
//        plantsList.forEach(organizm -> {
//            if (this.isLife()) {
//                double weight = organizm.getWeight();
//                if (this.getFoodStatus() < this.getNeedfood()) {
//                    organizm.setWeight(setFoodStatus(weight));
//                    organizm.setStausLifeIsDead();
//                }
//            }
//        });
//    }
}
