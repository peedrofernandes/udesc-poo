package ex2.dados;

import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;

    protected List<Animal> animais;

    public float calcularEspaco() {
        float s = this.comprimento * this.largura;

        return s;
    }

    private float espacoOcupado() {
        float s = 0;

        for (Animal animal : animais)
            s += animal.calcularEspacoOcupado();

        return s;
    }

    public float espacoDisponivel() {
        float s = this.calcularEspaco() - this.espacoOcupado();

        return s;
    }

    public boolean adicionarAnimal(Animal animal) {
        if (
            animal instanceof Peixe || 
            animal.calcularEspacoOcupado() >= this.espacoDisponivel() * 0.7
        ) return false;

        this.animais.add(animal);
        return true;
    }
}