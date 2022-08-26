package negocio;

import dados.*;

public class ReservaPassagem {
  private Cidade[] listaDeCidades;
  private Cliente[] listaDeClientes;
  private Reserva[] listaDeReservas;

  private int maxCidades;
  private int maxClientes;
  private int maxReservas;

  private int qtdCidades;
  private int qtdClientes;
  private int qtdReservas;

  public ReservaPassagem(int maxCidades, int maxClientes, int maxReservas) {
    this.maxCidades = maxCidades;
    this.maxClientes = maxClientes;
    this.maxReservas = maxReservas;

    listaDeCidades = new Cidade[maxCidades];
    listaDeClientes = new Cliente[maxClientes];
    listaDeReservas = new Reserva[maxReservas];

    this.qtdCidades = 0;
    this.qtdClientes = 0;
    this.qtdReservas = 0;
  } // Método construtor

  public int indiceCliente(String CPFCliente) {
    for (int i = 0; i < qtdClientes; i++) {
      if (this.listaDeClientes[i].getCpf().equals(CPFCliente)) {
        return i;
      }
    }

    return -1;
  } // Indice do cliente ? Indice do cliente : -1

  public int indiceCidade(Cidade cidade) {
    for (int i = 0; i < qtdCidades; i++) {
      if (this.listaDeCidades[i].getNome().equals(cidade.getNome()) && this.listaDeCidades[i].getEstado().equals(cidade.getEstado())) {
        return i;
      }
    }

    return -1;
  } // Índice da cidade ? Índice da cidade : -1

  public int indiceReserva(Reserva reserva) {
    for (int i = 0; i < qtdReservas; i++) {
      if (this.listaDeReservas[i].getNumReserva() == reserva.getNumReserva()) {
        return i;
      }
    }

    return -1;
  } // Indice da reserva ? Indice da reserva : -1

  public void cadastrarCidade(Cidade cidade) {
    if (this.qtdCidades > this.maxCidades) {
      System.out.println("Número máximo de cidades atingido!");
      return;
    }

    if (this.indiceCidade(cidade) != -1) {
      System.out.println("Já há outra cidade com o mesmo nome!");
    }

    this.listaDeCidades[qtdCidades] = cidade;

    this.qtdCidades++;
  } // Cadastrar cidade na lista de cidades

  public void cadastrarCliente(Cliente cliente) {
    if (this.qtdClientes > this.maxClientes) {
      System.out.println("Número máximo de clientes atingido!");
      return;
    }

    if (this.indiceCliente(cliente.getCpf()) != -1) {
      System.out.println("Já há outro cliente com o mesmo CPF!");
      return;
    }

    this.listaDeClientes[qtdClientes] = cliente;

    this.qtdClientes++;
  } // Cadastrar cliente na lista de clientes

  public void reservarIda(Cliente cliente, Reserva reserva) {
    if (this.qtdReservas > this.maxReservas) {
      System.out.println("Quantidade máxima de reservas atingida!");
      return;
    }

    this.listaDeReservas[this.qtdReservas] = reserva;
    this.listaDeReservas[this.qtdReservas].setNumReserva(this.qtdReservas);
    
    cliente.reservarIda(reserva);

    this.qtdReservas++;

  } // Cadastrar uma reserva na lista de reservas

  public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
    if (this.qtdReservas > this.maxReservas) {
      System.out.println("Quantidade máxima de reservas atingida!");
      return;
    }

    volta.setNumReserva(this.qtdReservas);

    this.listaDeReservas[this.indiceReserva(ida)].setVolta(volta);

    cliente.reservarVolta(ida, volta);

  } // Cadastrar uma reserva do tipo "volta" atrelada a uma reserva do tipo "ida" já existente

  public Reserva[] mostrarReservas(String CPFCliente) {
    int i = this.indiceCliente(CPFCliente);
    Reserva[] reservas;
    Cliente cliente;

    if (i == -1) {
      System.out.println("Nenhum cliente encontrado!");
      return null;
    }

    cliente = this.listaDeClientes[i];
    reservas = cliente.getReservas();

    return reservas;
  }

  public String mostrarReservas() {
    String str = "";

    if (this.qtdReservas == 0) {
      str += "Não há nenhuma reserva cadastrada!";
      return str;
    }

    for (int i = 0; i < this.qtdReservas; i++) {
      str += "----- RESERVA " + i + " ----- \n\n";
      str += this.listaDeReservas[i].toString();
      str += "\n\n";
    }

    return str;
  }

  public String mostrarClientes() {
    String str = "";

    if (this.qtdClientes == 0) {
      str += "Não há nenhum cliente cadastrado!";
      return str;
    }

    for (int i = 0; i < this.qtdClientes; i++) {
      str += "----- CLIENTE " + i + " ----- \n\n";
      str += this.listaDeClientes[i].toString();
      str += "\n\n";
    }

    return str;
  }

  public String mostrarCidades() {
    String str = "";

    if (this.qtdCidades == 0) {
      str += "Não há nenhuma cidade cadastrada!";
      return str;
    }

    for (int i = 0; i < this.qtdCidades; i++) {
      str += "----- CIDADE " + i + " ----- \n\n";
      str += this.listaDeCidades[i].toString();
      str += "\n\n";
    }

    return str;
  }


  public Cidade[] getListaCidades() {
    return this.listaDeCidades;
  }
  public Cliente[] getListaClientes() {
    return this.listaDeClientes;
  }
  public Reserva[] getListaReservas() {
    return this.listaDeReservas;
  }
  public int getMaxCidades() {
    return this.maxCidades;
  }
  public int getMaxClientes() {
    return this.maxClientes;
  }
  public int getMaxReservas() {
    return this.maxReservas;
  }
  public int getQtdCidades() {
    return this.qtdCidades;
  }
  public int getQtdClientes() {
    return this.qtdClientes;
  }
  public int getQtdReservas() {
    return this.qtdReservas;
  } // MÉTODOS GETTERS
}