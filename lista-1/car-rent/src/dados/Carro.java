package dados;

public class Carro {
    private String marca;
    private String modelo;
    private String ano;
    private double quilometragem;
    private double valorFipe;
    private double valorFinal; // Valor considerando a quilometragem

    public String toString() {
        String str = "";

        str += "Marca: " + this.marca + "\n";
        str += "Modelo: " + this.modelo + "\n";
        str += "Ano: " + this.ano + "\n";
        str += "Quilometragem: " + this.quilometragem + "\n";
        str += "Valor da Tabela Fipe: " + this.valorFipe + "\n";
        str += "Valor final do carro considerando a quilometragem: " + this.valorFinal + "\n";

        return str;
    }

    public Carro(String marca, String modelo, String ano, double quilometragem, double valorFipe, double valorFinal) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.valorFipe = valorFipe;
        this.valorFinal = valorFinal;
    }

    public Carro(String marca, String modelo, String ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return this.marca;
    }
    public String getModelo() {
        return this.modelo;
    }
    public String getAno() {
        return this.ano;
    }
    public double getQuilometragem() {
        return this.quilometragem;
    }
    public double getValorFipe() {
        return this.valorFipe;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
    public void setValorFipe(int valorFipe) {
        this.valorFipe = valorFipe;
    }
}