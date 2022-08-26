package dados;

public class ContaSalario extends ContaBancaria {
  private String cnpjEmpresa;

  public ContaSalario(String cpf, float saldo, String cnpjEmpresa) {
    super(cpf, saldo);
    this.cnpjEmpresa = cnpjEmpresa;
  }

  public boolean depositar(float valor, String cnpj) {
    if (cnpj != this.cnpjEmpresa) {
      return false;
    }

    this.setSaldo(this.getSaldo() + valor);

    return true;
  }
}