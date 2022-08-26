package negocio;

import java.util.ArrayList;
import java.util.List;

import dados.ContaBancaria;
import dados.ContaCorrente;
import dados.ContaSalario;

public class Sistema {
  private int quantidade;
  private List<ContaBancaria> contasBancarias = new ArrayList<>();

  public Sistema() {
    this.quantidade = 0;
  }

  public void cadastrarConta(ContaBancaria conta) {
    this.contasBancarias.add(conta);
    this.quantidade++;
  }

  public void realizarSaque(ContaBancaria conta, float valor) {
    conta.sacar(valor);
  }

  public void realizarDeposito(ContaCorrente conta, float valor) {
    conta.depositar(valor);
  }

  public boolean realizarDeposito(ContaSalario conta, float valor, String cnpj) {
    return conta.depositar(valor, cnpj);
  }

  public List<ContaBancaria> getContas() {
    return this.contasBancarias;
  }

  public List<ContaCorrente> getContasCorrentes() {
    List<ContaCorrente> ctts = new ArrayList<ContaCorrente>();

    for (ContaBancaria conta : this.contasBancarias) {
      if (conta instanceof ContaCorrente)
        ctts.add((ContaCorrente) conta);
    }

    return ctts;
  }

  public List<ContaSalario> getContasSalario() {
    List<ContaSalario> ctts = new ArrayList<ContaSalario>();

    for (ContaBancaria conta : this.contasBancarias) {
      if (conta instanceof ContaSalario) {
        ctts.add((ContaSalario) conta);
      }
    }

    return ctts;
  }

  public String obterExtrato(ContaBancaria conta) {
    return conta.gerarExtrato();
  }

}