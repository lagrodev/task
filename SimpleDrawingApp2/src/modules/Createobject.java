package modules;

import animals.Animal;
import animals.Background;
import bear.Bear;
import bird.Sparrow;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Createobject {
    public static void createAnimals(ArrayList<Animal> animals, Color background, List<AnimalModule> modules) {
        for (AnimalModule module : modules) {
            module.createAnimals(animals, background);
        }
    }

    public static void createBackground(ArrayList<Background> backgrounds, Color background, List<AnimalModule> modules) {
        for (AnimalModule module : modules) {
            module.createBackground(backgrounds);
        }
    }
}