import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Jogador implements Serializable, Comparable<Jogador> {

    private String nome;
    private Double pontos;

    public Jogador() {

    }

    public Jogador(String nome, Double pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", pontos=" + pontos +
                '}';
    }

    @Override
    public int compareTo( Jogador j) {
        return Double.valueOf(this.getPontos()).compareTo(j.getPontos());
    }
}
