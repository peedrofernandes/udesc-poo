package dados;

public class Cliente extends Pessoa {
    private int nCliente;
    private Contrato[] contratosFechados; 
    private int qtdContratos;

    public String toString() {
        String str = "";

        str += "Nome: " + this.nomeCompleto + "\n";
        str += "CPF: " + this.cpf + "\n";
        str += "Data de nascimento: " + this.dataNasc + "\n";
        str += "Numero do cliente: " + this.nCliente + "\n";
        str += "Contratos: \n";

        for (int i = 0; i < qtdContratos; i++) {
            str += "\n\n----- Contrato " + i + " -----\n\n";
            str += contratosFechados[i].toString();
        }

        return str;
    }

    public int getNCliente() {
        return this.nCliente;
    }
    public Contrato[] getContratosFechados() {
        return this.contratosFechados;
    }
    public void setNCliente(int nCliente) {
        this.nCliente = nCliente;
    }
    public void setContratosFechados(Contrato[] contratosFechados) {
        this.contratosFechados = contratosFechados;
    }
}