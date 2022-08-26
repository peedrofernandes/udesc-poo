package dados;

import java.util.ArrayList;
import java.util.List;

import exceptions.NonExistentRemovalException;

// CREATE TABLE comentario (
// 	id SERIAL,
// 	id_post INTEGER,
// 	id_autor INTEGER,
// 	texto VARCHAR(256),
// 	PRIMARY KEY (id),
// 	FOREIGN KEY (id_post) REFERENCES post,
// 	FOREIGN KEY (id_autor) REFERENCES usuario
// );

public class Comentario {
  // Atributos estáticos
  private int id;
  private Post post;
  private Usuario autor;
  private String texto;

  // Atributos de relacionamento
  private List<Usuario> usuariosQueFavoritaram;

  public Comentario(int id, Post post, Usuario autor, String texto) {
    this.id = id;
    this.post = post;
    this.autor = autor;
    this.texto = texto;

    this.usuariosQueFavoritaram = new ArrayList<>();
  }

  public Comentario(int id, Post post, Usuario autor, String texto, List<Usuario> usuariosQueFavoritaram) {
    this.id = id;
    this.post = post;
    this.autor = autor;
    this.texto = texto;
    this.usuariosQueFavoritaram = usuariosQueFavoritaram;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  
  public Post getPost() {
    return post;
  }
  public void setPost(Post post) {
    this.post = post;
  }
  
  public Usuario getAutor() {
    return autor;
  }
  public void setAutor(Usuario autor) {
    this.autor = autor;
  }

  public String getTexto() {
    return texto;
  }
  public void setTexto(String texto) {
    this.texto = texto;
  }

  public void addFavorito(Usuario u) {
    this.usuariosQueFavoritaram.add(u);
  }
  public void removeFavorito(Usuario u) throws NonExistentRemovalException {
    int index = this.usuariosQueFavoritaram.indexOf(u);

    if (index == -1)
      throw new NonExistentRemovalException("Remoção de favorito no comentário malsucedida!");

    this.usuariosQueFavoritaram.remove(index);
  }
  
  public List<Usuario> getUsuariosQueFavoritaram() {
    return usuariosQueFavoritaram;
  }
  public void setUsuariosQueFavoritaram(List<Usuario> usuariosQueFavoritaram) {
    this.usuariosQueFavoritaram = usuariosQueFavoritaram;
  }

  
}