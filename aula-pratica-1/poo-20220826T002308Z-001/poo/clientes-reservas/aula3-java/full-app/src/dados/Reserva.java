package dados;

public class Reserva {
    private int numReserva;
    private String dataVoo;
    private String horaVoo; 
    private String classeVoo;
    private float preco;
    private int poltrona;

    private Reserva volta;

    public String toString() {
        String str = "O voo " + this.numReserva + ", que custou R$" + this.preco + ", é da classe" + this.classeVoo + ", Poltrona " + this.poltrona +  ", está marcado para " + this.dataVoo + " às " + this.horaVoo + ".";

        if (volta != null) {
            str += "É um voo de ida e volta.";
        } else {
            str += "É um voo somente de ida.";
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