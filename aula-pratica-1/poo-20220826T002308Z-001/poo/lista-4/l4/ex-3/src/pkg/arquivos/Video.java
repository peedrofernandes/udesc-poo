package pkg.arquivos;

import pkg.exceptions.NomeInvalidoException;

public class Video extends Arquivo {
  public enum Qualidade {
    Q240P(1), Q360P(2), Q720P(3), Q1024P(4);

    private int valor;

    Qualidade(int valor) {
      this.valor = valor;
    }

    public int getValor() {
      return this.valor;
    }

    public String toString() {
      String str = "";

      switch (this.valor) {
        case 1:
          str += "240p";
          break;
        case 2:
          str += "360p";
          break;
        case 3:
          str += "720p";
          break;
        case 4:
          str += "1024p";
          break;
      }

      return str;
    }
  }
  
  private Qualidade qualidade;

  public Video(String nome, Qualidade qualidade) throws NomeInvalidoException {
    super(nome);
    this.qualidade = qualidade;
    this.extensao = "mp4";
  }

  public String toString() {
    String str = "";

    str += super.toString() + "\n";
    str += "Qualidade: " + this.qualidade.toString();

    return str;
  }

  public Qualidade getQualidade() {
    return this.qualidade;
  }
}
