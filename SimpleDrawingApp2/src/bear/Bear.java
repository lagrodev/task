package bear;

import animals.Animal;
import bear.components.Body;
import bear.components.Eye;

import java.awt.*;

public class Bear extends Animal {

    private Color backgroundColor;
    private Body body;
    private Eye leftEye;
    private Eye rightEye;

    public Bear(int x, int y, int width, int height, Color primaryColor, Color secondaryColor, Color backgroundColor, boolean lookAtMe) {
        super(x, y, width, height, primaryColor, secondaryColor);
        super.lookAt = lookAtMe;
        method(backgroundColor);
    }

    public Bear(int x, int y, int width, int height, Color primaryColor, Color secondaryColor, Color backgroundColor) {
        super(x, y, width, height, primaryColor, secondaryColor);
        method(backgroundColor);
    }

    private void method(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        // Создаем тело медведя
        this.body = new Body(x, y, width, height, primaryColor, secondaryColor, backgroundColor);
        int eyeWidth = width * 40 / 350;
        int eyeHeight = height * 40 / 550;
        // Позиции и размеры глаз, согласно вашим расчетам
        int leftEyeX = x + width * 100 / 350;
        int leftEyeY = y + height * 130 / 550;
        this.leftEye = new Eye(leftEyeX, leftEyeY, eyeWidth, eyeHeight);

        int rightEyeX = x + width * 210 / 350;
        int rightEyeY = y + height * 130 / 550;
        this.rightEye = new Eye(rightEyeX, rightEyeY, eyeWidth, eyeHeight);
    }

    @Override
    public void lookAt(int targetX, int targetY) {
        // Медведь смотрит на заданную точку
        leftEye.lookAt(targetX, targetY);
        rightEye.lookAt(targetX, targetY);
    }

    @Override
    public void draw(Graphics2D g) {
        // Рисуем тело и глаза медведя
        body.draw(g);
        leftEye.draw(g);
        rightEye.draw(g);
    }

    @Override
    public void setPosition(int x, int y) {
        return;
    }

    @Override
    public boolean getLookAt() {
        return lookAt;
    }

    @Override
    public boolean getMove() {
        return move;
    }

    @Override
    public int getXCenter() {
        return 0;
    }

    @Override
    public int getYCenter() {
        return 0;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Body getBody() {
        return body;
    }

    public Eye getLeftEye() {
        return leftEye;
    }

    public Eye getRightEye() {
        return rightEye;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }

}