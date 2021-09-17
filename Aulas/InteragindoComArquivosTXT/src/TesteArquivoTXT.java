public class TesteArquivoTXT {

    public static void main(String[] args) {

        ArquivoTXT arq1 = new ArquivoTXT("arq1");

        //arq1.escrever("escrever");

        //arq1.limpar();

        arq1.escrever("extra");


        System.out.println(arq1.getArray());

    }
}
