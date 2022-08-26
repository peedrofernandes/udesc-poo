package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
  private static String senha;
  private static String usuario;
  private static Connection conexao;

  private Conexao() {};

  public static Connection getConexao() {
    if (conexao != null)
      return conexao;
    
    senha = "postgres";
    usuario = "postgres";

    try {
      String url = "jdbc:postgresql://localhost:5432/rede_social";
      Class.forName("org.postgresql.Driver");
      conexao = DriverManager.getConnection(url, usuario, senha);
      System.out.println("Conexão com o banco de dados efetuada com sucesso.");
    } catch (ClassNotFoundException exc) {
      System.err.println("A classe do driver JDBC não foi encontrada!\nDetalhes: " + exc.getMessage());
    } catch (SQLException exc) {
      System.err.println("Houve um erro na conexão com o banco de dados!\nDetalhes: " + exc.getMessage());
    }

    return conexao;
  }

  public static void setSenha(String s) {
    senha = s;
  }

  public static void setUsuario(String u) {
    usuario = u;
  }
}