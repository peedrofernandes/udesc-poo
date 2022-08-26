package dados;

public class Pessoa {
    private String nomeCompleto;
    private String cpf;
    private String dataNasc;

    public String toString() {
        String str = "";

        str += "Nome: " + this.nomeCompleto + "\n";
        str += "CPF: " + this.cpf + "\n";
        str += "Data de nascimento: " + this.dataNasc + "\n";

        return str;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }
    public String getCpf() {
        return this.cpf;
    }
    public String dataNasc() {
        return this.dataNasc;
    }   
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}