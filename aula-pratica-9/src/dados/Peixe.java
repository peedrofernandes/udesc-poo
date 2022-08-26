package dados;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    @Override
    public float calcularEspacoOcupado() {
        float s = this.getAltura() * this.getLargura() * this.getComprimento();
        return s;
    }

    // public boolean equals(Peixe p) {

    // }

    public float getTemperaturaIdeal() {
        return this.temperaturaIdeal;
    }
}