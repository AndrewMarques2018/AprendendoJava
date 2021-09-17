

public class Bufer implements InterfaceBufer{

    private int bufer;
    private boolean ocupado;

    public synchronized void put(int valor) throws InterruptedException {

        while (ocupado){
            System.out.println("wait");
            wait();
        }

        bufer = valor;

        ocupado = true;

        notifyAll();
    }

    public synchronized int get() throws InterruptedException {

        while (!ocupado){
            System.out.println("wait");
            wait();
        }

        ocupado = false;

        notifyAll();

        return bufer;
    }
}
