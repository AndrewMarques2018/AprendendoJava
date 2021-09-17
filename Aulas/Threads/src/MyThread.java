public class MyThread implements Runnable{
    private String nome;
    private int tempo;
    private static Soma soma = new Soma();

    public MyThread(String nome, int tempo) {
        this.nome = nome;
        this.tempo = tempo;
    }

    @Override
    public void run() {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(soma.soma(array));

    }


 /*
    @Override
    public void run() {

        System.out.printf("Thread %s -> run \n", nome);

        for(int i = 0; i<= 10; i++){

            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("%s -> %d \n", nome, i);
        }

        System.out.printf("%s terminou \n", nome);
    }

  */
}
