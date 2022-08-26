package persistencia;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Comentario;
import dados.Conversa;
import dados.Mensagem;
import dados.Post;
import dados.Usuario;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;
import uteis.FileHandling;

// CREATE TABLE usuario (
// 	id SERIAL,
// 	apelido VARCHAR(16),
// 	email VARCHAR(64),
// 	hash_senha VARCHAR(256),
// 	nome_completo VARCHAR(64),
// 	biografia VARCHAR(256),
// 	PRIMARY KEY (id)
// );

  // // Atributos estáticos
  
  // private int id;
  // private String apelido;
  // private String email;
  // private String hashSenha;
  // private String nomeCompleto;
  // private String biografia;

  // // Atributos de relacionamento
  // private List<Usuario> seguidores;
  // private List<Usuario> seguindo;
  // private List<Post> posts;
  // private List<Post> postsFavoritos;
  // private List<Conversa> conversas;

public class UsuarioDAO extends DAO <Usuario> {
  private static UsuarioDAO instance = null;

  private PreparedStatement selectAll;
  private PreparedStatement selectMensagensEnviadas;
  private PreparedStatement selectConversas;
  private PreparedStatement selectPosts;
  private PreparedStatement selectCurtidasComentarios;
  private PreparedStatement selectCurtidasPosts;
  private PreparedStatement selectMensagensRecebidas;
  private PreparedStatement selectComentarios;
  private PreparedStatement selectSeguidores;
  private PreparedStatement selectSeguidos;
  
  private PreparedStatement insertSeguido;
  private PreparedStatement deleteSeguido;

  private UsuarioDAO usuarioDAO = null;
  private ConversaDAO conversaDAO = null;
  private ComentarioDAO comentarioDAO = null;
  private PostDAO postDAO = null;

  private UsuarioDAO() throws SQLException {
    super();
    
    selectNextId = conexao.prepareStatement("SELECT nextval('usuario_id_seq')");
    select = conexao.prepareStatement("SELECT * FROM usuario WHERE id = ?");
    insert = conexao.prepareStatement("INSERT INTO usuario (id, apelido, email, hash_senha, nome_completo, biografia) VALUES (?,?,?,?,?,?)");
    update = conexao.prepareStatement("UPDATE usuario SET apelido = ?, email = ?, hash_senha = ?, nome_completo = ?, biografia = ? WHERE id = ?");
    delete = conexao.prepareStatement("DELETE FROM usuario WHERE id = ?");

    selectAll = conexao.prepareStatement("SELECT * FROM usuario");
    selectMensagensEnviadas = conexao.prepareStatement("SELECT * FROM mensagem WHERE id_autor = ?");
    selectConversas = conexao.prepareStatement("SELECT * FROM conversa WHERE id_usuario_1 = ? OR id_usuario_2 = ?");
    selectPosts = conexao.prepareStatement("SELECT * FROM post WHERE id_autor = ?");
    selectCurtidasComentarios = conexao.prepareStatement("SELECT * FROM comentario_favorito WHERE id_usuario = ?");
    selectCurtidasPosts = conexao.prepareStatement("SELECT * FROM post_favorito WHERE id_usuario = ?");
    selectMensagensRecebidas = conexao.prepareStatement("SELECT (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido) FROM mensagem m JOIN conversa c ON (m.id_conversa = c.id) WHERE (c.id_usuario_1 = ? OR c.id_usuario_2 = ?) AND (m.id_autor <> ?)");
    selectComentarios = conexao.prepareStatement("SELECT * FROM comentario WHERE id_autor = ?");
    selectSeguidores = conexao.prepareStatement("SELECT * FROM seguido_seguidor WHERE id_seguido = ?");
    selectSeguidos = conexao.prepareStatement("SELECT * FROM seguido_seguidor WHERE id_seguidor = ?");
    insertSeguido = conexao.prepareStatement("INSERT INTO seguido_seguidor (id_seguido, id_seguidor) VALUES (?,?)");
    deleteSeguido = conexao.prepareStatement("DELETE FROM seguido_seguidor WHERE (id_seguido, id_seguidor) = (?,?)");
  
    usuarioDAO = UsuarioDAO.getInstance();
    conversaDAO = ConversaDAO.getInstance();
    comentarioDAO = ComentarioDAO.getInstance();
    postDAO = PostDAO.getInstance();
  }

  public static UsuarioDAO getInstance() throws SQLException {
    if (instance != null)
      return instance;
    instance = new UsuarioDAO();
    return instance;
  }

  protected int selectNextId() throws SelectException {
    try {
      ResultSet result = selectNextId.executeQuery();

      if (result.next())
        return result.getInt(1);

    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar o próximo ID da tabela de usuários!");
    }

    return 0;
  }

  public Usuario select(int idUsuario) throws SelectException {
    // id; apelido; email; hashSenha; nomeCompleto; biografia; seguidores; seguindo; posts; postsFavoritos; conversas;
    try {
      select.setInt(1, idUsuario);
      ResultSet result = select.executeQuery();

      if (result.next()) {
        int id = result.getInt(1);
        String apelido = result.getString(2);
        String email = result.getString(3);
        String hashSenha = result.getString(4);
        String nomeCompleto = result.getString(5);
        String biografia = result.getString(6);

        List<Usuario> seguidores = selectSeguidores(idUsuario);
        List<Usuario> seguindo = selectSeguidos(idUsuario);
        List<Post> posts = selectPosts(idUsuario);
        List<Post> postsFavoritos = selectCurtidasPosts(idUsuario);
        List<Conversa> conversas = selectConversas(idUsuario);

        return new Usuario(id, apelido, email, hashSenha, nomeCompleto, biografia, seguidores, seguindo, posts,
            postsFavoritos, conversas);
      }
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível encontrar o usuário especificado de id " + idUsuario + "!");
    }

    return null;
  }

  public void insert(Usuario u) throws SelectException, InsertException {
    // (id, apelido, email, hash_senha, nome_completo, biografia)
    try {
      insert.setInt(1, selectNextId());
      insert.setString(2, u.getApelido());
      insert.setString(3, u.getEmail());
      insert.setString(4, u.getHashSenha());
      insert.setString(5, u.getNomeCompleto());
      insert.setString(6, u.getBiografia());

      insert.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir um novo usuário!");
    }
  }

  public void update(Usuario u) throws UpdateException {
    // (apelido, email, hash_senha, nome_completo, biografia, id)
    try {
      update.setString(1, u.getApelido());
      update.setString(2, u.getEmail());
      update.setString(3, u.getHashSenha());
      update.setString(4, u.getNomeCompleto());
      update.setString(5, u.getBiografia());
      update.setInt(6, u.getId());

      update.executeUpdate();
    } catch (SQLException exc) {
      throw new UpdateException("Não foi possível atualizar o usuário " + u.getApelido() + "! (id: " + u.getId() + ")");
    }
  }

  public void delete(Usuario u) throws DeleteException {
    try {
      delete.setInt(1, u.getId());
      delete.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir o usuário " + u.getApelido() + "! (id: " + u.getId() + ")");
    }
  }

  // private PreparedStatement selectMensagensEnviadas;
  // private PreparedStatement selectConversas;
  // private PreparedStatement selectPosts;
  // private PreparedStatement selectCurtidasComentarios;
  // private PreparedStatement selectCurtidasPosts;
  // private PreparedStatement selectMensagensRecebidas;
  // private PreparedStatement selectComentarios;
  // private PreparedStatement selectSeguidores;
  // private PreparedStatement selectSeguidos;
  
  // private PreparedStatement insertSeguido;
  // private PreparedStatement deleteSeguido;
  public List<Usuario> selectAll() throws SelectException {
    try {
      List<Usuario> usuarios = new ArrayList<>();

      ResultSet result = selectAll.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        String email = result.getString(3);
        String nomeCompleto = result.getString(5);
        String apelido = result.getString(2);
        String hashSenha = result.getString(4);
        String biografia = result.getString(6);

        List<Usuario> seguidores = selectSeguidores(id);
        List<Usuario> seguindo = selectSeguidos(id);
        List<Post> posts = selectPosts(id);
        List<Post> postsFavoritos = selectCurtidasPosts(id);
        List<Conversa> conversas = selectConversas(id);

        Usuario u = new Usuario(id, email, nomeCompleto, apelido, hashSenha, biografia, seguidores, seguindo, posts,
            postsFavoritos, conversas);

        usuarios.add(u);
      }

      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar todos os usuários!" + exc.getMessage());
    }
  }
  
  public List<Mensagem> selectMensagensEnviadas(int idUsuario) throws SelectException {
    // (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido)
    try {
      List<Mensagem> mensagens = new ArrayList<>();

      selectMensagensEnviadas.setInt(1, idUsuario);

      ResultSet result = selectMensagensEnviadas.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        int idConversa = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);
        Date dataEnvio = result.getDate(5);
        Boolean visualizado = result.getBoolean(6);
        Boolean recebido = result.getBoolean(7);

        Conversa conversa = conversaDAO.select(idConversa);
        Usuario autor = usuarioDAO.select(idAutor);

        Mensagem m = new Mensagem(id, conversa, autor, texto, dataEnvio, visualizado, recebido);

        mensagens.add(m);
      }

      return mensagens;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar mensagens recebidas pelo usuário " + idUsuario + "!");
    }
  }
  
  public List<Conversa> selectConversas(int idUsuario) throws SelectException {
    // (id, id_usuario_1, id_usuario_2)
    try {
      List<Conversa> conversas = new ArrayList<>();

      selectConversas.setInt(1, idUsuario);
      selectConversas.setInt(2, idUsuario);

      ResultSet result = selectConversas.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        int idUsuario1 = result.getInt(2);
        int idUsuario2 = result.getInt(3);

        Usuario u1 = usuarioDAO.select(idUsuario1);
        Usuario u2 = usuarioDAO.select(idUsuario2);

        List<Mensagem> mensagens = conversaDAO.selectMensagens(id);

        Conversa conversa = new Conversa(id, u1, u2, mensagens);

        conversas.add(conversa);
      }

      return conversas;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar todas as conversas do usuário " + idUsuario + "!");
    }
  }

  public List<Post> selectPosts(int idUsuario) throws SelectException {
    // id_autor, foto, legenda, data_publicacao, id;
    try {
      List<Post> posts = new ArrayList<>();

      selectPosts.setInt(1, idUsuario);
      ResultSet result = selectPosts.executeQuery();

      while (result.next()) {
        try {

          int id = result.getInt(1);
          int idAutor = result.getInt(2);
          InputStream fotoInputStream = result.getBinaryStream(3);
          String legenda = result.getString(4);
          Date dataPublicacao = result.getDate(5);
          
          Usuario autor = usuarioDAO.select(idAutor);
          
          String path = "src/main/resources/postsImages/post-" + id + ".png";
          File foto = FileHandling.inputStreamToFile(fotoInputStream, path);
          Post post = new Post(id, autor, foto, legenda, dataPublicacao);
          
          posts.add(post);
        } catch (IOException exc) {
          throw new SelectException("Houve um erro na transformação de fluxo de dados para arquivo!" + exc.getMessage());
        }
      }

      return posts;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os posts do usuário " + idUsuario + "!");
    }
  }

  public List<Comentario> selectCurtidasComentarios(int idUsuario) throws SelectException {
    // 	(comentario_favorito) id_usuario INTEGER, id_comentario INTEGER,
    try {
      List<Comentario> comentarios = new ArrayList<>();

      selectCurtidasComentarios.setInt(1, idUsuario);

      ResultSet result = selectCurtidasComentarios.executeQuery();

      while (result.next()) {
        int idComentario = result.getInt(2);

        Comentario comentario = comentarioDAO.select(idComentario);

        comentarios.add(comentario);
      }

      return comentarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os comentários curtidos do usuário " + idUsuario + "!");
    }
  }

  public List<Post> selectCurtidasPosts(int idUsuario) throws SelectException {
    // posts_favoritos: id_usuario INTEGER, id_post INTEGER,
    try {
      List<Post> posts = new ArrayList<>();

      selectCurtidasPosts.setInt(1, idUsuario);
      ResultSet result = selectCurtidasPosts.executeQuery();

      while (result.next()) {
        int idPost = result.getInt(2);

        Post post = postDAO.select(idPost);

        posts.add(post);
      }

      return posts;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os posts curtidos do usuário " + idUsuario + "!");
    }
  }

  public List<Mensagem> selectMensagensRecebidas(int idUsuario) throws SelectException {
    // (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido)
    try {
      List<Mensagem> mensagens = new ArrayList<>();

      selectMensagensRecebidas.setInt(1, idUsuario);
      selectMensagensRecebidas.setInt(2, idUsuario);
      selectMensagensRecebidas.setInt(3, idUsuario);

      ResultSet result = selectMensagensRecebidas.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        int idConversa = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);
        Date dataEnvio = result.getDate(5);
        Boolean visualizado = result.getBoolean(6);
        Boolean recebido = result.getBoolean(7);

        Conversa conversa = conversaDAO.select(idConversa);
        Usuario autor = usuarioDAO.select(idAutor);

        Mensagem mensagem = new Mensagem(id, conversa, autor, texto, dataEnvio, visualizado, recebido);

        mensagens.add(mensagem);
      }

      return mensagens;

    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar as mensagens recebidas do usuário " + idUsuario + "!");
    }
  }

  public List<Comentario> selectComentarios(int idUsuario) throws SelectException {
    // (comentario): id SERIAL, id_post INTEGER, id_autor INTEGER, texto VARCHAR(256),
    try {
      List<Comentario> comentarios = new ArrayList<>();

      selectComentarios.setInt(1, idUsuario);

      ResultSet result = selectComentarios.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        int idPost = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);

        Post post = postDAO.select(idPost);
        Usuario autor = usuarioDAO.select(idAutor);

        Comentario comentario = new Comentario(id, post, autor, texto);

        comentarios.add(comentario);
      }

      return comentarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os comentários do usuário " + idUsuario + "!");
    }
  }

  public List<Usuario> selectSeguidores(int idUsuario) throws SelectException {
    // id SERIAL, id_seguido INTEGER, id_seguidor INTEGER,
    try {
      List<Usuario> usuarios = new ArrayList<>();
      selectSeguidores.setInt(1, idUsuario);
      ResultSet result = selectSeguidores.executeQuery();

      while (result.next()) {
        int idSeguidor = result.getInt(3);
        Usuario usuario = select(idSeguidor);
        usuarios.add(usuario);
      }

      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os seguidores do usuário " + idUsuario + "!");
    }
  }

  public List<Usuario> selectSeguidos(int idUsuario) throws SelectException {
    // id SERIAL, id_seguido INTEGER, id_seguidor INTEGER,
    try {
      List<Usuario> usuarios = new ArrayList<>();
      selectSeguidos.setInt(1, idUsuario);
      ResultSet result = selectSeguidos.executeQuery();

      while (result.next()) {
        int idSeguido = result.getInt(2);
        Usuario usuario = select(idSeguido);
        usuarios.add(usuario);
      }

      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar os usuários que o usuário " + idUsuario + " segue!");
    }
  }

  public void insertSeguido(int idSeguido, int idSeguidor) throws InsertException {
    try {
      insertSeguido.setInt(1, idSeguido);
      insertSeguido.setInt(2, idSeguidor);

      insertSeguido.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir um novo seguidor para o usuário " + idSeguido + "!");
    }
  }

  public void deleteSeguido(int idSeguido, int idSeguidor) throws DeleteException {
    try {
      deleteSeguido.setInt(1, idSeguido);
      deleteSeguido.setInt(2, idSeguidor);

      deleteSeguido.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException(
          "Não foi possível excluir o seguidor " + idSeguidor + " do usuário seguido " + idSeguido + "!");
    }
  }
}