package dados;

public class Pessoa {
    private String nome;
    private int idade;
    private float massa;
    private float altura;

    public Pessoa() {};

    public Pessoa(String nome, int idade, float massa, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.massa = massa;
        this.altura = altura;
    };

    public boolean equals(Object o) {
        Pessoa p = (Pessoa) (o);

        if (!(o instanceof Pessoa))
            return false;

        if (p.getNome() == this.getNome())
            return true;
        else
            return false;
    };

    public String toString() {
        String str = "";

        str += "Nome: " + this.nome + "\n";
        str += "Idade: " + this.idade + "\n";
        str += "Massa: " + this.massa + "\n";
        str += "Altura: " + this.altura + "\n";

        return str;
    };

    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public float getMassa() {
        return this.massa;
    }
    public float getAltura() {
        return this.altura;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setMassa(float massa) {
        this.massa = massa;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
}