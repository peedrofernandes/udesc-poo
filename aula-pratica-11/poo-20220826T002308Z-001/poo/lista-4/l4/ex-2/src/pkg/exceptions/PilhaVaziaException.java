package pkg.exceptions;

import pkg.Pilha;

public class PilhaVaziaException extends Exception {
  public PilhaVaziaException() {
  }

  public PilhaVaziaException(String message) {
    super(message);
  }
}
