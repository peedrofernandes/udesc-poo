package pkg;

public class MDC implements IOperacaoInteira {
  public int executar(int valor1, int valor2) {
    int menorValor = valor1 < valor2 ? valor1 : valor2;
    int mdc = 1;

    for (int i = 1; i <= menorValor; i++) {
      if ((valor1 % i == 0) && (valor2 % i == 0))
        mdc = i;
    }

    return mdc;
  }
}
