package Tests;

import bear.components.Body;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BodyTest {

    @Test
    public void testConstructor() {
        int x = 10;
        int y = 20;
        int width = 100;
        int height = 200;
        Color primaryColor = Color.BLACK;
        Color secondaryColor = Color.WHITE;
        Color backgroundColor = Color.GRAY;

        Body body = new Body(x, y, width, height, primaryColor, secondaryColor, backgroundColor);

        assertEquals(x, body.getX());
        assertEquals(y, body.getY());
        assertEquals(width, body.getWidth());
        assertEquals(height, body.getHeight());
        assertEquals(primaryColor, body.getFirstColor());
        assertEquals(secondaryColor, body.getSecondColor());
        assertEquals(backgroundColor, body.getBackground());
    }

    @Test
    public void testSetters() {
        Body body = new Body(0, 0, 100, 200, Color.BLACK, Color.WHITE, Color.GRAY);

        body.setX(15);
        body.setY(25);
        body.setWidth(150);
        body.setHeight(250);
        body.setColor(Color.BLUE);

        assertEquals(15, body.getX());
        assertEquals(25, body.getY());
        assertEquals(150, body.getWidth());
        assertEquals(250, body.getHeight());
        assertEquals(Color.BLUE, body.getFirstColor());
    }

    @Test
    public void testDraw() {
        Body body = new Body(0, 0, 100, 200, Color.BLACK, Color.WHITE, Color.GRAY);

        // Создаем графический контекст для рисования
        BufferedImage image = new BufferedImage(200, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Проверяем, что метод draw выполняется без ошибок
        assertDoesNotThrow(() -> body.draw(g2d));

        g2d.dispose();
    }
}
