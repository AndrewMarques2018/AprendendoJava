import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TesteArquivoProperties {

    public static void main(String[] args) {

        ArquivoProperties properties = new ArquivoProperties("MyProperties", "Properties");

        /*
        properties.setProperty("Objeto", "Paralelepipedo");
        properties.setProperty("Color", "Amarelo");
        properties.setProperty("Largura", "55");
        properties.setProperty("Altura", "23");
        properties.setProperty("Profundidade", "12");
        */

        properties.saveProperties();




    }
}
