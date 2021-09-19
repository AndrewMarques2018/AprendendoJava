import java.io.PrintStream;
import java.util.Date;
import java.util.Locale;

public class Printf2 {

    public static void main(String[] args) {

        // geral %1$-12.3s
        // exemplo
        if(false) {
            System.out.printf("Integer : %d\n", 15);
            System.out.printf("Floating point number with 3 decimal digits: %.3f\n", 1.21312939123);
            System.out.printf("Floating point number with 8 decimal digits: %.8f\n", 1.21312939123);
            System.out.printf("String: %s, integer: %d, float: %.6f", "Hello World", 89, 9.231435);
        }
        // exemplo
        if(false) {
            System.out.printf("%b\n", "Java Code Geeks");
            System.out.printf("%b\n", 25);
            System.out.printf("%b\n", null);
        }
        // exemplo
        if(false){
            System.out.printf("%c\n", 74);
            System.out.printf("%c\n", 65);
            System.out.printf("%c\n", 86);
            System.out.printf("%c\n", 65);
        }
        // exemplo : hashcode value of the argument
        if(false){
            System.out.printf("%h", "Java Code Geeks");
        }
        // exemplo : octal value
        if(false){
            System.out.printf("%o\n",8);
            System.out.printf("%o\n", 100);
        }
        // exemplo : hex value
        if(false){
            System.out.printf("%x\n", 25);
            System.out.printf("%x\n", 100);
        }
        // exemplo : posicionaento
        if(false){
            System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
            System.out.printf("%-12d%-12d%07d\n",15,12,36);
        }
        // exemplo : posicionamento inteiros
        if(false){
            System.out.printf("%d\n", 100);
            System.out.printf("%10d\n", 100);
            System.out.printf("%010d\n", 100);
        }
        // exemplo : colocando virgula em numeros inteiros
        if(false){
            System.out.printf("%,d\n", 1000000000);
            System.out.printf("%,d\n", 1234);
        }
        // exemplo : modulo
        if(false){
            System.out.printf("%(d", -25);
        }
        // exemplo
        if(false){
            System.out.printf("%-12s\n", "inicio");
            System.out.printf("%12s", "final");
        }
        // exemplo : .s corta a string
        if(false){
            System.out.printf("%-12s%-12s%s\n","Column 1","Column 2","Column3");
            System.out.printf("%-12.4s%s", "Hello World","World");
        }
        // exemplo
        if(false){
            System.out.printf("%.4s\n", "Java Code Geeks");
            System.out.printf("%12.9s\n", "Java Code Geeks");
            System.out.printf("|%s|\n", "Java Code Geeks");
        }
        // exemplo : Datas
        if(false){
            System.out.printf("Current Time - %tT\n",new Date());
            System.out.printf("TimeStamp - %tc\n",new Date());
            System.out.printf("ISO 8601 formatted date - %tF\n",new Date());
        }
        // exemplo
        if(false){
            String longDate = String.format("Today is %tA %<tB %<td, %<tY", new Date());
            System.out.println(longDate);

            System.out.printf("%td %tb %tY %tl:%tM %tp",new Date(),new Date(),new Date(),new Date(),new Date(),new Date());
        }
        // exemplo : Locale
        if(false){
            long k = 25000;

            String italian = String.format(Locale.ITALY,"%,d %n", k);

            String french = String.format(Locale.FRANCE,"%,d %n", k);

            String english = String.format(Locale.ENGLISH,"%,d %n", k);

            System.out.print(italian);

            System.out.print(french);

            System.out.print(english);
        }
        // exemplo : n$ seleciona o arguento n
        if (false){
            System.out.printf("%4$5s %3$5s %2$5s %1$5s", "a", "b", "c", "d");
        }
        // exemplo :
        if (true){
            String str = String.format("%3$-10.2S %2$10s %1$10s", "Geeks","Code","Java");
            System.out.println(str);
        }

    }
}
