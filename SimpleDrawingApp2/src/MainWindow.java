import modules.AnimalModule;
import modules.CustomAnimalModule;
import modules.DefaultAnimalModule;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class MainWindow extends JFrame {

    public static void main(String[] args) {

        // Create the main application frame
        JFrame frame = new JFrame("Animal Drawing Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setSize(800, 600);

        List<AnimalModule> modules = new ArrayList<>();

        modules.add(new DefaultAnimalModule());
        modules.add(new CustomAnimalModule());

        ServiceLoader<AnimalModule> serviceLoader = ServiceLoader.load(AnimalModule.class);
        for (AnimalModule module : serviceLoader) {
            modules.add(module);
            System.out.println("Loaded module: " + module.getClass().getName());
        }
        DrawPanel drawPanel = new DrawPanel(800, 600, 30, modules);
        frame.add(drawPanel);
        frame.setVisible(true);
    }

}
