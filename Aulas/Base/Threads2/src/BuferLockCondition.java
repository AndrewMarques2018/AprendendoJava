import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BuferLockCondition implements InterfaceBufer{

    // Bloqueio para controlar sincronização com esse buffer
    private final Lock lock = new ReentrantLock();

    // condições para controlar leitura e gravação
    private final Condition canWrite = lock.newCondition();
    private final Condition canRead = lock.newCondition() ;

    private int bufer = -1;
    private boolean occupied = false;

    @Override
    public void put(int valor) throws InterruptedException {

        lock.lock(); // bloqueia esse objeto

        try
        {
            while (occupied)
            {
                canWrite.await(); // espera até que o buffer esteja vazio
            }

            bufer = valor;

            occupied = true;
            // sinaliza quaisquer threads que estão esperando para ler o buffer
            canRead.signalAll();
        }
        finally
        {
            lock.unlock(); // desbloqueia esse objetoÿ
        }

    }

    @Override
    public int get() throws InterruptedException {
        int readValue = 0; // inicializa do valor lido a partir do buffer
        lock.lock(); // bloqueia esse objetoÿ

        // envia informações da thread e do buffer para a saída, então espera
        try

        {
            // se não houver dados para serem lidos, coloca a thread em estado de espera
            while (!occupied)
            {
                System.out.println("Consumer tries to read.");
                canRead.await(); // espera até o buffer tornar-se cheioÿ
            }

            // indica que a produtora pode armazenar outro valor
            // porque a consumidora acabou de recuperar o valor do buffer
            occupied = false;

            readValue = bufer; // recupera o valor do buffer

            // sinaliza qualquer thread que está esperando o buffer tornar-se vazioÿ
            canWrite.signalAll();
        }
        finally
        {
            lock.unlock(); // desbloqueia esse objetoÿ
        }

        return readValue;
    }
}
