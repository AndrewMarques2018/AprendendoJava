import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class TimeData
{
    public Instant start;
    public Instant end;

    // retorna o tempo total em segundos
    public double timeInSeconds()
    {
        return Duration.between(start, end).toMillis() / 1000.0;
    }
} // fim da classe TimeData

public class FibonacciDemo
{
    public static void main(String[] args)
    throws InterruptedException, ExecutionException
    {
        // realiza cálculos síncronos fibonacci(45) e fibonacci(44)
        System.out.println("Synchronous Long Running Calculations");
        TimeData synchronousResult1 = startFibonacci(45);
        TimeData synchronousResult2 = startFibonacci(44);
        double synchronousTime =
                calculateTime(synchronousResult1, synchronousResult2);
        System.out.printf(
                " Total calculation time = %.3f seconds%n", synchronousTime);

        // realiza cálculos assíncronos fibonacci(45) e fibonacci(44)
        System.out.printf("%nAsynchronous Long Running Calculations%n");
        CompletableFuture<TimeData> futureResult1 =
         CompletableFuture.supplyAsync(() -> startFibonacci(45));
        CompletableFuture<TimeData> futureResult2 =
         CompletableFuture.supplyAsync(() -> startFibonacci(44));

        // espera os resultados das operações assíncronas
        TimeData asynchronousResult1 = futureResult1.get();
        TimeData asynchronousResult2 = futureResult2.get();
        double asynchronousTime =
                calculateTime(asynchronousResult1, asynchronousResult2);
        System.out.printf(
                " Total calculation time = %.3f seconds%n", asynchronousTime);

        // exibe a diferença de tempo como um percentual
        String percentage = NumberFormat.getPercentInstance().format(
                synchronousTime / asynchronousTime);
        System.out.printf("%nSynchronous calculations took %s" +
                " more time than the asynchronous calculations%n", percentage);
    }

    // executa a função fibonacci assincronamente
    private static TimeData startFibonacci(int n)
    {
        // cria um objeto TimeData para armazenar datas/horas
        TimeData timeData = new TimeData();

        System.out.printf(" Calculating fibonacci(%d)%n", n);
        timeData.start = Instant.now();
        long fibonacciValue = fibonacci(n);
        timeData.end = Instant.now();
        displayResult(n, fibonacciValue, timeData);
        return timeData;
    }

    // método fibonacci recursivo; calcula o enésimo número de Fibonacci
    private static long fibonacci(long n)
    {
        if (n == 0 || n == 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // exibe o resultado do cálculo de Fibonacci e o tempo total de cálculo
    private static void displayResult(int n, long value, TimeData timeData)
    {
        System.out.printf(" fibonacci(%d) = %d%n", n, value);
        System.out.printf(
                " Calculation time for fibonacci(%d) = %.3f seconds%n",
                n, timeData.timeInSeconds());
    }

    // exibe o resultado do cálculo de Fibonacci e o tempo total de cálculo
    private static double calculateTime(TimeData result1, TimeData result2)
    {
        TimeData bothThreads = new TimeData();

        // determina a primeira hora inicial
        bothThreads.start = result1.start.compareTo(result2.start) < 0 ?
                result1.start : result2.start;

        // determina a última hora final
        bothThreads.end = result1.end.compareTo(result2.end) > 0 ?
                result1.end : result2.end;

        return bothThreads.timeInSeconds();
    }
} // fim da classe FibonacciDemo