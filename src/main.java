import javax.swing.*;
import java.awt.*;

public class main {
    public static int SIZE = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurant App");
        frame.setLocation(450,60);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SIZE,SIZE);
        frame.add(new RestaurantGUI());
        frame.setVisible(true);
    }
}
