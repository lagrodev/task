package animals;

import java.awt.*;

public abstract class Animal {
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean lookAt = false;
    public boolean move = false;
    public Color primaryColor;
    public Color secondaryColor;


    public Animal(int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }


    public abstract void lookAt(int targetX, int targetY);

    public abstract void draw(Graphics2D g);

    public abstract void setPosition(int x, int y);

    public abstract boolean getLookAt();

    public abstract boolean getMove();

    public abstract int getXCenter();

    public abstract int getYCenter();
    public boolean contains(int x, int y) {
        return x >= this.x && x <= this.x + width &&
                y >= this.y && y <= this.y + height;
    }

}