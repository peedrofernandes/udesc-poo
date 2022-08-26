package dados;

public class Locadora {
    private String nome;

    private Carro[] carros;
    private Cliente[] clientes; 
    private Vendedor[] vendedores;
    private Contrato[] contratosFechados;

    private int qtdCarros;
    private int qtdClientes;
    private int qtdVendedores;
    private int qtdContratosFechados;

    public String toString() {
        String str = "";

        str += "----- LOCADORA " + this.nome + " -----\n\n";

        str += "Carros:\n\n";

        for (int i = 0; i < this.qtdCarros; i++) {
            str += "--- Carro " + i + " ---\n\n"
            str += this.carros[i].toString();
        }

        str += "Clientes:\n\n";

        for (int i = 0; i < this.qtdClientes; i++) {
            str += "--- Cliente " + i + " ---\n\n";
            str += this.clientes[i].toString();
        }

        str += "Vendedores:\n\n";

        for (int i = 0; i < this.qtdVendedores; i++) {
            str += "--- Vendedor " + i + " ---\n\n";
            str += this.vendedores[i].toString();
        }

        str += "Contratos fechados:\n\n";

        for (int i = 0; i < this.qtdContratosFechados; i++) {

        }
    }

    public Vendedor[] getVendedores() {
        return this.vendedores;
    }
    public Cliente[] getClientes() {
        return this.clientes;
    }
    public Carro[] getCarros() {
        return this.carros;
    }
    public Contrato[] getContratos() {
        return this.contratosFechados;
    }
    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }
    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }
    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }
    public void setContratosFechados(Contrato[] contratosFechados) {
        this.contratosFechados = contratosFechados;
    }
}