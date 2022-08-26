import java.util.LinkedList;
import java.util.List;

import pkg.GenericIterator;

public class App {
  private static GenericIterator<Character> iterador;

  public static void main(String[] args) throws Exception {
    List<Character> lista = new LinkedList<>();

    lista.add('A');
    lista.add('B');
    lista.add('C');
    lista.add('D');
    lista.add('E');
    lista.add('F');
    lista.add('G');
    lista.add('H');

    iterador = new GenericIterator<Character>(lista);

    System.out.println(iterador.evensOdds());
  }
}
