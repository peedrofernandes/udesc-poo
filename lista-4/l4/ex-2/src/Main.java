import pkg.Juiz;
import pkg.Processo;
import pkg.SistemaProcessos;
import pkg.exceptions.ProcessoSemJuizException;

public class Main {
  public static void main(String[] args) throws Exception {
    SistemaProcessos sp = new SistemaProcessos();

    sp.cadastrarJuiz(new Juiz("Pedro", 5));
    sp.cadastrarJuiz(new Juiz("Paulo", 5));
    sp.cadastrarJuiz(new Juiz("Maria", 5));

    for (int i = 1; i <= 17; i++) {
      int id = i;
      String nome = "p" + i;

      sp.cadastrarProcesso(new Processo(id, nome));
    }

    try {
      sp.distribuirProcessos();
      System.out.println("Processos distribuidos com sucesso.\n");

      for (Juiz j : sp.getJuizes()) {
        System.out.println("Processos do juiz " + j.getNome() + ": ");
        for (Processo p : j.getProcessos().getElementos())
          System.out.println("- " + p);
        System.out.print("\n");
      }

    } catch (ProcessoSemJuizException e) {
      System.out.println("Não há juízes suficientes para distribuir tantos processos!");
    }

  }
}
