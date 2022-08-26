package exceptions;

public class ExistingAliasException extends Exception {
  public ExistingAliasException(String message) {
    super(message);
  }
}
