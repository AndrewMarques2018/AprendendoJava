import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ArquivoTXT {

    private String nome;
    private ArrayList<String> conteudo;

    public ArquivoTXT(String nome) {
        this.nome = nome + ".txt";
        conteudo = new ArrayList();
    }

    public void escrever (String conteudo){

        try {

            // abrir arquivo
            Formatter output;
            String aux = ler();

            output = new Formatter(nome);

            // escrever no arquivo

            output.format((aux + conteudo));

            // fechar arquivo
            output.close();

        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // termina o programa
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // termina o programa
        }

    }

    public String ler (){

        try
        {
            // abrir arquivo
            Scanner input;

            input = new Scanner(Paths.get(nome));

            // ler arquivo
            conteudo.clear();
            while (input.hasNextLine()) // enquanto houver mais para ler
            {
                conteudo.add(input.nextLine());
            }

            // fechar arquivo
            input.close();

        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }

        String aux = "";
        for(String g : conteudo)
            aux += g + "\n";
        return aux;
    }

    public String lerLinha (int linha ){
        return conteudo.get(linha);
    }

    public ArrayList getArray (){
        return conteudo;
    }

    public void limpar(){

        try {
            // abrir arquivo
            Formatter output;

            output = new Formatter(nome);

            // limpar no arquivo
            output.format("");

            // fechar arquivo
            output.close();

        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // termina o programa
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1); // termina o programa
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
