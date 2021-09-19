
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Teste {

    public static Stack<Integer> arrayInteger = new Stack<>();

    public static void main(String[] args){

        MyThread t1 = new MyThread("#1",100);
        MyThread t2 = new MyThread("#2",100);

        Thread T1 = new Thread(t1);
        Thread T2 = new Thread(t2);

        T1.start();
        T2.start();



        /* Metodo 1 : saber quando terminar as threads
        while (T1.isAlive() || T2.isAlive()){
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){

            }
        }
        System.out.println("threads terminadas");
         */

        // Metodo 2
        try {
            T1.join();
            T2.join();
        }catch (InterruptedException e){

        }
        System.out.println("threads terminadas");
    }

}
