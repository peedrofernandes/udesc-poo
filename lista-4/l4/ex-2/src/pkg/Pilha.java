package pkg;

import java.util.LinkedList;
import java.util.List;

import pkg.exceptions.PilhaCheiaException;
import pkg.exceptions.PilhaVaziaException;

public class Pilha<T> {
  private int limite;
  private List<T> elementos;

  public Pilha(int limite) {
    this.limite = limite;
    this.elementos = new LinkedList<T>();
  }

  public void inserir(T objeto) throws PilhaCheiaException {
    if (this.elementos.size() == this.limite)
      throw new PilhaCheiaException();

    this.elementos.add(objeto);
  }
  
  public void remover() throws PilhaVaziaException {
    if (this.elementos.size() == 0)
      throw new PilhaVaziaException();

    this.elementos.remove(this.elementos.size() - 1);
  }

  public int getSize() {
    return this.elementos.size();
  }

  public int getLimite() {
    return this.limite;
  }

  public List<T> getElementos() {
    return this.elementos;
  }
}