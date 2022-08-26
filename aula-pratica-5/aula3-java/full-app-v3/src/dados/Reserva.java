package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo; 
    private String classeVoo;
    private float preco;
    private int poltrona;

    private Cidade origem;
    private Cidade destino;

    private Reserva volta;

    public Reserva(
      String dataVoo,
      String horaVoo,
      String classeVoo, 
      float preco, 
      int poltrona, 
      Cidade origem, 
      Cidade destino
    ) {
        this.dataVoo = dataVoo;
        this.horaVoo = horaVoo;
        this.classeVoo = classeVoo;
        this.preco = preco;
        this.poltrona = poltrona;
        this.origem = origem;
        this.destino = destino;
      }

    public String toString() {
        String str = "";

        str += "Número da reserva: " + this.numReserva + "\n";
        str += "Origem: " + this.origem.getNome() + "\n";
        str += "Destino: " + this.destino.getNome() + "\n";
        str += "Data do voo: " + this.dataVoo + "\n";
        str += "Hora do voo: " + this.horaVoo + "\n";
        str += "Classe do voo: " + this.classeVoo + "\n";
        str += "Poltrona: " + this.poltrona + "\n";
        str += "Preço da passagem: R$" + this.preco + "\n";

        if (volta != null) {
            str += "\nPassagem de volta: " + "\n\n" + this.volta.toString() + "\n\n";
        } else {
            str += "Não possui passagem de volta" + "\n\n";
        }

        return str;
    }

    public int getNumReserva() {
        return this.numReserva;
    }
    public String getDataVoo() {
        return this.dataVoo;
    }
    public String getHoraVoo() {
        return this.horaVoo;
    }
    public String getClasseVoo() {
        return this.classeVoo;
    }
    public float getPreco() {
        return this.preco;
    }
    public int getPoltrona() {
        return this.poltrona;
    }
    public Reserva getVolta() {
      return this.volta;
    }
    public Cidade getOrigem() {
      return this.origem;
    }
    public Cidade getDestino() {
      return this.destino;
    } // GETTERS

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }
    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }
    public void setHoraVoo(String horaVoo) {
        this.horaVoo = horaVoo;
    }
    public void setClasseVoo(String classeVoo) {
        this.classeVoo = classeVoo;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }
    public void setVolta(Reserva volta) {
      this.volta = volta;
    }
    public void setOrigem(Cidade origem) {
      this.origem = origem;
    }
    public void setDestino(Cidade destino) {
      this.destino = destino;
    } // SETTERS


}