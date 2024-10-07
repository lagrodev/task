package Tests;

import bear.components.Eye;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EyeTest {

    private Eye eye;

    @BeforeEach
    void setUp() {
        // Initialize Eye at position (100, 100) with width=40 and height=40
        eye = new Eye(100, 100, 40, 40);
    }

    @Test
    void testInitialState() {
        assertEquals(100, eye.getX());
        assertEquals(100, eye.getY());
        assertEquals(40, eye.getWidth());
        assertEquals(40, eye.getHeight());
        assertEquals(100, eye.getXMouse());
        assertEquals(100, eye.getYMouse());
    }

    @Test
    void testLookAt() {
        eye.lookAt(150, 150);
        assertEquals(150, eye.getXMouse());
        assertEquals(150, eye.getYMouse());
    }

    @Test
    public void testDraw() {
        Eye eye = new Eye(100, 100, 40, 40);

        // графический контекст для рисования
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Проверяем, что метод draw выполняется без ошибок
        assertDoesNotThrow(() -> eye.draw(g2d));

        g2d.dispose();
    }

}