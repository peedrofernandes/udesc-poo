package dados;

import java.io.File;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import exceptions.NonExistentRemovalException;

// CREATE TABLE post (
// 	id SERIAL,
// 	id_autor INTEGER,
// 	foto OID,
// 	legenda VARCHAR(64),
// 	data_publicacao DATE,
// 	PRIMARY KEY (id),
// 	FOREIGN KEY (id_autor) REFERENCES usuario
// );

public class Post {
  // Atributos estáticos
  private int id;
  private Usuario autor;
  private File foto;
  private String legenda;
  private Date dataPublicacao;

  // Atributos de relacionamento
  private List<Usuario> usuariosQueFavoritaram;
  private List<Comentario> comentarios;
  public Post() {};

  public Post(int id, Usuario autor, File foto, String legenda, Date dataPublicacao) {
    this.id = id;
    this.autor = autor;
    this.foto = foto;
    this.legenda = legenda;
    this.dataPublicacao = dataPublicacao;

    this.usuariosQueFavoritaram = new LinkedList<>();
    this.comentarios = new LinkedList<>();
  }

  public Post(int id, Usuario autor, File foto, String legenda, Date dataPublicacao,
      List<Usuario> usuariosQueFavoritaram, List<Comentario> comentarios) {
    this.id = id;
    this.autor = autor;
    this.foto = foto;
    this.legenda = legenda;
    this.dataPublicacao = dataPublicacao;
    this.usuariosQueFavoritaram = usuariosQueFavoritaram;
    this.comentarios = comentarios;
  }
  
  public Post(Usuario autor, File foto, String legenda, Date dataPublicacao) {
    this.autor = autor;
    this.foto = foto;
    this.legenda = legenda;
    this.dataPublicacao = dataPublicacao;

    this.usuariosQueFavoritaram = new LinkedList<>();
    this.comentarios = new LinkedList<>();
  }

  public Post(Usuario autor, File foto, String legenda, Date dataPublicacao,
      List<Usuario> usuariosQueFavoritaram, List<Comentario> comentarios) {
    this.autor = autor;
    this.foto = foto;
    this.legenda = legenda;
    this.dataPublicacao = dataPublicacao;
    this.usuariosQueFavoritaram = usuariosQueFavoritaram;
    this.comentarios = comentarios;
  }

    public Post(int id, File foto, String legenda, Date dataPublicacao) {
        this.id = id;
        this.foto = foto;
        this.legenda = legenda;
        this.dataPublicacao = dataPublicacao;
    }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public File getFoto() {
    return foto;
  }
  public void setFoto(File foto) {
    this.foto = foto;
  }

  public String getLegenda() {
    return legenda;
  }
  public void setLegenda(String legenda) {
    this.legenda = legenda;
  }

  public Date getDataPublicacao() {
    return this.dataPublicacao;
  }
  public void setData(Date dataPublicacao) {
    this.dataPublicacao = dataPublicacao;
  }

  public Usuario getAutor() {
    return autor;
  }
  public void setAutor(Usuario autor) {
    this.autor = autor;
  }

  public List<Usuario> getUsuariosQueFavoritaram() {
    return usuariosQueFavoritaram;
  }

  public void setUsuariosQueFavoritaram(List<Usuario> usuariosQueFavoritaram) {
    this.usuariosQueFavoritaram = usuariosQueFavoritaram;
  }
  
  public void addFavorito(Usuario u) {
    this.usuariosQueFavoritaram.add(u);
  }

  public void removeFavorito(Usuario u) throws NonExistentRemovalException {
    int index = this.usuariosQueFavoritaram.indexOf(u);

    if (index == -1) {
      throw new NonExistentRemovalException("Remoção de favorito no post malsucedida!");
    }

    this.usuariosQueFavoritaram.remove(index);
  }

  public List<Comentario> getComentarios() {
    return comentarios;
  }
  public void setComentarios(List<Comentario> comentarios) {
    this.comentarios = comentarios;
  }
  public void addComentario(Comentario c) {
    this.comentarios.add(c);
  }
  public void removeComentario(Comentario c) throws NonExistentRemovalException {
    int index = this.comentarios.indexOf(c);

    if (index == -1) {
      throw new NonExistentRemovalException("Remoção de comentário no post malsucedida!");
    }

    this.comentarios.remove(index);
  }

  
}
