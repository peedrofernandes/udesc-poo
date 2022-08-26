package pkg.arquivos;

import pkg.exceptions.NomeInvalidoException;

public abstract class Arquivo {
  protected String nome;
  protected String extensao;

  public Arquivo(String nome) throws NomeInvalidoException {
    boolean c1 = !nome.contains("\n");
    boolean c2 = !(nome.contains("[") || nome.contains("]"));
    boolean c3 = !(nome.contains("(") || nome.contains(")"));
    boolean c4 = !(nome.contains("\""));
    boolean c5 = !(nome.length() < 10 || nome.length() > 256);

    if (!c1 || !c2 || !c3 || !c4 || !c5)
      throw new NomeInvalidoException("O nome inserido foi inválido!");

    this.nome = nome;
  }

  public String toString() {
    String str = "";

    str += "Nome: " + this.nome + "." + this.extensao;

    return str;
  }

  public String getNome() {
    return this.nome;
  }

  public String getExtensao() {
    return this.extensao;
  }
}