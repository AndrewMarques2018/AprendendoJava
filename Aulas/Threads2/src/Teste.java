import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Teste {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newCachedThreadPool();

        BuferLockCondition bufer = new BuferLockCondition();

        service.execute(new Read(bufer, 3000));
        service.execute(new Write(bufer,  1700));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);

    }
}
