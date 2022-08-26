package exceptions;

public class UnmatchedPasswordsException extends Exception {
  public UnmatchedPasswordsException(String message) {
    super(message);
  }
}
