package pkg.arquivos;

import pkg.exceptions.NomeInvalidoException;

public class Documento extends Arquivo {
  private String texto;

  public Documento(String nome, String texto) throws NomeInvalidoException {
    super(nome);
    this.texto = texto;
    this.extensao = "txt";
  }

  public String toString() {
    String str = "";
    
    str += super.toString() + "\n";
    str += "Descrição: " + this.texto;

    return str;
  }

  public String getTexto() {
    return this.texto;
  }
}
