package Tests;
import bear.Bear;
import bear.components.Body;
import bear.components.Eye;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BearTest {
     @Test
    public void testConstructorWithLookAtMe() {
        int x = 100;
        int y = 100;
        int width = 350;
        int height = 550;
        Color primaryColor = Color.BLACK;
        Color secondaryColor = Color.WHITE;
        Color backgroundColor = Color.GRAY;
        boolean lookAtMe = true;

        Bear bear = new Bear(x, y, width, height, primaryColor, secondaryColor, backgroundColor, lookAtMe);

        assertEquals(x, bear.getX());
        assertEquals(y, bear.getY());
        assertEquals(width, bear.getWidth());
        assertEquals(height, bear.getHeight());
        assertEquals(primaryColor, bear.getPrimaryColor());
        assertEquals(secondaryColor, bear.getSecondaryColor());
        assertEquals(backgroundColor, bear.getBackgroundColor());
        assertEquals(lookAtMe, bear.getLookAt());

        // Проверяем, что тело и глаза инициализированы правильно
        Body body = bear.getBody();
        assertNotNull(body);
        assertEquals(x, body.getX());
        assertEquals(y, body.getY());
        assertEquals(width, body.getWidth());
        assertEquals(height, body.getHeight());

        Eye leftEye = bear.getLeftEye();
        Eye rightEye = bear.getRightEye();
        assertNotNull(leftEye);
        assertNotNull(rightEye);

        // Проверяем координаты глаз
        int expectedEyeWidth = width * 40 / 350;
        int expectedEyeHeight = height * 40 / 550;
        int expectedLeftEyeX = x + width * 100 / 350;
        int expectedLeftEyeY = y + height * 130 / 550;

        assertEquals(expectedLeftEyeX, leftEye.getX());
        assertEquals(expectedLeftEyeY, leftEye.getY());
        assertEquals(expectedEyeWidth, leftEye.getWidth());
        assertEquals(expectedEyeHeight, leftEye.getHeight());

        int expectedRightEyeX = x + width * 210 / 350;
        int expectedRightEyeY = y + height * 130 / 550;

        assertEquals(expectedRightEyeX, rightEye.getX());
        assertEquals(expectedRightEyeY, rightEye.getY());
        assertEquals(expectedEyeWidth, rightEye.getWidth());
        assertEquals(expectedEyeHeight, rightEye.getHeight());
    }

    @Test
    public void testLookAt() {
        int x = 100;
        int y = 100;
        int width = 350;
        int height = 550;
        Color primaryColor = Color.BLACK;
        Color secondaryColor = Color.WHITE;
        Color backgroundColor = Color.GRAY;

        Bear bear = new Bear(x, y, width, height, primaryColor, secondaryColor, backgroundColor);

        // Устанавливаем точку, на которую медведь должен смотреть
        int targetX = 200;
        int targetY = 300;
        bear.lookAt(targetX, targetY);

        // Проверяем, что глаза смотрят на заданную точку
        Eye leftEye = bear.getLeftEye();
        Eye rightEye = bear.getRightEye();

        assertEquals(targetX, leftEye.getXMouse());
        assertEquals(targetY, leftEye.getYMouse());
        assertEquals(targetX, rightEye.getXMouse());
        assertEquals(targetY, rightEye.getYMouse());
    }

    @Test
    public void testDraw() {
        int x = 50;
        int y = 50;
        int width = 350;
        int height = 550;
        Color primaryColor = new Color(139, 69, 19); // коричневый
        Color secondaryColor = new Color(205, 133, 63); // светло-коричневый
        Color backgroundColor = Color.WHITE;

        Bear bear = new Bear(x, y, width, height, primaryColor, secondaryColor, backgroundColor);

        // Создаем графический контекст для рисования
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Проверяем, что метод draw выполняется без ошибок
        assertDoesNotThrow(() -> bear.draw(g2d));

        g2d.dispose();
    }
}
