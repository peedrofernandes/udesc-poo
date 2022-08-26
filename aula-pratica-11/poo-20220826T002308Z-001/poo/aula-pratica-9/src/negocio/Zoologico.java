package negocio;

import java.util.List;

import dados.Animal;
import dados.Viveiro;
import exceptions.EspacoIndisponivelException;

public class Zoologico {
    private List<Animal> animais;
    private List<Viveiro> viveiros;

    public void cadastrarViveiro(Viveiro viveiro) {
        this.viveiros.add(viveiro);
    }

    public void cadastrarAnimais(Animal animal) {
        this.animais.add(animal);
    }

    public List<Viveiro> mostrarViveiros() {
        return this.viveiros;
    }

    public List<Animal> mostrarAnimais() {
        return this.animais;
    }

    public void alocarAnimal(Animal animal, Viveiro viveiro) throws EspacoIndisponivelException {
        try {
            
        } catch (EspacoIndisponivelException e) {
            throw new EspacoIndisponivelException("Não há espaço disponível no viveiro para alocação do animal!");
        }
    }

    public List<Animal> getAnimais() {
        return this.animais;
    }
    public List<Viveiro> getViveiros() {
        return this.viveiros;
    }
}