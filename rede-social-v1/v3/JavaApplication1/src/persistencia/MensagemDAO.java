package persistencia;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Conversa;
import dados.Mensagem;
import dados.Usuario;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.UpdateException;

// CREATE TABLE mensagem (
//  id SERIAL,
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

// private int id;
// private Conversa conversa;
// private Usuario autor;
// private String texto;
// private Date dataEnvio;
// private boolean visualizado;
// private boolean recebido;

public class MensagemDAO extends DAO <Mensagem> {
  private static MensagemDAO instance = null;
  private static UsuarioDAO usuarioDAO = null;
  private static ConversaDAO conversaDAO = null;

  private MensagemDAO() throws SQLException {
    conexao = Conexao.getConexao();
    instance = this;
      
    selectNextId = conexao.prepareStatement("SELECT nextval('mensagem_id_seq')");
    insert = conexao.prepareStatement("INSERT INTO mensagem (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido) VALUES (?,?,?,?,?,?,?)");
    select = conexao.prepareStatement("SELECT * FROM mensagem WHERE id = ?");
    update = conexao.prepareStatement("UPDATE mensagem SET id_conversa = ?, id_autor = ?, texto = ?, data_envio = ?, visualizado = ?, recebido = ? WHERE id = ?");
    delete = conexao.prepareStatement("DELETE FROM mensagem WHERE id = ?");

    conversaDAO = ConversaDAO.getInstance();
    usuarioDAO = UsuarioDAO.getInstance();
  }

  public MensagemDAO getInstance() throws SQLException {
    // (id, id_conversa, id_remetente, id_destinatario, texto, data_envio, visualizado, recebido)
    if (instance != null)
      return instance;

    instance = new MensagemDAO();

    return instance;
  }

  protected int selectNextId() throws SelectException {
    try {
      ResultSet result = selectNextId.executeQuery();

      if (result.next())
        return result.getInt(1);
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível obter o próximo ID da tabela de mensagens!");
    }

    return 0;
  }
  
  public void insert(Mensagem m) throws InsertException, SelectException {
    // (id, id_conversa, id_remetente, id_destinatario, texto, data_envio, visualizado, recebido)
    try {
      int idMensagem = selectNextId();
      insert.setInt(1, idMensagem);
      insert.setInt(2, m.getConversa().getId());
      insert.setInt(3, m.getAutor().getId());
      insert.setString(4, m.getTexto());
      insert.setDate(5, m.getDataEnvio());
      insert.setBoolean(6, m.isVisualizado());
      insert.setBoolean(7, m.isRecebido());

      insert.executeUpdate();
    } catch (SQLException exc) {
      throw new InsertException("Não foi possível inserir uma nova mensagem na tabela de mensagens!");
    }
  }

  public Mensagem select(int idMensagem) throws SelectException {
    // (id, id_conversa, id_remetente, id_destinatario, texto, data_envio, visualizado, recebido)
    try {
      select.setInt(1, idMensagem);
      ResultSet result = select.executeQuery();

      if (result.next()) {
        int id = result.getInt(1);
        int idConversa = result.getInt(2);
        int idAutor = result.getInt(3);
        String texto = result.getString(4);
        Date dataEnvio = result.getDate(5);
        boolean visualizado = result.getBoolean(6);
        boolean recebido = result.getBoolean(7);

        Conversa conversa = conversaDAO.select(idConversa);
        Usuario autor = usuarioDAO.select(idAutor);

        return new Mensagem(id, conversa, autor, texto, dataEnvio, visualizado, recebido);
      }
    } catch (SQLException exc) {
      throw new SelectException("Não foi possível obter um registro da tabela de mensagens!");
    }

    return null;
  }

  public void update(Mensagem m) throws UpdateException {
    // (id, id_conversa, id_autor, texto, data_envio, visualizado, recebido)
    try {
      update.setInt(1, m.getConversa().getId());
      update.setInt(2, m.getAutor().getId());
      update.setString(3, m.getTexto());
      update.setDate(4, m.getDataEnvio());
      update.setBoolean(5, m.isVisualizado());
      update.setBoolean(6, m.isRecebido());
      update.setInt(7, m.getId());

      update.executeUpdate();
    } catch (SQLException exc) {
      throw new UpdateException("Não foi possível atualizar um registro na tabela de mensagens!");
    }
  }

  public void delete(Mensagem m) throws DeleteException {
    try {
      delete.setInt(1, m.getId());
      delete.executeUpdate();
    } catch (SQLException exc) {
      throw new DeleteException("Não foi possível excluir um registro da tabela de mensagens!");
    }
  }
}
