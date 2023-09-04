package ru.javarush.chirkov.entity;


import ru.javarush.chirkov.entity.island.Island;
import ru.javarush.chirkov.entity.island.Location;
import ru.javarush.chirkov.servesice.Died;
import ru.javarush.chirkov.servesice.Eating;
import ru.javarush.chirkov.servesice.Moving;
import ru.javarush.chirkov.servesice.Reproduction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;


public abstract class Animal extends Organizm implements Moving, Eating, Died, Reproduction {


    public Animal(double weight, int maxAnimal, int speed, double needfood, Map<String, Integer> mapForEat) {
        super(weight, maxAnimal, speed, needfood, mapForEat);
    }


    @Override
    public void move(Location location) {

        int oldLocation = location.getId();
        int newLocation = newLocation();
        if (oldLocation != newLocation && this.isLife()) {
            Island island = Island.getInstance();
            // get list organizn ij the new location
            List<Organizm> list = island.locations.get(newLocation).organizms;
            long count = list.stream().filter(organizm1 -> organizm1.getClass().equals(this.getClass())).count();
            //check and add organizm in the new Location
            location.getLock().lock();
            if (this.getMaxAnimal() > count) {
                island.locations.get(newLocation).organizms.add(this);
            }
            // remove organizm in the Old Location;
            island.locations.get(oldLocation).organizms.remove(this);

            location.getLock().unlock();


        }


    }


    public int getLocation() {
        Island island = Island.getInstance();
        Optional<Location> loc = island.locations.stream().filter(x -> x.organizms.contains(this)).findFirst();
        return loc.get().getId();
    }

    public int newLocation() {
        Island island = Island.getInstance();
        int length = island.getLenght();
        int heigth = island.getHeight();
        int oldlocation = getLocation();
        Random random = new Random();

        int step = random.nextInt(this.getSpeed());
        int shiftX = this.vectorMove();
        int shiftY = this.vectorMove();

        int newLocalX = ((oldlocation) % length + step * shiftX) < length ? (oldlocation) % length + step * shiftX : length - 1;
        int localY = oldlocation / (length - 1) + shiftY * step;
        int newLocalY = localY < heigth ? (localY - 1) * length : (heigth - 1) * length;
        if ((newLocalX + newLocalY) < 0) {
            newLocalX = Math.max(newLocalX, 0);
            newLocalY = Math.max(newLocalY, 0);
        }

        return newLocalX + newLocalY;
    }

    public int vectorMove() {
        Random random = new Random();
        return random.nextInt(3) - 1;
    }

    @Override
    public void eat(Location location) {


        if (this.isLife()) {
            List<Organizm> organizms = location.organizms;

            for (Organizm organizm : organizms) {
                if (!organizm.equals(this)) {

                    Map<String, Integer> mapForEat = this.getMapForEat();
                    Integer probabilityForEating = mapForEat.get(organizm.getClass().getSimpleName());
                    if (probabilityForEating != null) {

                        Random random = new Random();
                        int probability = random.nextInt(100);
                        if (probability < probabilityForEating) {

                            double weight = organizm.getWeight();
                            if (this.getFoodStatus() < this.getNeedfood()) {

                                location.getLock().lock();
                                double residue = weight - this.getNeedfood() + this.getFoodStatus();
                                this.setFoodStatus(Math.min(this.getFoodStatus() + weight, this.getNeedfood()));
                                organizm.setWeight(residue > 0 ? residue : 0);
                                organizm.setStausLifeIsDead();
                                location.getLock().unlock();

                            }
                        }

                    }
                }
            }
        }

    }

    @Override
    public void died() {
        if (this.getFoodStatus() == 0) {
            this.setStausLifeIsDead();
        }
    }


}

