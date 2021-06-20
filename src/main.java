import javax.swing.*;
import java.awt.*;

public class main {
    private static int SIZE = 700;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Restaurant App");
        frame.setLocation(450,55);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SIZE,SIZE);
        frame.add(new RestaurantGUI(SIZE));
        frame.setVisible(true);
    }
}
