package persistencia;

import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Comentario;
import dados.Post;
import dados.Usuario;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

// CREATE TABLE post (
// 	id SERIAL,
// 	id_autor INTEGER,
// 	foto OID,
// 	legenda VARCHAR(64),
// 	data_publicacao DATE,
// 	PRIMARY KEY (id),
// 	FOREIGN KEY (id_autor) REFERENCES usuario
// );

  // // Atributos estáticos
  // private int id;
  // private Usuario autor;
  // private Blob foto;
  // private String legenda;
  // private Date dataPublicacao;

  // // Atributos de relacionamento
  // private List<Usuario> usuariosQueFavoritaram;
  // private List<Comentario> comentarios;

public class PostDAO extends DAO <Post> {
  private static PostDAO instance = null;

  private PreparedStatement selectComentarios;
  private PreparedStatement selectCurtidas;
  private PreparedStatement insertCurtida;
  private PreparedStatement deleteCurtida;

  private static UsuarioDAO usuarioDAO = null;
  private static PostDAO postDAO = null;

  private PostDAO() throws SQLException {

  selectNextId = conexao.prepareStatement("SELECT NEXTVAL('post_id_seq')");
  insert = conexao.prepareStatement("INSERT INTO post (id, id_autor, foto, legenda, data_publicacao) VALUES (?,?,?,?,?)");
  select = conexao.prepareStatement("SELECT * FROM post WHERE id = ?");
  update = conexao.prepareStatement("UPDATE post SET id_autor = ?, foto = ?, legenda = ?, data_publicacao = ? WHERE id = ?");
  delete = conexao.prepareStatement("DELETE FROM post WHERE id = ?");

  selectComentarios = conexao.prepareStatement("SELECT * FROM comentario WHERE id_post = ?");
  selectCurtidas = conexao.prepareStatement("SELECT * FROM post_favorito WHERE id_post = ?");
  insertCurtida = conexao.prepareStatement("INSERT INTO post_favorito (id_post, id_usuario) VALUES (?,?)");
  deleteCurtida = conexao.prepareStatement("DELETE FROM post_favorito WHERE (id_post, id_usuario) = (?,?)");

  usuarioDAO = UsuarioDAO.getInstance();
  postDAO = PostDAO.getInstance();
}

  public static PostDAO getInstance() throws SQLException {
    // (id, id_autor, foto, legenda, data_publicacao)

    if (instance != null)
      return instance;

    return new PostDAO();
  }

  public int selectNextId() throws SelectException {
    try {
      ResultSet result = selectNextId.executeQuery();
      if (result.next())
        return result.getInt(1);
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível obter o próximo ID de Posts!");
    }

    return 0;
  }

  public void insert(Post p) throws InsertException, SelectException {
    // (id, id_autor, foto, legenda, data_publicacao)
    try {
      int idPost = selectNextId();
      insert.setInt(1, idPost);
      insert.setInt(2, p.getAutor().getId());
      insert.setBlob(3, p.getFoto());
      insert.setString(4, p.getLegenda());
      insert.setDate(5, p.getDataPublicacao());
      insert.executeUpdate();
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível inserir um novo post na tabela posts!\nDetalhes: " + exc.getMessage());
    }
  }

  public Post select(int idPost) throws SelectException {
    // id; autor; foto; legenda; dataPublicacao; usuariosQueFavoritaram; comentarios;
    try {
      select.setInt(1, idPost);
      ResultSet result = select.executeQuery();
      if (result.next()) {
        int id = result.getInt(1);
        int idAutor = result.getInt(2);
        Blob foto = result.getBlob(3);
        String legenda = result.getString(4);
        Date dataPublicacao = result.getDate(5);

        Usuario autor = usuarioDAO.select(idAutor);

        List<Usuario> usuariosQueFavoritaram = selectCurtidas(idPost);
        List<Comentario> comentarios = selectComentarios(idPost);

        return new Post(id, autor, foto, legenda, dataPublicacao, usuariosQueFavoritaram, comentarios);
      }
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar o post especificado de id " + idPost + "!");
    }

    return null;
  }
  
  public void update(Post p) throws UpdateException {
    // id_autor, foto, legenda, data_publicacao, id;
    try {
      update.setInt(1, p.getAutor().getId());
      update.setBlob(2, p.getFoto());
      update.setString(3, p.getLegenda());
      update.setDate(4, p.getDataPublicacao());
      update.setInt(5, p.getId());
      update.executeUpdate();
    } catch (SQLException exc) {
      throw new UpdateException("Não foi possível atualizar o post de id " + p.getId() + "!");
    }
  }

  public void delete(Post p) throws DeleteException {
    try {
      delete.setInt(1, p.getId());
      delete.executeQuery();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir o post de id " + p.getId() + "!");
    }
  }
  
  public List<Comentario> selectComentarios(int idPost) throws SelectException {
    // id SERIAL, id_post INTEGER, id_autor INTEGER, texto VARCHAR(256)
    try {
      List<Comentario> comentarios = new ArrayList<>();
      selectComentarios.setInt(1, idPost);
      ResultSet result = selectComentarios.executeQuery();

      while (result.next()) {
        int idComentario = result.getInt(1);
        int id = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);

        Post post = postDAO.select(id);
        Usuario autor = usuarioDAO.select(idAutor);

        Comentario comentario = new Comentario(idComentario, post, autor, texto);

        comentarios.add(comentario);
      }

      return comentarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar comentários do post " + idPost + "!");
    }
  }

  public List<Usuario> selectCurtidas(int idPost) throws SelectException {
    // id_usuario INTEGER, id_post INTEGER,
    try {
      List<Usuario> usuarios = new ArrayList<>();
      selectCurtidas.setInt(1, idPost);
      ResultSet result = selectCurtidas.executeQuery();
      while (result.next()) {
        int idUsuario = result.getInt(1);
        Usuario usuario = usuarioDAO.select(idUsuario);
        usuarios.add(usuario);
      }
      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar as curtidas do post " + idPost + "!");
    }
  }

  public void insertCurtida(int idPost, int idUsuario) throws InsertException {
    try {
      insertCurtida.setInt(1, idPost);
      insertCurtida.setInt(2, idUsuario);
      insertCurtida.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException(
          "Não foi possível inserir a curtida do usuário " + idUsuario + " no post " + idPost + "!");
    }
  }

  public void deleteCurtida(int idPost, int idUsuario) throws DeleteException {
    try {
      deleteCurtida.setInt(1, idPost);
      deleteCurtida.setInt(2, idUsuario);
      deleteCurtida.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException(
          "Não foi possível excluir a curtida do usuário " + idUsuario + " no post " + idPost + "!"); 
    }
  }
}
