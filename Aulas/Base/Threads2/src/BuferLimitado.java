

public class BuferLimitado implements InterfaceBufer{

    private int[] bufer;
    private int occupiedCells = 0; // conta número de buffers utilizados
    private int writeIndex = 0; // índice do próximo elemento em que gravar
    private int readIndex = 0;

    public BuferLimitado(int limite){
        bufer = new int[limite];
        for (int i = 0; i < limite; i++) {
            bufer[i] = -1;
        }
    }
    public synchronized void put(int valor) throws InterruptedException {

        while (occupiedCells == bufer.length){
            wait();
        }

        System.out.println("write[" + writeIndex + "] : " + valor);
        bufer[writeIndex] = valor;
        writeIndex = (writeIndex + 1) % bufer.length;

        ++occupiedCells;

        notifyAll();
    }

    public synchronized int get() throws InterruptedException {

        while (occupiedCells == 0){
            wait();
        }

        System.out.print("read[" + readIndex + "] : ");

        int readValue = bufer[readIndex];

        readIndex = (readIndex + 1) % bufer.length;
        --occupiedCells;

        System.out.println(readValue);
        notifyAll();

        return readValue;
    }
}
