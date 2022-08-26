package pkg.arquivos;

import pkg.exceptions.NomeInvalidoException;

public class Musica extends Arquivo {
  private int duracao;

  public Musica(String nome, int duracao) throws NomeInvalidoException {
    super(nome);
    this.duracao = duracao;
    this.extensao = "mp3";
  }

  public String toString() {
    String str = "";

    str += super.toString() + "\n";
    str += "Duracao: " + this.duracao + "s";

    return str;
  }

  public int getDuracao() {
    return this.duracao;
  }
}
