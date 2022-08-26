package dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    private float largura;
    private float comprimento;
    private float altura;

    public float calcularEspacoOcupado() {
        float s = this.largura * this.comprimento;
        return s;
    }

    public boolean equals(Animal a) {
        boolean b1 = this.nome == a.nome;
        boolean b2 = this.cor == a.cor;
        boolean b3 = this.especie == a.especie;
        boolean b4 = this.idade == a.idade;
        boolean b5 = this.largura == a.largura;
        boolean b6 = this.comprimento == a.comprimento;
        boolean b7 = this.altura == a.altura;

        if (b1 && b2 && b3 && b4 && b5 && b6 && b7)
            return true;
        else 
            return false;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCor() {
        return this.cor;
    }

    public String getEspecie() {
        return this.especie;
    }

    public int getIdade() {
        return this.idade;
    }

    public float getLargura() {
        return this.largura;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public float getAltura() {
        return this.altura;
    }
}