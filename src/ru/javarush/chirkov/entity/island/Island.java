package ru.javarush.chirkov.entity.island;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Island {

    private  int lenght;
    private  int height;
    private  int period;
    private static Island island;

    public List<Location> locations = new ArrayList<>();

    private Island() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter Island's LENGHT:");
        this.lenght = console.nextInt();
        System.out.println("Enter Island's HEIGHT:");
        this.height = console.nextInt();
        System.out.println("Enter Period for Game:");
        this.period = console.nextInt();
        //creat island
        for (int i = 0; i < lenght * height; i++) {
            locations.add(new Location(i));
        }
        //add Organizm to Isaland
        locations.forEach(Location::addOrganizm);

    }

    public static Island getInstance() {
        if (island == null) {
            island = new Island();
        }
        return island;
    }

    public int getLenght() {
        return lenght;
    }

    public int getHeight() {
        return height;
    }

    public int getPeriod() {
        return period;
    }
}
