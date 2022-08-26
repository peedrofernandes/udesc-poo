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

    public String toString() {
        String str = "";

        str += "Número da reserva" + this.numReserva + "\n";
        str += "Origem: " + this.origem.getNome() + "\n";
        str += "Destino: " + this.destino.getNome();
        str += "Data do voo: " + this.dataVoo + "\n";
        str += "Hora do voo: " + this.horaVoo + "\n";
        str += "Classe do voo: " + this.classeVoo + "\n";
        str += "Poltrona: " + this.poltrona + "\n";
        str += "Preço da passagem: R$" + this.preco + "\n";

        if (volta != null) {
            str += "Passagem de volta: " + this.volta.getNumReserva() + "\n";
        } else {
            str += "Não possui passagem de volta" + "\n";
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
    } // SETTERS


}