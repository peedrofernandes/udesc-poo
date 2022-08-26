package apresentacao;

import negocio.*;
import dados.*;

import java.util.Scanner;

public class Principal {
  private static Scanner input = new Scanner(System.in);
  private static ReservaPassagem reservaPassagem;

  public static void main(String[] args) {
    reservaPassagem = new ReservaPassagem(100, 100, 100);

    Scanner input = new Scanner(System.in);

    programa();

    input.close();
  }

  private static void programa() {
    int op;

    do {

      Utils.limpaTela();

      System.out
          .println("Bem-vindo(a) ao sistema de reserva de passagem! Selecione uma opção abaixo para prosseguir: ");
      System.out.println("[1] Fazer nova reserva");
      System.out.println("[2] Cadastrar um novo cliente");
      System.out.println("[3] Cadastrar uma nova cidade");
      System.out.println("[4] Mostrar todas as reservas");
      System.out.println("[5] Mostrar todos os clientes");
      System.out.println("[6] Mostrar todas as cidades");
      
      System.out.println("[0] Sair do programa");

      System.out.print("Sua opção: ");
      op = Utils.inputInt(input);

      switch (op) {
        case 1: // Fazer nova reserva
          fazerReserva();
          break;
        case 2: // Cadastrar um novo cliente
          cadastrarCliente();
          break;
        case 3: // Cadastrar uma nova cidade
          cadastrarCidade();
          break;
        case 4: // Mostrar todas as reservas
          mostrarReservas();
          break;
        case 5: // Mostrar todos os clientes
          mostrarClientes();
          break;
        case 6: // Mostrar todas as cidades
          mostrarCidades();
          break;
        case 0: // Sair do programa
          Utils.limpaTela();
          System.out.println("Encerrando, até a próxima!");
          break;
        default:
          System.out.println("Opção inválida, tente novamente!");
          Utils.pausaSistema(input);
          programa();
          break;
      }
    } while (op != 0);
  }

  public static void fazerReserva() {
    Cliente cliente;
    Reserva ida, volta;
    int opVolta;

    Utils.limpaTela();

    // VERIFICAÇÃO DE EXISTÊNCIA DO CLIENTE

    System.out.print("Digite o número do CPF do cliente para o qual você deseja fazer uma reserva: ");
    String CPF = input.nextLine();

    int i = reservaPassagem.indiceCliente(CPF);

    if (i == -1) {
      System.out.println("Não há um cliente cadastrado com este CPF!");
      Utils.pausaSistema(input);
      return;
    }

    cliente = reservaPassagem.getListaClientes()[i];

    // RESERVAS DE IDA E VOLTA

    ida = Utils.inputReservaIda(input);

    if (reservaPassagem.indiceCidade(ida.getOrigem()) == -1) {

      reservaPassagem.cadastrarCidade(ida.getOrigem());

      System.out.println(
        "A cidade de origem "
        + ida.getOrigem().getNome()
        + ", de "
        + ida.getOrigem().getEstado()
        + " foi cadastrada no sistema."
      );
    }
    
    if (reservaPassagem.indiceCidade(ida.getDestino()) == -1) {

      reservaPassagem.cadastrarCidade(ida.getDestino());

      System.out.println(
        "A cidade de destino "
        + ida.getDestino().getNome()
        + ", de "
        + ida.getDestino().getEstado()
        + " foi cadastrada no sistema."
      );
    }
    

    // Input da informação de possuir ou não passagem de volta
    do {
      System.out.print("Possui passagem de volta? [0 - Não | 1 - Sim] ");
      opVolta = Utils.inputInt(input);

      if (opVolta > 1 || opVolta < 0) {
        System.out.println("Opção inválida, tente novamente!");
      }

    } while (opVolta > 1 || opVolta < 0);

    reservaPassagem.reservarIda(cliente, ida);

    if (opVolta == 1) {
      volta = Utils.inputReservaVolta(ida, input);
      ida.setVolta(volta);
      reservaPassagem.reservarVolta(cliente, ida, volta);
    }

    Utils.limpaTela();
    System.out.println("Passagem registrada com sucesso!");
    Utils.pausaSistema(input);

  }

  public static void cadastrarCliente() {
    Cliente cliente;

    Utils.limpaTela();

    do {
      cliente = Utils.inputCliente(input);

      if (reservaPassagem.indiceCliente(cliente.getCpf()) != -1) {
        System.out.println("Cliente com o mesmo CPF já cadastrado! Tente novamente.");
      }

    } while (reservaPassagem.indiceCliente(cliente.getCpf()) != -1);

    reservaPassagem.cadastrarCliente(cliente);

    Utils.limpaTela();
    System.out.println("Cliente cadastrado com sucesso!");
    Utils.pausaSistema(input);
  }

  public static void cadastrarCidade() {
    Cidade cidade;

    do {

      cidade = Utils.inputCidade(input);

      if (reservaPassagem.indiceCidade(cidade) != -1) {
        System.out.println("Essa mesma cidade já foi cadastrada!");
      }

    } while (reservaPassagem.indiceCidade(cidade) != -1);

    reservaPassagem.cadastrarCidade(cidade);

    Utils.limpaTela();
    System.out.println("Cidade cadastrada com sucesso!");
    Utils.pausaSistema(input);
  }

  public static void mostrarReservas() {
    Utils.limpaTela();
    System.out.println(reservaPassagem.mostrarReservas());
    Utils.pausaSistema(input);
  }

  public static void mostrarClientes() {
    Utils.limpaTela();
    System.out.println(reservaPassagem.mostrarClientes());
    Utils.pausaSistema(input);
  }

  public static void mostrarCidades() {
    Utils.limpaTela();
    System.out.println(reservaPassagem.mostrarCidades());
    Utils.pausaSistema(input);
  }

}
