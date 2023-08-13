package ru.javarush.chirkov;

import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.organizm.herbivore.*;
import ru.javarush.chirkov.organizm.plants.*;
import ru.javarush.chirkov.organizm.predator.*;

import java.util.Random;

public class FactoryAnimal {
//    Fox, Beer, Orel,Cow, Horse,
    public enum OrganizmType {
        Wolf, Dug, Grass
    }

    public static OrganizmType generatorTypeOrganizm(){
        Random random = new Random();
        int value = random.nextInt(OrganizmType.values().length) ;
        OrganizmType type = OrganizmType.values()[value];
        return type;
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
