package bear.components;

import bear.Drawable;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Body implements Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color firstColor;
    private Color secondColor;
    private Color background;

    public Body(int x, int y, int width, int height, Color primaryColor, Color secondaryColor, Color backgroundColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.firstColor = primaryColor;
        this.secondColor = secondaryColor;
        this.background = backgroundColor;
    }

    public void setColor(Color color) {
        this.firstColor = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // тело. Разбито на 2 овала - голова и тушука в дальнейшеим соединяем все вместе с помощью простых линий

        int xOval1 = (int) (this.x + width * 0.1);
        int yOval1 = (int) (this.y + height / 55);
        int widthOval1 = width * 280 / 350;
        int heightOval1 = (int) height * 285 / 500;

        int xOval2 = (int) (this.x);
        int yOval2 = (int) (this.y + height * 280 / 550);
        int widthOval2 = width;
        int heightOval2 = (int) height * 270 / 550;

        GeneralPath bodyPath = new GeneralPath();

        bodyPath.moveTo(xOval1, yOval1 + heightOval1 / 2);
        bodyPath.lineTo(xOval1 + widthOval1, yOval1 + heightOval1 / 2);
        bodyPath.lineTo(xOval2 + widthOval2, yOval2 + heightOval2 / 2);


        bodyPath.lineTo(xOval2 + (float) widthOval2 / 2, yOval2 + heightOval2);
        bodyPath.lineTo(xOval2 + (float) widthOval2 / 2, yOval2 + heightOval2);
        bodyPath.lineTo(xOval2, yOval2 + (float) heightOval2 / 2);

        bodyPath.closePath();

        BasicStroke bs = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

        //уши
        g.setColor(this.firstColor);
        g.fillOval(this.x + width * 250 / 350, this.y + height * 20 / 550, width * 30 / 350, height * 50 / 550);
        g.fillOval(this.x + width * 70 / 350, this.y + height * 15 / 550, width * 30 / 350, height * 50 / 550);

        g.setColor(Color.black);
        g.drawOval(this.x + width * 250 / 350, this.y + height * 20 / 550, width * 30 / 350, height * 50 / 550);
        g.drawOval(this.x + width * 70 / 350, this.y + height * 15 / 550, width * 30 / 350, height * 50 / 550);

        // прорисовка овалов
        g.setColor(this.firstColor);
        g.fill(bodyPath);
        g.fillOval(xOval2, yOval2, widthOval2, heightOval2);
        g.fillOval(xOval1, yOval1, widthOval1, heightOval1);

        g.setColor(Color.BLACK);

        //нос
        g.fillOval(this.x + width * 145 / 350, yOval1 + heightOval1 / 2, width * 60 / 350, height * 25 / 550);

        // глаза (белки, зрачки будут в др. классе)
        g.setColor(Color.WHITE);
        g.fillOval(this.x + width * 100 / 350, this.y + height * 130 / 550, width * 40 / 350, height * 40 / 550);
        g.fillOval(this.x + width * 210 / 350, this.y + height * 130 / 550, width * 40 / 350, height * 40 / 550);


        // контуры овалов, с учетом, что нам надо только полукруги..
        g.setStroke(bs);
        g.setColor(Color.BLACK);
        g.drawOval(this.x + width * 100 / 350, this.y + height * 130 / 550, width * 40 / 350, height * 40 / 550);
        g.drawOval(this.x + width * 210 / 350, this.y + height * 130 / 550, width * 40 / 350, height * 40 / 550);

       /* g.fillOval(this.x + width * 110 / 350, this.y + height * 140 / 550, width * 20 / 350, height * 20 / 550);
        g.fillOval(this.x + width * 220 / 350, this.y + height * 140 / 550, width * 20 / 350, height * 20 / 550);
*/
        g.drawArc(xOval1, yOval1, widthOval1, heightOval1, 0, 180);
        g.drawArc(xOval2, yOval2, widthOval2, heightOval2, 0, -180);

        g.setColor(Color.BLACK);
        g.drawLine(xOval1 + widthOval1, yOval1 + heightOval1 / 2, xOval2 + widthOval2, yOval2 + heightOval2 / 2);
        g.drawLine(xOval1, yOval1 + heightOval1 / 2, xOval2, yOval2 + heightOval2 / 2);

        // между body и legs есть разрыв, он будет в виде залитого белого круга - перекроет линии + увеличенный размер линии для полной красоты.
        g.setColor(background);
        g.drawOval(this.x + width * 100 / 350, (int) (this.y + height * 475 / 550), width * 140 / 350, (int) height * 76 / 550);
        g.fillOval(this.x + width * 100 / 350, (int) (this.y + height * 475 / 550), width * 140 / 350, (int) height * 76 / 550);

        // legs

        g.setColor(firstColor);
        // обливка линнии овала, т.к. ранее я в тупую заливал область ног овалом.
        g.drawArc((int) (this.x + width * 95 / 350), (int) (this.y + height * 438 / 550), (int) width * 87 / 350, (int) (height * 110 / 550), 90 + 45, 90);
        g.drawArc((int) (this.x + width * 156 / 350), (int) (this.y + height * 440 / 550), (int) width * 89 / 350, (int) (height * 110 / 550), 45, -90);
        // левая нога

        g.setColor(firstColor);
        g.fillOval((int) (this.x + width * 93 / 350), (int) (this.y + height * 438 / 550), (int) width * 92 / 350, (int) (height * 110 / 550));

        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 96 / 350), (int) (this.y + height * 438 / 550), (int) width * 88 / 350, (int) (height * 110 / 550), 90 + 45, -180 - 67);
        g.drawArc((int) (this.x + width * 50 / 350), (int) (this.y + height * 438 / 550), (int) width * 88 / 350, (int) (height * 110 / 550), 60, 40);

        g.setColor(firstColor.darker());
        g.fillOval((int) (this.x + width * 106 / 350), (int) (this.y + height * 452 / 550), width * 70 / 350, (int) (height * 90 / 550));
        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 106 / 350), (int) (this.y + height * 452 / 550), width * 70 / 350, (int) (height * 90 / 550), 90 + 45, -180 - 90);
// прортсовка стопы
        g.setColor(secondColor);
        g.fillOval((int) (this.x + width * 130 / 350), (int) (this.y + height * 490 / 550), (int) (width * 25 / 350), (int) ((height * 40 / 550)));

        g.fillOval((int) (this.x + width * 120 / 350), (int) (this.y + height * 475 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));
        g.fillOval((int) (this.x + width * 137 / 350), (int) (this.y + height * 464 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));
        g.fillOval((int) (this.x + width * 154 / 350), (int) (this.y + height * 475 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));

        // правая нога
        g.setColor(firstColor);
        g.fillOval((int) (this.x + width * 156 / 350), (int) (this.y + height * 440 / 550), (int) width * 92 / 350, (int) (height * 110 / 550));

        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 155 / 350), (int) (this.y + height * 440 / 550), (int) width * 88 / 350, (int) (height * 110 / 550), 45, 180 + 67);
        g.drawArc((int) (this.x + width * 180 / 350), (int) (this.y + height * 445 / 550), (int) width * 88 / 350, (int) (height * 110 / 550), 60, 40);

        g.setColor(firstColor.darker());
        g.fillOval((int) (this.x + width * 166 / 350), (int) (this.y + height * 454 / 550), width * 70 / 350, (int) (height * 90 / 550));
        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 166 / 350), (int) (this.y + height * 454 / 550), width * 70 / 350, (int) (height * 90 / 550), 45, 180 + 90);
// прорисовка стопы
        g.setColor(secondColor);

        g.fillOval((int) (this.x + width * 185 / 350), (int) (this.y + height * 490 / 550), (int) (width * 25 / 350), (int) ((height * 40 / 550)));

        g.fillOval((int) (this.x + width * 175 / 350), (int) (this.y + height * 475 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));
        g.fillOval((int) (this.x + width * 192 / 350), (int) (this.y + height * 464 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));
        g.fillOval((int) (this.x + width * 209 / 350), (int) (this.y + height * 475 / 550), (int) (width * 12 / 350), (int) ((height * 20 / 550)));

        // руки

        //левая рука
        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 45 / 350), (int) (this.y + height * 230 / 550), (int) width * 70 / 350, (int) (height * 180 / 550), 180 - 15, 90);
        g.setColor(firstColor);
        g.fillOval((int) (this.x + width * 55 / 350), (int) (this.y + height * 341 / 550), (int) width * 70 / 350, (int) (height * 70 / 550));

        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 55 / 350), (int) (this.y + height * 341 / 550), (int) width * 70 / 350, (int) (height * 70 / 550), 0, -170);
        g.drawLine((int) (this.x + width * 125 / 350), (int) (this.y + height * 376 / 550), (this.x + width * 125 / 350), (int) (this.y + height * 336 / 550));
        g.drawLine((int) (this.x + width * 84 / 350), (int) (this.y + height * (339 + 70) / 550), (this.x + width * 80 / 350), (this.y + height * (339 + 55) / 550));
        g.drawLine((int) (this.x + width * 100 / 350), (int) (this.y + height * (339 + 70) / 550), (this.x + width * 103 / 350), (this.y + height * (339 + 55) / 550));

        //правая рука
        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 240 / 350), (int) (this.y + height * 230 / 550), (int) width * 70 / 350, (int) (height * 180 / 550), 15, -90);
        g.setColor(firstColor);
        g.fillOval((int) (this.x + width * 225 / 350), (int) (this.y + height * 341 / 550), (int) width * 70 / 350, (int) (height * 70 / 550));

        g.setColor(Color.black);
        g.drawArc((int) (this.x + width * 229 / 350), (int) (this.y + height * 343 / 550), (int) width * 70 / 350, (int) (height * 70 / 550), 0, -170);
        g.drawLine((int) (this.x + width * 229 / 350), (int) (this.y + height * 383 / 550), (this.x + width * 229 / 350), (int) (this.y + height * 336 / 550));
        g.drawLine((int) (this.x + width * 275 / 350), (int) (this.y + height * (339 + 70) / 550), (this.x + width * 277 / 350), (this.y + height * (339 + 55) / 550));
        g.drawLine((int) (this.x + width * 255 / 350), (int) (this.y + height * (339 + 70) / 550), (this.x + width * 253 / 350), (this.y + height * (339 + 55) / 550));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getFirstColor() {
        return firstColor;
    }

    public Color getSecondColor() {
        return secondColor;
    }

    public Color getBackground() {
        return background;
    }

}