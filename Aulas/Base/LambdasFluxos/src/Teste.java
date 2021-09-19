import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Teste {

    public static void main(String[] args) {

        System.out.println("Teste com vetor int: 10,1,9,2,8,3,7,4,6,5");
        int[] vetorInt = {10,1,9,2,8,3,7,4,6,5};

        System.out.print("forEach: ");
        IntStream.of(vetorInt).forEach(value -> System.out.printf(" %s",value));
        System.out.println();

        System.out.print("cont: ");
        System.out.println(IntStream.of(vetorInt).count());

        System.out.print("max:");
        System.out.println(IntStream.of(vetorInt).max().getAsInt());

        System.out.print("min:");
        System.out.println(IntStream.of(vetorInt).min().getAsInt());

        System.out.print("sum:");
        System.out.println(IntStream.of(vetorInt).sum());

        System.out.print("average:");
        System.out.println(IntStream.of(vetorInt).average().getAsDouble());

        System.out.print("reduce (x,y)->x+y:");
        System.out.println(IntStream.of(vetorInt).reduce(0, (x, y) -> x + y));

        System.out.print("reduce (x,y)->x*y:");
        System.out.println(IntStream.of(vetorInt).reduce(1, (x, y) -> x * y));

        System.out.print("sorted:");
        IntStream.of(vetorInt).sorted().forEach(value -> System.out.printf(" %s",value));
        System.out.println();

        System.out.print("filter:");
        IntStream.of(vetorInt).filter(value -> value % 2 == 0).forEach(value -> System.out.printf(" %s",value));
        System.out.println();

        System.out.print("map value*10:");
        IntStream.of(vetorInt).map(value -> value * 10).forEach(value -> System.out.printf(" %s",value));
        System.out.println();

        System.out.print("range 1-5 sum:");
        System.out.println(IntStream.range(1,5).sum());

        System.out.print("rangeClosed 1-5 sum:");
        System.out.println(IntStream.rangeClosed(1,5).sum());

        System.out.println();
        System.out.println("Teste 2: Array de inteiros: 2, 9, 5, 0, 3, 7, 1, 4, 8, 6");

        Integer[] arrayInt = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        System.out.print("sorted collect list: ");
        System.out.println(Arrays.stream(arrayInt).sorted().collect(Collectors.toList()));

        System.out.print("sorted collect list: ");
        System.out.println(Arrays.stream(arrayInt).sorted().collect(Collectors.toList()));

        System.out.println();
        System.out.println("Teste 2: Array de string: \"abc\", \"bcd\", \"cde\", \"aaa\", \"bbb\", \"ccc\"");

        String[] arrayString = {"abc", "bcd", "cde", "aaa", "bbb", "ccc"};

        System.out.print("sorted collect list: ");
        System.out.println(Arrays.stream(arrayString).sorted().collect(Collectors.toList()));

        System.out.print("upper case: ");
        System.out.println(Arrays.stream(arrayString).map(s -> s.toUpperCase()).collect(Collectors.toList()));

        System.out.print("filter (a): ");
        System.out.println(Arrays.stream(arrayString).
                filter(s -> s.compareToIgnoreCase("b") > 0 )
                    .collect(Collectors.toList()));

    }

}
