import animals.Animal;
import animals.Background;
import bear.Bear;
import bird.Sparrow;
import modules.AnimalModule;
import modules.Createobject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel implements ActionListener, MouseMotionListener {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private JButton deleteAnimalButton;

    private final int TIMER_DELAY;
    private Timer timer;
    private BufferedImage backgroundImage;
    private ArrayList<Animal> animals; // List of animals
    private ArrayList<Background> backgrounds; // List of animals
    private int ticksFromStart = 0;
    private boolean isAddingAnimal = false;

    private KeyHandler keyHandler;
    private Animal selectedAnimal = null;


    public DrawPanel(final int width, final int height, final int timerDelay, List<AnimalModule> modules) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;

        timer = new Timer(timerDelay, this);
        timer.start();
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.keyHandler = new KeyHandler();

        this.addKeyListener(keyHandler);


        setBackground(Color.green);

        animals = new ArrayList<>(); // Initialize the list of animals
        backgrounds = new ArrayList<>();

        Createobject.createAnimals(animals, getBackground(), modules);
        Createobject.createBackground(backgrounds, getBackground(), modules);

        addMouseMotionListener(this);
        addMouseMotionListener(this);

        initComponents();
    }

    private void initComponents() {
        deleteAnimalButton = new JButton("Удалить животное");
        deleteAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedAnimal != null) {
                    animals.remove(selectedAnimal);
                    selectedAnimal = null;
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(DrawPanel.this, "Животное не выбрано.");
                }
            }
        });
        this.add(deleteAnimalButton);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectAnimalAt(e.getX(), e.getY());
            }
        });
    }

    private void selectAnimalAt (int x, int y) {
        selectedAnimal = null;
        for (Animal animal : animals) {
            if (animal.contains(x, y)) {
                selectedAnimal = animal;
                break;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(final Graphics gr) {
        super.paintComponent(gr);
        Graphics2D g2d = (Graphics2D) gr;
        if (backgroundImage != null) {
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            // Заполняем фон цветом панели, если изображение недоступно
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }

        for (Background background : backgrounds) {
            background.draw(g2d);
        }

        for (Animal animal : animals) {
            animal.draw(g2d);
            // Выделяем выбранное животное
            if (animal == selectedAnimal) {
                g2d.setColor(Color.RED);
                g2d.drawRect(animal.x, animal.y, animal.width, animal.height);
            }
        }
    }


    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            ticksFromStart += 2;
            repaint();
        }
        if (keyHandler.isLeftPressed()) {
            for (Background background : backgrounds) {
                background.leftMove();
            }
            repaint();
        }
        if (keyHandler.isRightPressed()) {
            for (Background background : backgrounds) {
                background.rightMove();
            }
            repaint();
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (Animal animal : animals) {
            if (animal.getMove()) {
                animal.setPosition(e.getX(), e.getY());
                updateAnimalsLookingAt(animal);
            }
        }
        repaint();
    }

    private void updateAnimalsLookingAt(Animal forMouseAnimals) {
        for (Animal animal : animals) {
            if (animal.getLookAt()) {
                animal.lookAt(forMouseAnimals.getXCenter(), forMouseAnimals.getYCenter());
            }
        }
    }


}