import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    public void paintComponent (Graphics g){

        super.paintComponent(g);

        int width = getWidth();
        int heigth = getHeight();

        g.drawLine(0, heigth, width, 0);
        g.drawLine(0,0, width, heigth);

        for (int i = 0; i<70; i++) {
            g.drawOval(i, i, i*10, i*10);

        }
    }
}
