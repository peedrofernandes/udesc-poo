package dados;

public class Contrato {
    private int nContrato;
    private Carro carroAlugado;
    private Cliente cliente;
    private Vendedor vendedor;
    private int valor;

    public String toString() {
        String str = "";

        str += "Número do contrato: " + this.nContrato + "\n";
        str += "Carro alugado: " + this.carroAlugado.getMarca() + ", " + this.carroAlugado.getModelo() + "\n";
        str += "Cliente: " + this.cliente.getNomeCompleto() + ", " + this.cliente.getNCliente() + "\n";
        str += "Vendedor: " + this.vendedor.getNomeCompleto() + ", " + this.vendedor.getClt() + "\n";
        str += "Valor do contrato: " + this.valor;

        return str;
    }

    public int getNContrato() {
        return this.nContrato;
    }
    public Carro getCarroAlugado() {
        return this.carroAlugado;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public Vendedor getVendedor() {
        return this.vendedor;
    }
    public int getValor() {
        return this.valor;
    }
    public void setNContrato(int nContrato) {
        this.nContrato = nContrato;
    }
    public void setCarroAlugado(Carro carroAlugado) {
        this.carroAlugado = carroAlugado;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
}