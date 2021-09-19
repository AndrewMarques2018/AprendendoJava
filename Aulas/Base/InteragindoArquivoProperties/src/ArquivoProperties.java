// Figura 16.19: PropertiesTest.java
// Demonstra classe Properties do pacote java.util.
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ArquivoProperties extends Properties{

    private static String nome, titulo;
    private static FileOutputStream output;
    private static FileInputStream  input ;

    public ArquivoProperties (String nome, String titulo){
        this.nome = nome + ".dat";
        this.titulo = titulo;
    }

    // salva as propriedades em um arquivo
    public void saveProperties() {
        // salva o conteúdo de tabela
        try {
            output = new FileOutputStream(nome);
            store(output, titulo); // salva as propriedadesÿ
            output.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // carrega as propriedades de um arquivo
    public void loadProperties() {
        // carrega o conteúdo de tabela
        try {
            input = new FileInputStream(nome);
            load(input); // carrega propriedadesÿ
            input.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void loadProperties(String nome) {
        // carrega o conteúdo de tabela
        try {
            input = new FileInputStream(nome);
            load(input); // carrega propriedadesÿ
            input.close();
        } catch (IOException ioException) {
            System.out.println("O arquivo nao foi encontrado");
            ioException.printStackTrace();

        }
    }
}