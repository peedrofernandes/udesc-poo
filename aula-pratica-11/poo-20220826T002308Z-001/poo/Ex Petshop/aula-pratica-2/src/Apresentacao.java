import java.util.Scanner;

public class Apresentacao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        PetShop petShop = new PetShop(20);
        Veterinario vet = new Veterinario();

        System.out.print("Digite o nome do veterinario: ");
        vet.setNome(input.nextLine());
        petShop.cadastrarVeterinario(vet);

        input.close();
    }
}