package exceptions;

public class NonExistentRemovalException extends Exception {
  public NonExistentRemovalException(String message) {
    super(message);
  }
}
