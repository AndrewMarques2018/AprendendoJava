import javax.swing.*;
import javax.swing.text.Keymap;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyBoardListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped : " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed : " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyRelease : " + e.getKeyChar());
    }
}
