package pkg;

public class Processo {
  private int id;
  private String nome;

  public Processo(int id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Processo() {
  };
  
  public String toString() {
    String str = "";

    str += this.nome + ", " + this.id;

    return str;
  }

  public int getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }


}
