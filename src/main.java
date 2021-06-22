import javax.swing.*;
import java.awt.*;

public class main {
    public static int WIDTH = 700;
    public static int HEIGHT = 550;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurant App");
        frame.setLocation(400,75);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.add(new RestaurantGUI());
        frame.setVisible(true);
    }
}
