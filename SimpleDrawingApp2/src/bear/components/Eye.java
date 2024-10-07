package bear.components;

import bear.Drawable;

import java.awt.*;

public class Eye implements Drawable {
    private int x; // Позиция глаза по X
    private int y; // Позиция глаза по Y
    private int width; // Ширина глаза
    private int height; // Высота глаза
    private int xMouse; // Позиция взгляда по оси X
    private int yMouse; // Позиция взгляда по оси Y

    public Eye(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xMouse = x;
        this.yMouse = y;
    }

    public void lookAt(int targetX, int targetY) {
        this.xMouse = targetX;
        this.yMouse = targetY;
    }

    @Override
    public void draw(Graphics2D g) {
        // Рисуем белок глаза
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);

        // Размер зрачка
        int pupilWidth = width * 20 / 40; // Пропорционально ширине глаза (из вашего кода: ширина зрачка = width / 2)
        int pupilHeight = height * 20 / 40; // Пропорционально высоте глаза

        // Вычисляем положение зрачка в зависимости от позиции взгляда
        int centerX = x + width / 2;
        int centerY = y + height / 2;

        double angle = Math.atan2(yMouse - centerY, xMouse - centerX);
        double radiusX = (width - pupilWidth) / 2.0;
        double radiusY = (height - pupilHeight) / 2.0;

        int pupilX = centerX + (int) (radiusX * Math.cos(angle)) - pupilWidth / 2;
        int pupilY = centerY + (int) (radiusY * Math.sin(angle)) - pupilHeight / 2;

        // Рисуем зрачок
        g.setColor(Color.BLACK);
        g.fillOval(pupilX, pupilY, pupilWidth, pupilHeight);

        // Рисуем контур глаза
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
    }

    public int getXMouse() {
        return xMouse;
    }

    public int getYMouse() {
        return yMouse;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }
}