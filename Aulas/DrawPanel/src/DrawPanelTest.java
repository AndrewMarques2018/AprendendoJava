import javax.swing.*;

public class DrawPanelTest {

    public static void main(String[] args) {

        DrawPanel panel = new DrawPanel();

        JFrame application = new JFrame();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(700, 700);
        application.setVisible(true);

    }

}
