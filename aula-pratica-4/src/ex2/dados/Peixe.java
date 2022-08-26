package ex2.dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public float calcularEspacoOcupado() {
        float s = this.altura * this.comprimento * this.altura;

        return s;
    }
}