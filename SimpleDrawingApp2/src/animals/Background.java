package animals;

import java.awt.*;

public abstract class Background {
    public int x;
    public int y;
    public int width;
    public int height;
    public Background(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public abstract void draw(Graphics g);
    public abstract void leftMove();
    public abstract void rightMove();
}
