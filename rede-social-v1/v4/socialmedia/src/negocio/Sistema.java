package negocio;

import java.io.File;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dados.Post;
import dados.Usuario;
import exceptions.ExistingAliasException;
import exceptions.ExistingEmailException;
import exceptions.InsertException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.NonExistentRemovalException;
import exceptions.SelectException;
import exceptions.UnmatchedPasswordsException;
import exceptions.UpdateException;
import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
import persistencia.PostDAO;
import persistencia.UsuarioDAO;

public class Sistema {
  private UsuarioDAO usuarioDAO;
  private PostDAO postDAO;

  private final List<Usuario> usuariosCadastrados;
  private final List<Post> posts;
  private Usuario usuarioLogado;

  public Sistema() throws SQLException, SelectException {
    usuarioDAO = UsuarioDAO.getInstance();
    postDAO = PostDAO.getInstance();

    List<Usuario> listUsuario = new ArrayList<>();
    List<Post> listPost = new ArrayList<>();

    listUsuario = usuarioDAO.selectAll();
    listPost = postDAO.selectAll();

    usuariosCadastrados = listUsuario;
    posts = listPost;
  }
  
  public void cadastrarUsuario(
      String email, 
      String nomeCompleto, 
      String apelido,
      String senha,
      String confirmacaoSenha
  ) throws InvalidEmailException, ExistingEmailException, InvalidNameException, ExistingAliasException, InvalidPasswordException, UnmatchedPasswordsException, SelectException, InsertException {
    Seguranca.validarEmailCurto(email);
    Seguranca.validarEmailExistente(email, this.usuariosCadastrados);
    Seguranca.validarNomeCompleto(nomeCompleto);
    Seguranca.validarApelido(apelido, this.usuariosCadastrados);
    Seguranca.validarSenha(senha);
    Seguranca.validarSenhasIguais(senha, confirmacaoSenha);

    int id = this.usuariosCadastrados.size();

    Usuario novoUsuario = new Usuario(email, nomeCompleto, apelido, Seguranca.obterHash(senha));

    usuarioDAO.insert(novoUsuario);

    this.usuariosCadastrados.add(novoUsuario);
  }

  public void autenticar(String email, String senha) throws InvalidPasswordException, InvalidEmailException, UserNotFoundException, WrongPasswordException {
    Usuario user = new Usuario();
    boolean usuarioEncontrado = false;

    Seguranca.validarSenha(senha);
    Seguranca.validarEmailCurto(email);

    this.usuarioLogado = null;

    for (Usuario u : this.usuariosCadastrados) {
      if (u.getEmail().equals(email)) {
        user = u;
        usuarioEncontrado = true;
        break;
      }
    }

    if (!usuarioEncontrado)
      throw new UserNotFoundException("Usuário não encontrado!");

    Seguranca.validarSenhaCorreta(senha, user.getHashSenha());

    this.usuarioLogado = user;
  }
  
  public void editarDadosGeraisUsuario(String email, String nomeCompleto, String apelido, String biografia) throws InvalidEmailException, InvalidNameException, ExistingAliasException, UpdateException {
    if (this.usuarioLogado == null)
      return;

    String dataEmail = email.equals("") ? usuarioLogado.getEmail() : email;
    String dataNomeCompleto = nomeCompleto.equals("") ? usuarioLogado.getNomeCompleto() : nomeCompleto;
    String dataApelido = apelido.equals("") ? usuarioLogado.getApelido() : apelido;
    String dataBiografia = biografia.equals("") ? usuarioLogado.getBiografia() : biografia;

    if (!email.equals(""))
      Seguranca.validarEmailCurto(dataEmail);
    if (!nomeCompleto.equals(""))
      Seguranca.validarNomeCompleto(dataNomeCompleto);
    if (!apelido.equals(""))
      Seguranca.validarApelido(dataApelido, this.usuariosCadastrados);

    this.usuarioLogado.setEmail(dataEmail);
    this.usuarioLogado.setApelido(dataApelido);
    this.usuarioLogado.setNomeCompleto(dataNomeCompleto);
    this.usuarioLogado.setBiografia(dataBiografia);

    usuarioDAO.update(this.usuarioLogado);
  }

  public void editarSenhaUsuario(String novaSenha, String confirmarNovaSenha) throws UnmatchedPasswordsException, UpdateException {
    if (this.usuarioLogado == null)
      return;

    Seguranca.validarSenhasIguais(novaSenha, confirmarNovaSenha);

    String hashNovaSenha = Seguranca.obterHash(novaSenha);
    this.usuarioLogado.setHashSenha(hashNovaSenha);

    usuarioDAO.update(this.usuarioLogado);
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
  
  public void novoPost(File foto, String legenda, Date data) throws SelectException, InsertException {
    if (this.usuarioLogado == null)
      return;

    Usuario autor = this.usuarioLogado;

    Post p = new Post(autor, foto, legenda, data);

    this.posts.add(p);
    
    postDAO.insert(p);
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


