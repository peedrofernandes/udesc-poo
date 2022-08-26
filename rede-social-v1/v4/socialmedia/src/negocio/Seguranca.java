package negocio;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

import dados.Usuario;
import exceptions.ExistingAliasException;
import exceptions.ExistingEmailException;
import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.UnmatchedPasswordsException;
import exceptions.WrongPasswordException;

public class Seguranca {
  public static void validarEmailCurto(String email) throws InvalidEmailException {
    String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    Pattern pattern = Pattern.compile(emailRegex);

    if (!pattern.matcher(email).matches())
      throw new InvalidEmailException("E-mail inválido!");
  }

  public static void validarEmailExistente(String email, List<Usuario> usuariosCadastrados) throws ExistingEmailException {
    for (Usuario u : usuariosCadastrados) {
      if (u.getEmail().equals(email))
        throw new ExistingEmailException("O email usado já está cadastrado!");
    }
  }

  public static void validarNomeCompleto(String nome) throws InvalidNameException {
    if (nome.length() < 7)
      throw new InvalidNameException("Nome inválido!");
  }

  public static void validarApelido(String nome, List<Usuario> usuariosCadastrados) throws ExistingAliasException {
    for (Usuario u : usuariosCadastrados) {
      if (u.getApelido().equals(nome)) {
        throw new ExistingAliasException("O apelido inserido já existe!");
      }
    }
  }

  public static void validarSenha(String senha) throws InvalidPasswordException {
    if (senha.length() < 8)
      throw new InvalidPasswordException("Senha inválida!");
  }

  public static void validarSenhasIguais(String senha, String confirmacaoSenha) throws UnmatchedPasswordsException {
    if (!senha.equals(confirmacaoSenha))
      throw new UnmatchedPasswordsException("Senhas não coincidem!");
  }

  public static void validarSenhaCorreta(String senha, String hashSenha) throws WrongPasswordException {
    if (!obterHash(senha).equals(hashSenha))
      throw new WrongPasswordException("Senha incorreta!");
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
