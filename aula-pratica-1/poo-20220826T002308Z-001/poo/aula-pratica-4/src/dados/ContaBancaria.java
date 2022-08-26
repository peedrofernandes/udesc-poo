package dados;

public class ContaBancaria {
  private String cpf;
  private float saldo;

  public ContaBancaria(String cpf, float saldo) {
    this.cpf = cpf;
    this.saldo = saldo;
  }

  public float sacar(float valor) {
    float saque;

    if (valor > saldo) {
      saque = this.saldo;
      this.saldo = 0;
    } else {
      saque = valor;
      this.saldo -= valor;
    }

    return saque;
  }

  public String gerarExtrato() {
    String str = "Saldo atual: R$" + this.saldo + ".";

    return str;
  }

  public String getCpf() {
    return this.cpf;
  }

  public float getSaldo() {
    return this.saldo;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }
}