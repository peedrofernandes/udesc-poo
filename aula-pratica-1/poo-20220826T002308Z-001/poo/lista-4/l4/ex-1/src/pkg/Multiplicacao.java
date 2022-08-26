package pkg;

public class Multiplicacao extends Soma {
  public int executar(int valor1, int valor2) {
    int res = 0;

    for (int i = 0; i < valor2; i++)
      res += super.executar(valor1, valor1);

    return res;
  }
}
