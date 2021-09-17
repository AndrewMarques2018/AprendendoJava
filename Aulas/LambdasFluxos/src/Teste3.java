
import java.security.SecureRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Teste3 {
    public static void main(String[] args) {

        // rolando um dado 1.000.000 vezes e resumindo os resultados
        SecureRandom random = new SecureRandom();
        random.ints(1000000, 1, 7).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach( (face, frequency) -> System.out.printf("%-6d%d%n", face, frequency));
    }
}
