import controller.Controller;
import view.View;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("2048 Bogdan Edition");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setSize(428, 568);
        jFrame.setResizable(false);
        jFrame.add(new Controller(new View()));
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
