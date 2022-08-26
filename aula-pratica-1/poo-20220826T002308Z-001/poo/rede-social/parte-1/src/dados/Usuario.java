package dados;

import java.util.ArrayList;
import java.util.List;

import exceptions.NonExistentRemovalException;

// CREATE TABLE usuario (
// 	id SERIAL,
// 	apelido VARCHAR(16),
// 	email VARCHAR(64),
// 	hash_senha VARCHAR(256),
// 	nome_completo VARCHAR(64),
// 	biografia VARCHAR(256),
// 	PRIMARY KEY (id)
// );

public class Usuario {
  // Atributos estáticos
  
  private int id;
  private String apelido;
  private String email;
  private String hashSenha;
  private String nomeCompleto;
  private String biografia;

  // Atributos de relacionamento
  private List<Usuario> seguidores;
  private List<Usuario> seguindo;
  private List<Post> posts;
  private List<Post> postsFavoritos;
  private List<Conversa> conversas;

  public Usuario() {
  };

  public Usuario(
    int id,
    String apelido,
    String email,
    String hashSenha,
    String nomeCompleto,
    String biografia
  ) {
    this.id = id;
    this.apelido = apelido;
    this.email = email;
    this.hashSenha = hashSenha;
    this.nomeCompleto = nomeCompleto;
    this.biografia = biografia;

    this.seguidores = new ArrayList<>();
    this.seguindo = new ArrayList<>();
    this.posts = new ArrayList<>();
    this.postsFavoritos = new ArrayList<>();
  }

  public Usuario(
      int id,
      String apelido,
      String email,
      String hashSenha,
      String nomeCompleto,
      String biografia,
      List<Usuario> seguidores,
      List<Usuario> seguindo,
      List<Post> posts,
      List<Post> postsFavoritos,
      List<Conversa> conversas) {
    this.id = id;
    this.apelido = apelido;
    this.email = email;
    this.hashSenha = hashSenha;
    this.nomeCompleto = nomeCompleto;
    this.biografia = biografia;
    this.seguidores = seguidores;
    this.seguindo = seguindo;
    this.posts = posts;
    this.postsFavoritos = postsFavoritos;
    this.conversas = conversas;
  }

  public void seguir(Usuario u) {
    this.seguindo.add(u);
    u.receberSeguidor(this);
  };

  public void receberSeguidor(Usuario u) {
    this.seguidores.add(u);
  };

  public void deixarDeSeguir(Usuario u) {
    this.seguindo.remove(u);
    u.perderSeguidor(this);
  };

  public void perderSeguidor(Usuario u) {
    this.seguidores.remove(u);
  }

  public void postar(Post p) {
    this.posts.add(p);
  };

  public void excluirPost(Post p) {
    this.posts.remove(p);
  };

  public void favoritar(Post p) {
    this.postsFavoritos.add(p);
    p.addFavorito(this);
  }

  public void desfavoritar(Post p) throws NonExistentRemovalException {
    this.postsFavoritos.remove(p);
    p.removeFavorito(this);
  }

  public List<Post> obterPostsDeSeguidores() {
    List<Post> posts = new ArrayList<>();

    for (Usuario seguido : this.seguindo) {
      for (Post p : seguido.getPosts())
        posts.add(p);
    }

    return posts;
  }

  // public void iniciarConversa(Usuario u) {
  //   Conversa c = new Conversa
  // }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

  public String getApelido() {
    return apelido;
  }
  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getHashSenha() {
    return hashSenha;
  }
  public void setHashSenha(String hashSenha) {
    this.hashSenha = hashSenha;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }
  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getBiografia() {
    return biografia;
  }
  public void setBiografia(String biografia) {
    this.biografia = biografia;
  }

  public List<Usuario> getSeguidores() {
    return seguidores;
  }
  public void setSeguidores(List<Usuario> seguidores) {
    this.seguidores = seguidores;
  }

  public List<Usuario> getSeguindo() {
    return seguindo;
  }
  public void setSeguindo(List<Usuario> seguindo) {
    this.seguindo = seguindo;
  }

  public List<Post> getPosts() {
    return posts;
  }
  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<Post> getPostsFavoritos() {
    return postsFavoritos;
  }
  public void setPostsFavoritos(List<Post> postsFavoritos) {
    this.postsFavoritos = postsFavoritos;
  }

  public List<Conversa> getConversas() {
    return conversas;
  }
  public void setConversas(List<Conversa> conversas) {
    this.conversas = conversas;
  }

  public String toString() {
    String str = "";

    str += "ID: " + this.id + "\n";
    str += "Apelido: " + this.apelido + "\n";
    str += "Email: " + this.email + "\n";
    str += "hashSenha: " + this.hashSenha + "\n";
    str += "Nome Completo: " + this.nomeCompleto + "\n";
    str += "Biografia: " + this.biografia + "\n";

    return str;
  }
}