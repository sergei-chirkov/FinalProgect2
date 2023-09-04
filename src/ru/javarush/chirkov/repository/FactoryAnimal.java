package ru.javarush.chirkov.repository;

import ru.javarush.chirkov.entity.Organizm;
import ru.javarush.chirkov.entity.herbivore.*;
import ru.javarush.chirkov.entity.plants.*;
import ru.javarush.chirkov.entity.predator.*;

import java.util.Random;

public class FactoryAnimal {
//    Fox, Beer, Orel,Cow, Horse,
    public enum OrganizmType {
        Wolf, Dug, Grass
    }

    public static OrganizmType generatorTypeOrganizm(){
        Random random = new Random();
        int value = random.nextInt(OrganizmType.values().length) ;
        return OrganizmType.values()[value];
    }


    public static Organizm createOrganizm(OrganizmType type) {
        Organizm organizm = null;

        switch (type) {
            case Wolf -> organizm = new Wolf();

            case  Dug -> organizm = new Dug();

            case Grass -> organizm = new Grass();

        }
        return organizm;
    }

}
