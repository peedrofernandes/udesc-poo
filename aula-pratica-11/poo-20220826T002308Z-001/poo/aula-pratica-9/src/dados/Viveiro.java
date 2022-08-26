package dados;

import java.util.List;

public class Viveiro {
    private List<Animal> animais;

    private float comprimento;
    private float largura;

    public float calcularEspaco() {
        float s = this.comprimento * this.largura;
        return s;
    }

    private float espacoOcupado() {
        float s = 0;

        for (Animal a : this.animais)
            s += a.calcularEspacoOcupado();

        return s;
    }

    public float espacoDisponivel() {
        float s = this.calcularEspaco() - this.espacoOcupado();
        return s;
    }

    public void adicionarAnimal(Animal a) {
        this.animais.add(a);
    }

    public List<Animal> getAnimais() {
        return this.animais;
    }
    public float getComprimento() {
        return this.comprimento;
    }
    public float getLargura() {
        return this.largura;
    }
}