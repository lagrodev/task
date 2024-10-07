package Tests;

import bear.components.Eye;
import bird.*;
import animals.Animal;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class SparrowTest {

    private Sparrow sparrow;

    @Before
    public void setUp() {
        sparrow = new Sparrow(100, 150, 50, 30, Color.GRAY, Color.YELLOW);
    }

    @Test
    public void testConstructor() {
        // Проверяем, что все поля инициализируются правильно
        assertEquals(100, sparrow.getPositionX());
        assertEquals(150, sparrow.getPositionY());
        assertEquals(100 + 25, sparrow.getXCenter());
        assertEquals(150 + 15, sparrow.getYCenter());
        assertEquals(Color.GRAY, sparrow.primaryColor);
        assertEquals(Color.YELLOW, sparrow.secondaryColor);
        assertFalse("По умолчанию getMove - false", sparrow.getMove());
    }

    @Test
    public void testConstructorWithMove() {
        Sparrow movingSparrow = new Sparrow(200, 250, 60, 40, Color.GRAY, Color.YELLOW, true);
        assertTrue("проверка при задании move", movingSparrow.getMove());
    }

    @Test
    public void testSetPosition() {
        sparrow.setPosition(200, 300);
        assertEquals(200 - 25, sparrow.getPositionX());
        assertEquals(300 - 15, sparrow.getPositionY());
    }

    @Test
    public void testGetPositionX() {
        assertEquals(100, sparrow.getPositionX());
    }

    @Test
    public void testGetPositionY() {
        assertEquals(150, sparrow.getPositionY());
    }

    @Test
    public void testGetXCenter() {
        // Тестируем метод получения центра по X
        assertEquals(125, sparrow.getXCenter());
    }

    @Test
    public void testGetYCenter() {
        assertEquals(165, sparrow.getYCenter());
    }

    @Test
    public void testGetLookAt() {
        assertFalse("Воробей не должен следить за направлением взгляда", sparrow.getLookAt());
    }

    @Test
    public void testGetMove() {
        // Тестируем метод getMove
        assertFalse("По умолчанию воробей не должен перемещаться", sparrow.getMove());
        sparrow.move = true;
        assertTrue("Воробей должен перемещаться после установки move в true", sparrow.getMove());
    }

     @org.junit.jupiter.api.Test
    public void testDraw() {
        Sparrow s = new Sparrow(100, 150, 50, 30, Color.GRAY, Color.YELLOW);

        // графический контекст для рисования
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Проверяем, что метод draw выполняется без ошибок
        assertDoesNotThrow(() -> s.draw(g2d));

        g2d.dispose();
    }

}