package modules;

import animals.Animal;
import animals.Background;
import bear.Bear;
import bird.Sparrow;

import java.awt.Color;
import java.util.ArrayList;

public class DefaultAnimalModule implements AnimalModule {
    @Override
    public void createAnimals(ArrayList<Animal> animals, Color background) {
        Color bearPrimaryColor = new Color(0x96765d);
        Color bearSecondaryColor = new Color(0x7C3100);

        Bear bear = new Bear(260, 150, 150, 250, Color.PINK, bearPrimaryColor, background, true);
        animals.add(bear);

        Sparrow sparrow = new Sparrow(350, 150, 50, 40, bearSecondaryColor, Color.PINK, true);
        animals.add(sparrow);

        bear.lookAt(sparrow.getXCenter(), sparrow.getYCenter());
    }

    @Override
    public void createBackground(ArrayList<Background> backgrounds) {

    }
}