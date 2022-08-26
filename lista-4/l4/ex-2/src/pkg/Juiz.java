package pkg;

import pkg.exceptions.PilhaCheiaException;

public class Juiz {
  private String nome;

  private Pilha<Processo> processos;

  public Juiz(String nome, int limite) {
    this.nome = nome;
    processos = new Pilha<Processo>(limite);
  }

  public void cadastrarProcesso(Processo p) throws PilhaCheiaException {
    this.processos.inserir(p);
  }

  public Pilha<Processo> getProcessos() {
    return this.processos;
  }

  public String getNome() {
    return this.nome;
  }
}
