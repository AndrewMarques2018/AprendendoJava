import java.io.File;
import javax.sound.sampled.*;

public class Teste2 {

    void AudioAcerto() { //Método AudioAcerto para chamar na classe executavel.
        try {
            //URL do som que no caso esta no pendrive, mais ainda é uma fase de teste.
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(new File("beep.wav").getAbsoluteFile());
            System.out.println(new File("beep.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(0);
            //clip.loop(Clip.LOOP_CONTINUOUSLY); //Para repetir o som.

/* Opçao1
            // Para a execução (se não o programa termina antes de você ouvir o som)
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JOptionPane.showMessageDialog(null, "Clique pra fechar!");
                }
            });

 */
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }

// Opçao2
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Teste2 audioAcerto = new Teste2();
        audioAcerto.AudioAcerto();
    }
}