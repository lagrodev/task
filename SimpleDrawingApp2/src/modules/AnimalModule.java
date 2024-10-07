package modules;

import animals.Animal;
import animals.Background;

import java.awt.Color;
import java.util.ArrayList;

public interface AnimalModule {
    void createAnimals(ArrayList<Animal> animals, Color background);
    void createBackground(ArrayList<Background> backgrounds);
}