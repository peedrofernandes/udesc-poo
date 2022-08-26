package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.Pessoa;
import exceptions.InsertException;
import exceptions.SelectException;

public class PessoaDAO {
  private static PessoaDAO instance = null;
  private static EnderecoDAO enderecoDAO = null;

  private PreparedStatement selectNewId;
  private PreparedStatement insert;
  private PreparedStatement delete;
  private PreparedStatement selectAll;
  private PreparedStatement update;
  
  private PessoaDAO() throws SQLException, ClassNotFoundException, SelectException {
    Connection conexao = Conexao.getConexao();

    selectNewId = conexao.prepareStatement("SELECT NEXTVAL('id')");
    insert = conexao.prepareStatement("INSERT INTO pessoa VALUES (?,?,?,?)");
    delete = conexao.prepareStatement("DELETE FROM pessoa WHERE id = ?");
    selectAll = conexao.prepareStatement("SELECT * FROM pessoa");
    update = conexao.prepareStatement("UPDATE pessoa SET nome = ?, cpf = ?, telefone = ?,WHERE id = ?");

    enderecoDAO = EnderecoDAO.getInstance();
  }

  public int selectNewId() throws SelectException {
    try {
      ResultSet rs = selectNewId.executeQuery();
      if (rs.next())
        return rs.getInt(1);
    } catch (SQLException exc) {
      throw new SelectException("Erro ao buscar o novo ID da tabela de pessoas!");
    }

    return 0;
  }

  public void insert(Pessoa pessoa) throws InsertException, SelectException {
    try {
      pessoa.setId(selectNewId());

      insert.setInt(1, pessoa.getId());
      insert.setString(2, pessoa.getNome());
      insert.setInt(3, pessoa.getCpf());
      insert.setInt(4, pessoa.getTelefone());
      insert.executeUpdate();

      pessoa.getEndereco().setIdPessoa(pessoa.getId());
      
      enderecoDAO.insert(pessoa.getEndereco());
    } catch (SQLException exc) {
      throw new InsertException("Erro ao inserir uma nova pessoa!");
    }
  }

  public static PessoaDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
    if (instance == null)
      instance = new PessoaDAO();

    return instance;
  }
}
