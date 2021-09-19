


public class Pessoa implements Comparable<Pessoa>{

    private String nome;
    private String sobrenome;
    private Double Salario;
    private Integer idade;


    public Pessoa(String nome, String sobrenome, Double salario, Integer idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        Salario = salario;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Double getSalario() {
        return Salario;
    }

    public void setSalario(Double salario) {
        Salario = salario;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", Salario=" + Salario +
                ", idade=" + idade +
                '}';
    }

    @Override
    public int compareTo(Pessoa p) {
        return p.getSalario().compareTo(getSalario());
    }
}
