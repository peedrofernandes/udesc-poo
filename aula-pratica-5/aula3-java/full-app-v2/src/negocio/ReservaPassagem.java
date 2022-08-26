package negocio;

import dados.*;

public class ReservaPassagem {
    private Cidade[] listaDeCidades;
    private Cliente[] listaDeClientes;

    private int maxCidades;
    private int maxClientes;

    private int qtdCidades;
    private int qtdClientes;

    private int indiceCliente(int CPFCliente) {
        for (int i = 0; i < qtdClientes; i++) {
            if (this.listaDeClientes[i].getCpf() == CPFCliente)) {
                return i;
            }
        }

        return -1;
    }

    private int indiceCidade(Cidade cidade) {
        for (int i = 0; i < qtdCidades; i++) {
            if (this.listaDeCidades[i].getNome().equals(cidade.getNome())) {
                return i;
            }
        }

        return -1;
    }

    public ReservaPassagem(int maxCidades, int maxClientes) {
        this.maxCidades = maxCidades;
        this.maxClientes = maxClientes;

        listaDeCidades = new Cidade[maxCidades];
        listaDeClientes = new Cliente[maxClientes];

        this.qtdCidades = 0;
        this.qtdClientes = 0;
    }

    public void cadastrarCidade(Cidade cidade) {
        this.qtdCidades++;

        if (this.qtdCidades > this.maxCidades) {
            System.out.println("Número máximo de cidades atingido!");
            return;
        }

        if (this.indiceCidade(cidade) != -1) {
            System.out.println("Já há outra cidade com o mesmo nome!");
        }

        this.listaDeCidades[qtdCidades - 1] = cidade;
    }

    public void cadastrarCliente(Cliente cliente) {
        this.qtdClientes++;

        if (this.qtdClientes > this.maxClientes) {
            System.out.println("Número máximo de clientes atingido!");
            return;
        }

        if (this.indiceCliente(cliente.getCpf()) != -1) {
            System.out.println("Já há outro cliente com o mesmo CPF!");
        }

        this.listaDeClientes[qtdClientes - 1] = cliente;
    }

    public void reservarIda(Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta(Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public Reserva[] mostrarReservas(int CPFCliente) {
        int i = this.indiceCliente(CPFCliente);

        if (i == -1) {
            System.out.println("Não foi encontrado nenhum cliente!");
        }
    }

}