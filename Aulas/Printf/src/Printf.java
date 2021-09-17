

public class Printf {

    public static void main(String[] args) {

        // frase comum:
        System.out.printf("%s -> ","especificadores");

        // % especificadores
        // pular linha
        System.out.printf("%n");

        // %s String de caracteres
        System.out.printf(" %s", "string");

        // %d Número inteiro decimal
        System.out.printf("%n %d", 12);

        // %u Número inteiro decimal sem sinal

        // %o Número inteiro octal sem sinal

        // %x, %X Número inteiro hexadecimal sem sinal, minúsculo ou maiúsculo

        // %f Float
        System.out.printf("%n %f", 22.5);
        // %2f Double
        System.out.printf("%n %2f", 2222.6478);
        // %e, %E Número real, em notação científica, minúsculo ou maiúsculo

        // %b Boolean
        System.out.printf("%n %b", true);
        // %c Caractere (char)
        System.out.printf("%n %c", 'c');


        System.out.printf("%n%n %s -> ", "Caracteres de escape");

        // \t Tabulação
        System.out.printf("%n\t%s", "Tubulaçao");
        // \b Backspace
        System.out.printf("%n%s\b", "Backspace");
        // \n Nova Linha
        System.out.printf("\n%s", "nova linha");
        // \r Retorno de Carro
        System.out.printf("%n\r%s\r", "retorno de carro");
        // \' Aspa Siples
        // \" Aspa Dupla
        // \\ Barra Invertida
        // %% Porcentage
        System.out.printf("\n\'\"\\%%");


    }


}
