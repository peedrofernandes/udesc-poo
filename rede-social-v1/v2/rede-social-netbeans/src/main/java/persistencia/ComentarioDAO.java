package persistencia;

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

// CREATE TABLE comentario (
// 	id SERIAL,
// 	id_post INTEGER,
// 	id_autor INTEGER,
// 	texto VARCHAR(256),
// 	PRIMARY KEY (id),
// 	FOREIGN KEY (id_post) REFERENCES post,
// 	FOREIGN KEY (id_autor) REFERENCES usuario
// );

public class ComentarioDAO extends DAO<Comentario> {
  private static ComentarioDAO instance = null;

  private static PostDAO postsDAO = null;
  private static UsuarioDAO usuarioDAO = null;

  private PreparedStatement selectCurtidas;
  private PreparedStatement insertCurtida;
  private PreparedStatement deleteCurtida;

  public ComentarioDAO() throws SQLException {
    super();
    
    selectNextId = conexao.prepareStatement("SELECT nextval('comentarios_id_seq')");
    insert = conexao.prepareStatement("INSERT INTO comentario (id, id_post, id_autor, texto) VALUES (?,?,?,?)");
    select = conexao.prepareStatement("SELECT * FROM comentario WHERE id = ?");
    update = conexao.prepareStatement("UPDATE comentario SET id_post = ?, id_autor = ?, texto = ? WHERE id = ?");
    delete = conexao.prepareStatement("DELETE FROM comentario WHERE id = ?");
    selectCurtidas = conexao.prepareStatement("SELECT * FROM comentario_favorito WHERE id_comentario = ?");
    insertCurtida = conexao.prepareStatement("INSERT INTO comentario_favorito (id_comentario, id_usuario) VALUES (?,?)");
    deleteCurtida = conexao.prepareStatement("DELETE FROM comentario_favorito WHERE (id_comentario, id_usuario) = (?,?)");

    postsDAO = PostDAO.getInstance();
    usuarioDAO = UsuarioDAO.getInstance();
  }

  public static ComentarioDAO getInstance() throws SQLException {
    if (instance != null)
      return instance;

    instance = new ComentarioDAO();

    return instance;
  }

  protected int selectNextId() throws SelectException {
    try {
      ResultSet result = selectNextId.executeQuery();
      if (result.next())
        return result.getInt(1);
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível obter o próximo ID da tabela de comentários!");
    }

    return 0;
  }

  public void insert(Comentario c) throws InsertException, SelectException {
    // (id, id_post, id_autor, texto)
    try {
      int idConversa = selectNextId();
      insert.setInt(1, idConversa);
      insert.setInt(2, c.getPost().getId());
      insert.setInt(3, c.getAutor().getId());
      insert.setString(4, c.getTexto());
      insert.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir um novo registro na tabela de comentários!");
    }
  }

  public Comentario select(int idComentario) throws SelectException {
  // id; post; autor; texto; usuariosQueFavoritaram;
    try {
      select.setInt(1, idComentario);
      ResultSet result = select.executeQuery();
      if (result.next()) {
        int id = result.getInt(1);
        int idPost = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);
        List<Usuario> usuariosQueFavoritaram = selectCurtidas(idComentario);

        Post post = postsDAO.select(idPost);
        Usuario autor = usuarioDAO.select(idAutor);

        return new Comentario(id, post, autor, texto, usuariosQueFavoritaram);
      }
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar um registro na tabela de comentários!");
    }

    return null;
  }

  public void update(Comentario c) throws UpdateException {
    // (id, id_post, id_autor, texto, qtd_favoritos)
    try {
      update.setInt(1, c.getPost().getId());
      update.setInt(2, c.getAutor().getId());
      update.setString(3, c.getTexto());
      update.setInt(4, c.getId());
      update.executeUpdate();
    } catch (SQLException exc) {
      throw new UpdateException("Não foi possível atualizar um registro da tabela de comentários!");
    }
  }

  public void delete(Comentario c) throws DeleteException {
    try {
      delete.setInt(1, c.getId());
      delete.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir um registro da tabela de comentários!");
    }
  }

  public List<Usuario> selectCurtidas(int idComentario) throws SelectException {
    // id_usuario INTEGER, id_comentario INTEGER
    try {
      List<Usuario> usuarios = new ArrayList<>();
      selectCurtidas.setInt(1, idComentario);
      ResultSet result = selectCurtidas.executeQuery();

      while (result.next()) {
        int idUsuario = result.getInt(1);
        Usuario u = usuarioDAO.select(idUsuario);
        usuarios.add(u);
      }

      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar as curtidas do comentário " + idComentario + "!");
    }
  }

  public void insertCurtida(int idComentario, int idUsuario) throws InsertException {
    try {
      insertCurtida.setInt(1, idComentario);
      insertCurtida.setInt(2, idUsuario);
      insertCurtida.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir uma nova curtida no comentário " + idComentario + "!");
    }
  }

  public void deleteCurtida(int idComentario, int idAutor) throws DeleteException {
    try {
      deleteCurtida.setInt(1, idComentario);
      deleteCurtida.setInt(2, idAutor);
      deleteCurtida.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir a curtida do usuário " + idAutor + " do comentário " + idComentario + "!");
    }
  }
}

