package modules.custom;

import animals.Background;

import java.awt.*;

public class Cloud extends Background {

    public Cloud(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval(this.x, this.y + (int) (0.3 * height), (int) (1.1 * width), (int) (0.65 * height));
        g.fillOval(this.x + (int) (0.25 * width), this.y, (int) (0.55 * width), (int) (0.9 * height));
    }

    public void leftMove() {
        this.x -= 5;
    }

    public void rightMove() {
        this.x += 5;
    }
}