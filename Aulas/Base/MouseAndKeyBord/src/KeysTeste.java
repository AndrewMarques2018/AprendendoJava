import javax.swing.*;

public class KeysTeste {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("Keys Teste");

        jFrame.addKeyListener(new KeyBoardListener());

        jFrame.addMouseListener(new MyMouse());
        jFrame.addMouseMotionListener(new MyMouse());
        jFrame.addMouseWheelListener(new MyMouse());


        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setBounds(0,0,600,600);


    }
}
