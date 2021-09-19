

public class Read implements Runnable{

    private int tempo;
    private final InterfaceBufer buffer;

    public Read(InterfaceBufer bufer, int tempo){
        this.buffer = bufer;
        this.tempo = tempo;
    }


    @Override
    public void run() {
        System.out.println("Thread read run();");
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(tempo);
                System.out.println("read (" + buffer.get() + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
