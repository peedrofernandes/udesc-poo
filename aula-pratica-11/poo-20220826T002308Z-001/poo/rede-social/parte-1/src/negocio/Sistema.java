package negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import dados.Post;
import dados.Usuario;
import exceptions.NonExistentRemovalException;

public class Sistema {
  private List<Usuario> usuariosCadastrados;
  private List<Post> posts;
  private Usuario usuarioLogado;

  public Sistema() {
    usuariosCadastrados = new ArrayList<Usuario>();
    posts = new ArrayList<Post>();
  }

  public String cadastrarUsuario(
    String nomeCompleto, 
    String apelido, 
    String email, 
    String senha,
    String biografia
  ) {
    String status = "";

    boolean condicaoEmailCurto = Seguranca.validarEmailCurto(email);
    boolean condicaoEmailExistente = Seguranca.validarEmailExistente(email, this.usuariosCadastrados);
    boolean condicaoNomeCompleto = Seguranca.validarNomeCompleto(nomeCompleto);
    boolean condicaoNomeUsuario = Seguranca.validarApelido(apelido, this.usuariosCadastrados);
    boolean condicaoSenha = Seguranca.validarSenha(senha);

    if (!condicaoEmailCurto || !condicaoEmailExistente || !condicaoNomeCompleto || !condicaoNomeUsuario || !condicaoSenha) {
      if (!condicaoEmailCurto)
        status += "E-mail inválido!" + "\n";

      if (!condicaoEmailExistente)
        status += "E-mail já existente!" + "\n";

      if (!condicaoNomeCompleto)
        status += "Nome completo inserido muito curto!" + "\n";

      if (!condicaoNomeUsuario)
        status += "Nome de usuário já existente!" + "\n";

      if (!condicaoSenha)
        status += "Senha muito curta (< 8 caracteres)" + "\n";

      return status;
    }

    int id = this.usuariosCadastrados.size();

    Usuario novoUsuario = new Usuario(id, apelido, email, Seguranca.obterHash(senha), nomeCompleto, biografia);

    this.usuariosCadastrados.add(novoUsuario);

    status += "Êxito";

    return status;
  }

  public boolean autenticar(String email, String senha) {
    Usuario user = new Usuario();
    boolean usuarioEncontrado = false;

    this.usuarioLogado = null;
    
    for (Usuario u : this.usuariosCadastrados) {
      if (u.getEmail().equals(email)) {
        user = u;
        usuarioEncontrado = true;
        break;
      }
    }

    if (!usuarioEncontrado)
      return false;

    boolean senhaCorreta = Seguranca.obterHash(senha).equals(user.getHashSenha());

    if (!senhaCorreta)
      return false;

    this.usuarioLogado = user;
    return true;
  }
  
  public boolean editarUsuario(String nomeUsuario, String nomeCompleto, String email, String biografia, String hashSenha) {
    if (this.usuarioLogado == null)
      return false;

    this.usuarioLogado.setApelido(nomeUsuario);
    this.usuarioLogado.setNomeCompleto(nomeCompleto);
    this.usuarioLogado.setEmail(email);
    this.usuarioLogado.setBiografia(biografia);
    this.usuarioLogado.setHashSenha(hashSenha);

    return true;
  }

  public Usuario obterUsuario(int idUsuario) {
    if (this.usuarioLogado == null)
      return new Usuario();

    Usuario user = new Usuario();

    for (Usuario u : this.usuariosCadastrados) {
      if (u.getId() == idUsuario) {
        user = u;
        break;
      }
    }

    return user;
  }

  public boolean excluirUsuario() {
    if (this.usuarioLogado == null)
      return false;

    this.usuariosCadastrados.remove(this.usuarioLogado);
    this.usuarioLogado = null;

    return true;
  }
  
  public boolean novoPost(File foto, String legenda, String data) {
    if (this.usuarioLogado == null)
      return false;

    int id = this.posts.size();
    Usuario autor = this.usuarioLogado;

    Post p = new Post(id, autor, foto, legenda, data);

    this.posts.add(p);

    return true;
  }

  public Post obterPost(int idPost) {
    Post p = new Post();

    if (this.usuarioLogado == null)
      return p;
    if (idPost >= this.posts.size() || idPost < 0)
      return p;

    p = this.posts.get(idPost);

    return p;
  }

  public boolean excluirPost(int idPost) throws NonExistentRemovalException {
    if (this.usuarioLogado == null)
      return false;

    Post p = this.posts.get(idPost);

    if (p == null) 
      return false;

    if (!p.getAutor().equals(this.usuarioLogado))
      return false;

    for (Usuario u : this.usuariosCadastrados)
      u.desfavoritar(p);
    this.usuarioLogado.excluirPost(p);
    this.posts.remove(p);

    return true;
  }

  public List<Post> obterFeed() {
    List<Post> post = new ArrayList<>();

    if (usuarioLogado == null)
      return post;

    for (Usuario u : this.usuarioLogado.getSeguindo()) {
      for (Post p : u.getPosts())
        post.add(p);
    }

    return post;
  }

  public List<Usuario> buscarUsuarios(String busca) {
    List<Usuario> usuarios = new ArrayList<>();

    if (this.usuarioLogado == null)
      return usuarios;

    for (Usuario u : this.usuariosCadastrados) {
      if (u.getApelido().contains(busca))
        usuarios.add(u);
    }

    return usuarios;
  }

  public List<Usuario> getUsuariosCadastrados() {
    return this.usuariosCadastrados;
  }

  public List<Post> getPosts() {
    return this.posts;
  }

  public Usuario getUsuarioLogado() {
    return this.usuarioLogado;
  }

}


