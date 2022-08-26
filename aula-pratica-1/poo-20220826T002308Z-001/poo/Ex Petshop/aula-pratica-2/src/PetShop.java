public class PetShop {
    private Veterinario veterinarios[];
    private int qtdVet = 0;

    public PetShop() {
        veterinarios = new Veterinario[50];
    }
    public PetShop(int qtd) {
        veterinarios = new Veterinario[qtd];
    }

    public void cadastrarVeterinario(Veterinario vet) {
        if (qtdVet > veterinarios.length) {
            System.out.println("A quantidade máxima de veterinários foi excedida, não é possível cadastrar mais!");
        } else {
            veterinarios[qtdVet] = vet;
            qtdVet++;
        }
    }

}