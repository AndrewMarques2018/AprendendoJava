public class Write implements Runnable{

    private int tempo;
    private final InterfaceBufer bufer;

    public Write(InterfaceBufer bufer, int tempo){
        this.bufer = bufer;
        this.tempo = tempo;
    }


    @Override
    public void run() {
        System.out.println("Thread write run();");
        for(int i=0; i<10; i++){
            try {
                Thread.sleep(tempo);
                bufer.put(i);
                System.out.println("write (" + i + ")");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
