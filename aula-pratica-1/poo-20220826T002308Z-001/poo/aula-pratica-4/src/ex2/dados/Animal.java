package ex2.dados;

public class Animal {
    private String nome;
    private String cor;
    private String especie;
    private int idade;
    protected float largura;
    protected float comprimento;
    protected float altura;

    public float calcularEspacoOcupado() {
        float s = this.comprimento * this.largura;
        return s;
    }
}