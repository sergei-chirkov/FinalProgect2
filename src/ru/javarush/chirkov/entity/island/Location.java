package ru.javarush.chirkov.entity.island;

import ru.javarush.chirkov.entity.Organizm;
import ru.javarush.chirkov.repository.FactoryAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private final int id;
    private final ReentrantLock lock = new ReentrantLock(true);

    public List<Organizm> organizms;

    public Location(int id) {
        this.organizms = new ArrayList<>();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public void addOrganizm() {
        int length = FactoryAnimal.OrganizmType.values().length;
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            FactoryAnimal.OrganizmType organizmType = FactoryAnimal.generatorTypeOrganizm();
            Organizm organizm = FactoryAnimal.createOrganizm(organizmType);

            int maxAnimal = organizm.getMaxAnimal();
            for (int j = 0; j < random.nextInt(maxAnimal); j++) {
                organizms.add(FactoryAnimal.createOrganizm(organizmType));
            }
        }
    }

    public int getCountOrganizm(Organizm organizm) {
        int countOrganizm = 0;
        for (Organizm org : organizms) {
            if (org.equals(organizm)) {

                countOrganizm++;
            }
        }
        return countOrganizm;
    }

}
