package apresentacao;

import negocio.Sistema;

public class Main {
  Sistema sistema = new Sistema();

  public static void main(String[] args) {
    System.out.println("Bem-vindo(a) ao sistema bancário!");
    
    System.out.println("Selecione uma opção: ");
    System.out.println("[1] Cadastrar uma nova conta bancária ");
    System.out.println("[2] Realizar saque ");
    System.out.println("[3] Realizar depósito");
    System.out.println("[4] Realizar depósito em conta CNPJ");
    System.out.println("[5] Listar todas as contas");
    System.out.println("[6] Listar todas as contas-corrente");
    System.out.println("[7] Listar todas as contas-salário");
    System.out.println("[8] Obter extrato ");
    
  }
}