package apresentacao;

import java.util.Scanner;
import dados.*;

public class Utils {
  public final static void limpaTela() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        System.out.print("\033[H\033[J");
    } catch (Exception e) {
      System.out.println("Erro!");
      System.out.println("Nome da exceção: " + e + ".");
    }
  }

  public final static void pausaSistema(Scanner input) {
    System.out.println("Pressione enter para continuar...");
    input.nextLine();
  }
  
  public final static int inputInt(Scanner input) {
    int i = input.nextInt();
    input.nextLine();
    return i;
  }

  public final static String inputString(Scanner input) {
    String str = input.nextLine();
    return str;
  }

  public final static Reserva inputReservaIda(Scanner input) {
    // Dados da reserva de ida: 
    // -- 
    // String dataVoo,
    // String horaVoo, 
    // String classeVoo, 
    // float preco, 
    // int poltrona, 
    // Cidade origem, 
    // Cidade destino, 
    // boolean possuiVolta

    String dataVoo, horaVoo, nomeCidadeOrigem, nomeCidadeDestino, nomeEstadoOrigem, nomeEstadoDestino, classeVoo;
    float preco;
    int poltrona, opClasse;
    Cidade origem, destino;
    Reserva reserva;

    // Input da data do voo
    System.out.print("Digite a data do voo: ");
    dataVoo = input.nextLine();

    // Input da hora do voo
    System.out.print("Digite a hora do voo: ");
    horaVoo = input.nextLine();

    // Input do valor da passagem
    System.out.print("Digite o valor da passagem: R$");
    preco = input.nextFloat();

    // Input da classe do voo
    do {
      System.out.println("Selecione a classe do voo: ");
      System.out.println("[1] Classe Econômica");
      System.out.println("[2] Classe Econômica Premium");
      System.out.println("[3] Classe Executiva");
      System.out.println("[4] Primeira Classe ");
      System.out.print("Sua opção (1 - 4): ");
      opClasse = inputInt(input);

      if (opClasse > 4 || opClasse < 1) {
        System.out.println("Opção inválida de classe, tente novamente!");
      }

    } while (opClasse > 4 || opClasse < 1);

    switch (opClasse) {
      case 1:
        classeVoo = "Classe Econômica";
        break;
      case 2:
        classeVoo = "Classe Econômica Premium";
        break;
      case 3:
        classeVoo = "Classe Executiva";
        break;
      case 4:
        classeVoo = "Primeira Classe";
        break;
      default:
        classeVoo = "Classe não identificada";
        break;
    }

    // Input da poltrona do voo
    do {
      System.out.print("Selecione a poltrona do voo: (1 - 50): ");
      poltrona = inputInt(input);

      if (poltrona > 50 || poltrona < 1) {
        System.out.println("Opção inválida de poltrona, tente novamente!");
      }

    } while (poltrona > 50 || poltrona < 1);

    // Input da cidade de origem
    System.out.print("Digite o nome da cidade de origem: ");
    nomeCidadeOrigem = input.nextLine();
    System.out.print("Digite o nome do Estado da cidade de origem: ");
    nomeEstadoOrigem = input.nextLine();

    // Input da cidade de destino
    System.out.print("Digite o nome da cidade de destino: ");
    nomeCidadeDestino = input.nextLine();
    System.out.print("Digite o nome do Estado de destino: ");
    nomeEstadoDestino = input.nextLine();

    origem = new Cidade(nomeCidadeOrigem, nomeEstadoOrigem);
    destino = new Cidade(nomeCidadeDestino, nomeEstadoDestino);

    reserva = new Reserva(dataVoo, horaVoo, classeVoo, preco, poltrona, origem, destino);

    return reserva;
  }

  public final static Reserva inputReservaVolta(Reserva ida, Scanner input) {
    // Dados da reserva de volta: 
    // -- 
    // String dataVoo, OK 
    // String horaVoo, OK
    // String classeVoo = a mesma da ida, OK
    // float preco = o mesmo da ida, OK
    // int poltrona, OK 
    // Cidade origem = a cidade de destino da ida, 
    // Cidade destino = a cidade de origem da ida 

    String dataVoo, horaVoo, classeVoo;
    int poltrona;
    float preco;
    Cidade origem, destino;
    Reserva volta;

    // Input da data do voo
    System.out.print("Digite a data do voo: ");
    dataVoo = input.nextLine();

    // Input da hora do voo
    System.out.print("Digite a hora do voo: ");
    horaVoo = input.nextLine();

    classeVoo = ida.getClasseVoo();

    preco = ida.getPreco();

    // Input da poltrona do voo
    do {
      System.out.print("Selecione a poltrona do voo: (1 - 50)");
      poltrona = inputInt(input);

      if (poltrona > 50 || poltrona < 1) {
        System.out.println("Opção inválida de poltrona, tente novamente!");
      }

    } while (poltrona > 50 || poltrona < 1);

    origem = ida.getDestino();
    destino = ida.getOrigem();

    volta = new Reserva(dataVoo, horaVoo, classeVoo, preco, poltrona, origem, destino);

    return volta;
  }

  public final static Cliente inputCliente(Scanner input) {
    Cliente cliente;
    String cpf, nome, endereco, telefone;

    System.out.print("CPF: ");
    cpf = input.nextLine();
    System.out.print("Nome: ");
    nome = input.nextLine();
    System.out.print("Endereço: ");
    endereco = input.nextLine();
    System.out.print("Telefone: ");
    telefone = input.nextLine();

    cliente = new Cliente(cpf, nome, endereco, telefone, 10);

    return cliente;
  }

  public final static Cidade inputCidade(Scanner input) {
    Cidade cidade;
    String nome, estado;

    System.out.print("Nome da cidade: ");
    nome = input.nextLine();
    System.out.print("Estado: ");
    estado = input.nextLine();

    cidade = new Cidade(nome, estado);

    return cidade;
  }

}
