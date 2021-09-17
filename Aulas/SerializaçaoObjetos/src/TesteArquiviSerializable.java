import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TesteArquiviSerializable {

    public static void main(String[] args) {

        ArquivoSerializable<Jogador> arq1 = new ArquivoSerializable("arq1");

        Jogador n1 = new Jogador("Andrew1", 140.50);
        Jogador n2 = new Jogador("Andrew2", 240.50);
        Jogador n3 = new Jogador("Andrew3", 340.50);
        Jogador n4 = new Jogador("Andrew4", 440.50);
        Jogador n5 = new Jogador("Andrew5", 540.50);

        Queue<Jogador> rank = new PriorityQueue();
        rank.add(n1);
        rank.add(n3);
        rank.add(n5);
        rank.add(n4);
        rank.add(n2);

        rank.addAll(arq1.ler());

        Iterator iterator = rank.iterator();

        while (iterator.hasNext()){
            System.out.println(rank.poll());
        }

    }
}
