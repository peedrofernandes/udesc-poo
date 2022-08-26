package dados;

public class Cliente {
  private String cpf;
  private String nome;
  private String endereco;
  private String telefone;

  private Reserva[] reservas;

  private int qtdReservas;
  private int maxReservas;

  private int indiceReserva(Reserva reserva) {
    for (int i = 0; i < this.qtdReservas; i++) {
      if (this.reservas[i].getNumReserva() == reserva.getNumReserva()) {
        return i;
      }
    }

    return -1;
  }

  public Cliente(String cpf, String nome, String endereco, String telefone, int maxReservas) {
    reservas = new Reserva[maxReservas];

    this.cpf = cpf;
    this.nome = nome;
    this.endereco = endereco;
    this.telefone = telefone;
    this.maxReservas = maxReservas;

    this.qtdReservas = 0;
  }
  
  public void reservarIda(Reserva reserva) {

    if (this.qtdReservas > this.maxReservas) {
      System.out.println("Número máximo de reservas atingido para o cliente " + this.nome + "!");
      return;
    }

    if (this.indiceReserva(reserva) != -1) {
      System.out
          .println("Já há uma reserva de número " + reserva.getNumReserva() + " para o cliente " + this.nome + "!");
      return;
    }

    this.qtdReservas++;

    this.reservas[qtdReservas - 1] = reserva;
  }

  public void reservarVolta(Reserva ida, Reserva volta) {
    int indiceReserva = indiceReserva(ida);

    if (indiceReserva == -1) {
      System.out
          .println("Reserva de número " + ida.getNumReserva() + " não encontrada para o cliente " + this.nome + "!");
      return;
    }

    this.reservas[indiceReserva].setVolta(volta);
  }

  public String toString() {
    String str = "Nome: " + this.nome + "\n";

    str += "CPF: " + this.cpf + "\n";
    str += "Endereço: " + this.endereco + "\n";
    str += "Telefone: " + this.telefone + "\n";

    return str;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public Reserva[] getReservas() {
    return this.reservas;
  } // GETTERS

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  } // SETTERS
}

