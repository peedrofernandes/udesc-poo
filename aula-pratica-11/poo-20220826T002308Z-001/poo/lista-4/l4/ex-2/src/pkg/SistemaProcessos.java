package pkg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pkg.exceptions.PilhaCheiaException;
import pkg.exceptions.ProcessoSemJuizException;

public class SistemaProcessos {
  private List<Juiz> juizes;
  private List<Processo> processos;

  public SistemaProcessos() {
    this.juizes = new ArrayList<>();
    this.processos = new ArrayList<>();
  }

  public void cadastrarProcesso(Processo p) {
    this.processos.add(p);
  }

  public void cadastrarJuiz(Juiz j) {
    this.juizes.add(j);
  }

  public void distribuirProcessos() throws ProcessoSemJuizException {
    int capacidadeProcessos = 0;

    for (Juiz j : this.juizes)
      capacidadeProcessos += j.getProcessos().getLimite();

    for (Processo p : this.processos) {
      if (capacidadeProcessos == 0)
        throw new ProcessoSemJuizException();

      atribuirProcesso(p);
      capacidadeProcessos--;
    }

  }
  
  private void atribuirProcesso(Processo p) {
    try {
      int numSorteado = new Random().nextInt() % this.juizes.size();
      int indiceJuizSorteado = Math.abs(numSorteado);
      this.juizes.get(indiceJuizSorteado).cadastrarProcesso(p);
    } catch (PilhaCheiaException exc) {
      atribuirProcesso(p);
    }
  }

  public List<Juiz> getJuizes() {
    return this.juizes;
  }

  public List<Processo> getProcessos() {
    return this.processos;
  }


}