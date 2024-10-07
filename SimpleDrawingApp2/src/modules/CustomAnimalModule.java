package modules;


import animals.Animal;
import animals.Background;
import modules.custom.Car;
import modules.custom.Cloud;
import modules.custom.Fox;

import java.awt.*;
import java.util.ArrayList;

public class CustomAnimalModule implements AnimalModule {
    @Override
    public void createAnimals(ArrayList<Animal> animals, Color background) {
        Fox fox = new Fox(400, 400, 100, 100, Color.cyan, Color.black, true);
        animals.add(fox);
    }

    @Override
    public void createBackground(ArrayList<Background> backgrounds) {
        Cloud cloud = new Cloud(50, 100, 60, 90);
        Car car = new Car(200, 200, 100, 100, Color.cyan);
        backgrounds.add(car);
        backgrounds.add(cloud);
    }
}
