package modules.custom;

import animals.Animal;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

/**
 * Класс Fox представляет собой лису, которая может смотреть в заданном направлении
 * и рисоваться на графическом контексте Graphics2D.
 */
public class Fox extends Animal {

    public Fox(int x, int y, int width, int height, Color primaryColor, Color secondaryColor) {
        super(x, y, width, height, primaryColor, secondaryColor);
    }

    public Fox(int x, int y, int width, int height, Color primaryColor, Color secondaryColor, boolean move) {
        super(x, y, width, height, primaryColor, secondaryColor);
        super.move = move;
    }

    @Override
    public void lookAt(int targetX, int targetY) {

    }

    @Override
    public void draw(Graphics2D g) {
        // Сохраняем исходные настройки графики
        Color originalColor = g.getColor();

        // Рисуем тело воробья
        g.setColor(primaryColor);
        g.fillOval(x, y, width, height);

        // Рисуем голову воробья, соединяя ее с телом
        int headX = x + width * 3 / 4;
        int headY = y + height / 4;
        int headWidth = width / 2;
        int headHeight = height / 2;

        // Создаем путь для головы и соединяем его с телом
        GeneralPath birdPath = new GeneralPath();
        birdPath.append(new Ellipse2D.Double(x, y, width, height), false); // тело
        birdPath.append(new Ellipse2D.Double(headX, headY, headWidth, headHeight), false); // голова

        g.setColor(primaryColor);
        g.fill(birdPath);

        // Рисуем глаза
        int eyeWidth = width / 10;
        int eyeHeight = height / 10;
        int eye1X = headX + headWidth / 3;
        int eye1Y = headY + headHeight / 4;
        int eye2X = headX + headWidth / 3;
        int eye2Y = headY + headHeight / 2;

        g.setColor(Color.WHITE);
        g.fillOval(eye1X, eye1Y, eyeWidth, eyeHeight);
        g.fillOval(eye2X, eye2Y, eyeWidth, eyeHeight);

        g.setColor(Color.BLACK);
        g.drawOval(eye1X, eye1Y, eyeWidth, eyeHeight);
        g.drawOval(eye2X, eye2Y, eyeWidth, eyeHeight);

        // Рисуем зрачки
        int pupilWidth = eyeWidth / 2;
        int pupilHeight = eyeHeight / 2;
        int pupil1X = eye1X + eyeWidth / 4;
        int pupil1Y = eye1Y + eyeHeight / 4;
        int pupil2X = eye2X + eyeWidth / 4;
        int pupil2Y = eye2Y + eyeHeight / 4;

        g.fillOval(pupil1X, pupil1Y, pupilWidth, pupilHeight);
        g.fillOval(pupil2X, pupil2Y, pupilWidth, pupilHeight);

        // Рисуем клюв
        g.setColor(secondaryColor);
        int beakX1 = headX + headWidth;
        int beakY1 = headY + headHeight / 2;
        int beakX2 = headX + headWidth + width / 10;
        int beakY2 = headY + headHeight / 2 - height / 20;
        int beakX3 = headX + headWidth + width / 10;
        int beakY3 = headY + headHeight / 2 + height / 20;

        int[] beakXPoints = {beakX2, beakX3, beakX1};
        int[] beakYPoints = {beakY2, beakY3, beakY1};

        g.fillPolygon(beakXPoints, beakYPoints, 3);

        g.setColor(Color.BLACK);
        g.drawPolygon(beakXPoints, beakYPoints, 3);

        // Восстанавливаем исходный цвет
        g.setColor(originalColor);
    }


    @Override
    public boolean getLookAt() {
        return super.lookAt;
    }

    @Override
    public boolean getMove() {
        return move;
    }

    public void setPosition(int x, int y) {
        // Центрируем воробья относительно заданных координат
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public int getXCenter() {
        return x + width / 2;
    }

    public int getYCenter() {
        return y + height / 2;
    }
}