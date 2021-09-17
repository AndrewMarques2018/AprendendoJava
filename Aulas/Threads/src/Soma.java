import java.util.Arrays;

public class Soma {

    private int soma;
    public synchronized int soma (Integer[] array){

        soma = 0;
        for(int i=0; i < array.length; i++) {
            soma += array[i];
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){

            }
        }

        return soma;
        //return Arrays.asList(array).stream().reduce(0, Integer::sum);
    }
}
