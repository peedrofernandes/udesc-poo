package dados;

import java.util.LinkedList;
import java.util.List;

// CREATE TABLE conversa (
//  id SERIAL,
//  id_usuario_1 INTEGER,
//  id_usuario_2 INTEGER,
//  PRIMARY KEY (id),
// 	FOREIGN KEY (id_usuario_1) REFERENCES usuario,
// 	FOREIGN KEY (id_usuario_2) REFERENCES usuario,
//  UNIQUE (id_usuario_1, id_usuario_2),
//  CHECK (id_usuario_1 < id_usuario_2)
// );

public class Conversa {
  // Atributos estáticos
  private int id;
  private Usuario usuario1;
  private Usuario usuario2;

  // Atributos de relacionamento
  private List<Mensagem> mensagens;

  public Conversa() {
  };

  public Conversa(int id, Usuario u1, Usuario u2) {
    this.id = id;
    this.usuario1 = u1;
    this.usuario2 = u2;

    this.mensagens = new LinkedList<>();
  }
  
  public Conversa(int id, Usuario u1, Usuario u2, List<Mensagem> mensagens) {
    this.id = id;
    this.usuario1 = u1;
    this.usuario2 = u2;
    this.mensagens = mensagens;
  }
  
    public Conversa(Usuario u1, Usuario u2) {
    this.usuario1 = u1;
    this.usuario2 = u2;

    this.mensagens = new LinkedList<>();
  }
  
  public Conversa(Usuario u1, Usuario u2, List<Mensagem> mensagens) {
    this.usuario1 = u1;
    this.usuario2 = u2;
    this.mensagens = mensagens;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public Usuario getUsuario1() {
    return usuario1;
  }
  public void setUsuario1(Usuario usuario1) {
    this.usuario1 = usuario1;
  }

  public Usuario getUsuario2() {
    return usuario2;
  }
  public void setUsuario2(Usuario usuario2) {
    this.usuario2 = usuario2;
  }

  public List<Mensagem> getMensagens() {
    return mensagens;
  }

  public void setMensagens(List<Mensagem> mensagens) {
    this.mensagens = mensagens;
  }

  public void addMensagem(Mensagem m) {
    this.mensagens.add(m);
  }
  public void removeMensgem(Mensagem m) {
    this.mensagens.remove(m);
  }

  
}
