package dados;

public class ContaCorrente extends ContaBancaria {
  public ContaCorrente(String cpf, float saldo) {
    super(cpf, saldo);
  }

  public void depositar(float valor) {
    this.setSaldo(this.getSaldo() + valor);
  }
}