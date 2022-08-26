package pkg;

import java.util.ArrayList;
import java.util.List;

public class Servidor implements Sujeito {
  private String ip;
  private String ultimaMensagem;
  private List<Observador> observadores;

  public Servidor(String ip) {
    this.ip = ip;
    this.ultimaMensagem = "";
    this.observadores = new ArrayList<>();
  }

  public Servidor(String ip, List<Observador> observadores) {
    this.ip = ip;
    this.ultimaMensagem = "";
    this.observadores = observadores;
  }

  public void enviarMensagem(String mensagem) {
    this.ultimaMensagem = mensagem;
    notificar();
  }
  
  public void notificar() {
    for (Observador ob : this.observadores)
      ob.atualizar(this.ultimaMensagem);
  }

  public void adicionar(Observador observador) {
    this.observadores.add(observador);
  }
  public void remover(Observador observador) {
    this.observadores.remove(observador);
  }

  public String toString() {
    String str = "";

    str += "IP: " + this.ip + "\n";
    str += "Última mensagem: " + this.ultimaMensagem + "\n";
    str += "Total de observadores: " + this.observadores.size() + "\n";

    return str;
  }
}
