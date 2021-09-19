import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Teste2 {

    public static void main(String[] args) {

        Pessoa[] pessoas = {
                new Pessoa("andrew", "marques", 2700.50, 22),
                new Pessoa("fulano", "de tal", 1800.00, 22),
                new Pessoa("ciclano", "alves", 3700.50, 22),
                new Pessoa("beltrano", "correa", 700.50, 22)
        };

        List<Pessoa> list = Arrays.asList(pessoas);

        list.stream().forEach(System.out::println);
        System.out.println();

        Predicate<Pessoa> salarioMaiorQue1700 = e -> (e.getSalario() > 1700);

        System.out.println("predicate: ");
        list.stream().filter(salarioMaiorQue1700).forEach(System.out::println);

        System.out.println("maior salario: ");
        list.stream()
                .sorted().forEach(System.out::println);
        // metodo coareTo adicionada na classe pessoa;

        System.out.println("mapToDoble:");
        list.stream().mapToDouble(Pessoa::getSalario).forEach(System.out::println);
    }
}
