package modules.custom;

import animals.Background;

import java.awt.*;

public class Car extends Background {

    private Color color;

    public Car(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRoundRect(x - (int) (0.18 * width), y - (int) (0.2 * height), (int) (1.2 * width),
                (int) (0.4 * height), 20, 20);
        g.fillRoundRect(x, y - (int) (0.55 * height), (int) (0.8 * width), (int) (0.4 * height),
                20, 20);

        //windows
        g.setColor(Color.blue);
        g.fillRoundRect(x + (int) (0.07 * width), y - (int) (0.5 * height), (int) (0.3 * width),
                (int) (0.3 * height), 20, 20);
        g.fillRoundRect(x + (int) (0.45 * width), y - (int) (0.5 * height), (int) (0.3 * width),
                (int) (0.3 * height), 20, 20);

        //back wheel
        g.setColor(Color.darkGray);
        g.fillOval(x - (int) (0.1 * width), y, (int) (0.33 * width), (int) (0.33 * height));
        g.setColor(Color.lightGray);
        g.fillOval(x - (int) (0.1 * width) + (int) (0.08 * width), y + (int) (0.08 * height),
                (int) (0.17 * width), (int) (0.17 * height));

        //front wheel
        g.setColor(Color.darkGray);
        g.fillOval(x + (int) (0.6 * width), y, (int) (0.33 * width), (int) (0.33 * height));
        g.setColor(Color.lightGray);
        g.fillOval(x + (int) (0.6 * width) + (int) (0.08 * width), y + (int) (0.08 * height),
                (int) (0.17 * width), (int) (0.17 * height));
    }

    @Override
    public void leftMove() {
        this.x -= 5;

    }

    @Override
    public void rightMove() {
        this.x += 5;
    }
}