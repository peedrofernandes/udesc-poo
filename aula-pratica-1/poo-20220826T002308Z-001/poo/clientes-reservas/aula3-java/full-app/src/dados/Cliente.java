package dados;

public class Cliente {
    private int cpf;
    private String nome;
    private String endereco;
    private int telefone;

    private Reserva[] reservas;

    private int qtdReservas;

    public Cliente (int maxReservas) {
        reservas = new Reserva[maxReservas];
        this.qtdReservas = 0;
    }

    public void reservarIda(Reserva reserva) {
        this.qtdReservas++;
        
        this.reservas[qtdReservas - 1] = reserva;
    }

    public void reservarVolta(Reserva reserva) {
        this.reservas[qtdReservas - 1].setVolta(reserva);
    }

    public String toString() {
        String str = "Nome: " + this.nome + "\n";
        str += "CPF: " + this.cpf + "\n";
        str += "Endereço: " + this.endereco + "\n";
        str += "Telefone: " + this.telefone + "\n";

        return str;
    }

    public int getCpf() {
        return this.cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    public int getTelefone() {
        return this.telefone;
    } // GETTERS

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    } // SETTERS
}

