package pkg;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Observador {
  List<String> mensagens;
  private String nome;

  public Cliente(String nome) {
    this.nome = nome;
    this.mensagens = new ArrayList<>();
  }

  public void atualizar(Object objeto) {
    this.mensagens.add((String)objeto);
  }

  public List<String> getMensagens() {
    return this.mensagens;
  }

  public void addMensagem(String str) {
    this.mensagens.add(str);
  }

  public String getNome() {
    return this.nome;
  }
  
  public String toString() {
    String str = "";
    int indice = 0;

    str += "Cliente: " + this.nome + "\n";
    for (String mensagem : this.mensagens) {
      str += "Mensagem " + indice + ": " + mensagem + "\n";
      indice++;
    }

    return str;
  }
}
