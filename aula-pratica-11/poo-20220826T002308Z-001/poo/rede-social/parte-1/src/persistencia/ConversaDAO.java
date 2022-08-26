package persistencia;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dados.Conversa;
import dados.Mensagem;
import dados.Usuario;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

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

  // // Atributos estáticos
  // private int id;
  // private Usuario usuario1;
  // private Usuario usuario2;

  // // Atributos de relacionamento
  // private List<Mensagem> mensagens;

public class ConversaDAO extends DAO <Conversa> {
  private static ConversaDAO instance = null;

  private static UsuarioDAO usuarioDAO = null;

  private PreparedStatement selectMensagens = null;
  private PreparedStatement selectUsuarios = null;

  protected ConversaDAO() throws SQLException {
    selectNextId = conexao.prepareStatement("SELECT nextval('conversas_id_seq')");
    insert = conexao.prepareStatement("INSERT INTO conversa (id, id_usuario_1, id_usuario_2) VALUES (?,?,?)");
    select = conexao.prepareStatement("SELECT * FROM conversa WHERE id = ?");
    update = conexao.prepareStatement("UPDATE conversa SET id_usuario_1 = ?, id_usuario_2 = ? WHERE id = ?");
    delete = conexao.prepareStatement("DELETE FROM conversa WHERE id = ?");

    selectMensagens = conexao.prepareStatement("SELECT * FROM mensagem WHERE id_conversa = ?");
    selectUsuarios = conexao.prepareStatement("SELECT (id_usuario_1, id_usuario_2) FROM conversa WHERE id = ?");

    usuarioDAO = UsuarioDAO.getInstance();
  }

  public static ConversaDAO getInstance() throws SQLException {
    if (instance != null)
      return instance;

    instance = new ConversaDAO();

    return instance;
  }
  
  protected int selectNextId() throws SelectException {
    try {
      ResultSet result = selectNextId.executeQuery();

      if (result.next())
        return result.getInt(1);
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível obter o próximo ID da tabela de conversas!");
    }

    return 0;
  }

  public void insert(Conversa c) throws InsertException, SelectException {
    // (id, id_usuario_1, id_usuario_2)
    try {
      int idConversa = selectNextId();
      insert.setInt(1, idConversa);
      insert.setInt(2, c.getUsuario1().getId());
      insert.setInt(3, c.getUsuario2().getId());
      insert.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir uma conversa na tabela de conversas!");
    }
  }

  public Conversa select(int idConversa) throws SelectException {
    // (id, id_usuario_1, id_usuario_2, qtd_mensagens)
    try {
      select.setInt(1, idConversa);
      ResultSet result = select.executeQuery();

      if (result.next()) {
        int id = result.getInt(1);
        int idUsuario1 = result.getInt(2);
        int idUsuario2 = result.getInt(3);

        Usuario u1 = usuarioDAO.select(idUsuario1);
        Usuario u2 = usuarioDAO.select(idUsuario2);

        List<Mensagem> mensagens = selectMensagens(idConversa);

        return new Conversa(id, u1, u2, mensagens);
      }
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar uma conversa da tabela de conversas!");
    }

    return null;
  }

  public void update(Conversa c) throws UpdateException {
    // (id, id_usuario_1, id_usuario_2)
    try {
      update.setInt(1, c.getUsuario1().getId());
      update.setInt(2, c.getUsuario2().getId());
      update.setInt(3, c.getId());
      update.executeUpdate();
    } catch (SQLException exc) {
      throw new UpdateException("Não foi possível atualizar um registro na tabela de conversas!");
    }
  }

  public void delete(Conversa c) throws DeleteException {
    try {
      delete.setInt(1, c.getId());
      delete.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir um registro da tabela de conversas!");
    }
  }

  public List<Mensagem> selectMensagens(int idConversa) throws SelectException {
    // (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido)
    try {
      List<Mensagem> mensagens = new ArrayList<>();

      selectMensagens.setInt(1, idConversa);
      ResultSet result = selectMensagens.executeQuery();

      while (result.next()) {
        int id = result.getInt(1);
        int idConv = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);
        Date dataEnvio = result.getDate(5);
        Boolean visualizado = result.getBoolean(6);
        Boolean recebido = result.getBoolean(7);

        Conversa conversa = select(idConv);
        Usuario autor = usuarioDAO.select(idAutor);

        Mensagem m = new Mensagem(id, conversa, autor, texto, dataEnvio, visualizado, recebido);
        mensagens.add(m);
      }

      return mensagens;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível selecionar as mensages da conversa " + idConversa + "!");
    }
  }

  public List<Usuario> selectUsuarios(int idConversa) throws SelectException {
    try {
      List<Usuario> usuarios = new ArrayList<>();
      selectUsuarios.setInt(1, idConversa);
      ResultSet result = selectUsuarios.executeQuery();
      int idUsuario1 = result.getInt(1);
      int idUsuario2 = result.getInt(2);

      Usuario u1 = usuarioDAO.select(idUsuario1);
      Usuario u2 = usuarioDAO.select(idUsuario2);

      usuarios.add(u1);
      usuarios.add(u2);

      return usuarios;
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível buscar a tupla de usuários da conversa " + idConversa + "!");
    }
  }
}
