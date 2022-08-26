package ex2.dados;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public float calcularEspaco() {
        float s = this.altura * this.comprimento * this.largura;

        return s;
    }

    public boolean adicionarAnimal(Animal animal) {
        if (
            !(animal instanceof Peixe) || 
            animal.calcularEspacoOcupado() > this.calcularEspaco() * 0.7
        ) return false;

        this.animais.add(animal);

        return true;
    }
}