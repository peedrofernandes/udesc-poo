public class Veterinario {
    private String nome;
    private int salario;
    private Endereco endereco;
    private Animal animais[];
    private int qtdAnimais;

    public String getNome() {
        return this.nome;
    }
    public int getSalario() {
        return this.salario;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }
    public Animal[] getAnimais() {
        return this.animais;
    }
    public int getQtdAnimais() {
        return this.qtdAnimais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setAnimais(Animal[] animais) {
        this.animais = animais;
    }
    public void setQtdAnimais(int qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }
}