package pkg;

import java.util.LinkedList;
import java.util.List;

public class GenericIterator<T> implements Iterator<T> {
  private List<T> lista;
  private int indiceAtual;

  public GenericIterator(List<T> lista) {
    this.lista = lista;
    this.indiceAtual = -1;
  }

  public boolean hasNext() {
    if (lista.get(this.indiceAtual + 1) != null)
      return true;
    else
      return false;
  }

  public T next() {
    this.indiceAtual++;
    return this.lista.get(indiceAtual);
  }

  public void reset() {
    this.indiceAtual = -1;
  }

  public List<T> evensOdds() {
    List<T> list = new LinkedList<>();
    int i = 0;

    while (i < this.lista.size()) {
      list.add(this.lista.get(i));
      i += 2;

      if (i >= this.lista.size() && i % 2 == 0)
        i = 1;
    }

    return list;
  }
}
