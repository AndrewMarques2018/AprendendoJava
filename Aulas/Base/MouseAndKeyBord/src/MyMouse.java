import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.SQLOutput;

public class MyMouse implements MouseInputListener, MouseWheelListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("MyMouse: mouseClicked:");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("MyMouse: mouseClicked: " + e.getButton());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("MyMouse: mouseRelease:");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("MyMouse: mouseEntred:");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("MyMouse: mouseExited:");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("MyMouse: mouseDragged:");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("MyMouse: mouseMoved:");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println("MyMouse: mouseWheel: " + e.getWheelRotation());

    }
}
