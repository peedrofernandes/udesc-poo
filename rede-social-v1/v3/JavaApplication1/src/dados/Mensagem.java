package dados;

import java.sql.Date;

// CREATE TABLE mensagem (
// 	id SERIAL,
// 	id_conversa INTEGER,
//  id_autor INTEGER,
// 	texto VARCHAR(256),
// 	data_envio DATE,
// 	visualizado BOOLEAN,
// 	recebido BOOLEAN,
// 	PRIMARY KEY (id),
//  FOREIGN KEY (id_autor REFERENCES usuario),
// 	FOREIGN KEY (id_conversa) REFERENCES conversa
// );

public class Mensagem {
  private int id;
  private Conversa conversa;
  private Usuario autor;
  private String texto;
  private Date dataEnvio;
  private boolean visualizado;
  private boolean recebido;

  public Mensagem() {
  }

  public Mensagem(String texto, Date dataEnvio) {
    this.texto = texto;
    this.dataEnvio = dataEnvio;
    this.visualizado = false;
    this.recebido = false;
  }

  public Mensagem(int id, Conversa conversa, Usuario autor, String texto, Date dataEnvio, boolean visualizado,
      boolean recebido) {
    this.id = id;
    this.conversa = conversa;
    this.autor = autor;
    this.texto = texto;
    this.dataEnvio = dataEnvio;
    this.visualizado = visualizado;
    this.recebido = recebido;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getTexto() {
    return texto;
  }
  public void setTexto(String texto) {
    this.texto = texto;
  }
  
  public Date getDataEnvio() {
    return dataEnvio;
  }
  public void setDataEnvio(Date data) {
    this.dataEnvio = data;
  }

  public boolean isVisualizado() {
    return visualizado;
  }
  public void setVisualizado(boolean visualizado) {
    this.visualizado = visualizado;
  }


  public boolean isRecebido() {
    return recebido;
  }
  public void setRecebido(boolean recebido) {
    this.recebido = recebido;
  }
  
  public Conversa getConversa() {
    return this.conversa;
  }
  public void setConversa(Conversa conversa) {
    this.conversa = conversa;
  }

  public Usuario getAutor() {
    return autor;
  }
  public void setAutor(Usuario autor) {
    this.autor = autor;
  }
  
  

  
}
