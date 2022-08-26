package dados;

public class Cidade {
    private String nome;
    private String estado;

    public String toString() {
        String str = this.nome;
        str += " - ";
        str += this.estado;
        
        return str;
    }

    public String getNome() {
        return this.nome;
    }
    public String getEstado() {
        return this.estado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}