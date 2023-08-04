package ru.javarush.chirkov.island;

import ru.javarush.chirkov.organizm.Organizm;
import ru.javarush.chirkov.*;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private  int lenght = 2;
    private  int height = 2;
    private static Island island;

    public Location[][] locations = new Location[lenght][height];

    private Island(){

        for (int i = 0; i < lenght; i++){
            for(int j = 0; j < height; j++){
                locations[i][j] = new Location(i+j);
                locations[i][j].organizms.add(FactoryAnimal.createHerbivore());
            }
        }
        for (int i = 0; i < lenght; i++){
            for(int j = 0; j < height; j++){
                System.out.printf("--------%d-%d------\n",i,j);
                locations[i][j].print();
                System.out.println("-----------------");
            }
        }
        for (int i = 0; i < lenght; i++){
            for(int j = 0; j < height; j++){

            }
        }

    }
    public static Island getInstance(){
        if(island == null){
            island = new Island();
        }
        return island;
    }

    public  int getLenght() {
        return lenght;
    }

    public  int getHeight() {
        return height;
    }
}
