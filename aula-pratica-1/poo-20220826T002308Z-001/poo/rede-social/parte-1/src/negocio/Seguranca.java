package negocio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import dados.Usuario;

public class Seguranca {
  public static boolean validarEmailCurto(String email) {
    String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(emailRegex);

    if (pattern.matcher(email).matches())
      return true;
    else
      return false;
  }

  public static boolean validarEmailExistente(String email, List<Usuario> usuariosCadastrados) {
    boolean status = true;

    for (Usuario u : usuariosCadastrados) {
      if (u.getEmail() == email) {
        status = false;
        break;
      }
    }

    return status;
  }

  public static boolean validarNomeCompleto(String nome) {
    if (nome.length() < 7)
      return false;
    else 
      return true;
  }

  public static boolean validarApelido(String nome, List<Usuario> usuariosCadastrados) {
    boolean value = true;

    for (Usuario u : usuariosCadastrados) {
      if (u.getApelido() == nome) {
        value = false;
        break;
      }
    }

    return value;
  }

  public static boolean validarSenha(String senha) {
    if (senha.length() < 8)
      return false;
    else
      return true;

  }

  public static String obterHash(String senha) {
    // Funções hash disponíveis: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384, SHA-512
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-1");
      byte[] messageDigest = md.digest(senha.getBytes());
      BigInteger bi = new BigInteger(1, messageDigest);
      return bi.toString(16);
    } catch (NoSuchAlgorithmException exception) {
      System.out.println("Exception - There was an error with the hash algorithm!" + exception);
      return "";
    }
  }
}
