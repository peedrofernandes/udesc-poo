package dados;

public class Cidade {
    private String nome;
    private String estado;

    public Cidade(String nome, String estado) {
      this.nome = nome;
      this.estado = estado;
    }

    public String toString() {
        String str = "";

        str += "Nome da cidade: " + this.nome + "\n";
        str += "Estado: " + this.estado + "\n";
        
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