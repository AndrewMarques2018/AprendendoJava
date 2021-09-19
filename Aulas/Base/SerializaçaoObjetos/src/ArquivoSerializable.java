import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ArquivoSerializable<T>{

    private final String nome;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private ArrayList<T> conteudo;

    public ArquivoSerializable(String nome) {
        this.nome = nome + ".ser";

        conteudo = new ArrayList<>();

        if(new File(this.nome).exists()){
            conteudo = ler();
        }else
            criarArquivo();
    }

    private void criarArquivo(){
        try
        {
            output = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(nome)));

            if (output != null)
                output.close();

            System.out.println("Java: ArquivoSerilizable.construtor(): arquivo criado ");
        }
        catch (IOException ioException)
        {
            System.err.println("Java: ArquivoSerilizable.construtor(): erro ao abrir arquivo");
            System.exit(1); // termina o programa
        }
    }

    public void add(T ... conteudo ){

        try
        {
            output = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(nome)));

            if(conteudo != null) {
                this.conteudo.addAll(Arrays.asList(conteudo));

                for (T objeto : this.conteudo)
                    output.writeObject(objeto);
            }
            if (output != null)
                output.close();

            System.out.println("Java: ArquivoSerilizable.salvar(): conteudo foi salvo ");
        }
        catch (IOException ioException)
        {
            System.err.println("Java: ArquivoSerilizable.salvar(): erro ao abrir arquivo");
            System.exit(1); // termina o programa
        }

    }

    public ArrayList<T> ler(){

        try // abre o arquivo
        {
            input = new ObjectInputStream(Files.newInputStream(Paths.get(nome)));

            try {
                this.conteudo.clear();
                while (true) {
                    this.conteudo.add((T)input.readObject());
                }
            }
            catch (EOFException | ClassNotFoundException e){
                // fim da leitura
            }

            if (input != null)
                input.close();

            return this.conteudo;
        }
        catch (IOException ioException)
        {
            System.out.println("Java: ArquivoSerilizable.load(): erro ao abrir o arquivo");
            System.exit(1); // termina o programa
        }

        return null;
    }

    public void limpar(){

        try
        {
            output = new ObjectOutputStream(
                    Files.newOutputStream(Paths.get(nome)));

            output.reset();
            this.conteudo.clear();

            System.out.println("Java: ArquivoSerilizable.limpar(): arquivo limpo ");

            if (output != null)
                output.close();
        }
        catch (IOException ioException)
        {
            System.out.println("Java: ArquivoSerilizable.ler(): erro ao abrir o arquivo");
            System.exit(1); // termina o programa
        }

    }

    public int tamanho(){
        return this.conteudo.size();
    }
}
