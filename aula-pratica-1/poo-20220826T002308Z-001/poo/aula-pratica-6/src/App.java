
import dados.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Gerador perfeitos = new Perfeitos();
        Gerador fibonacci = new Fibonacci();
        Gerador fatoriais = new Fatoriais();

        Scanner input = new Scanner(System.in);

        System.out.print("Digite um numero inteiro: ");
        int n = input.nextInt();

        perfeitos.gerar(n);
        fibonacci.gerar(n);
        fatoriais.gerar(n);

        System.out.println("Numeros perfeitos: " + perfeitos.getSequencia());
        System.out.println("Sequencia de fibonacci: " + fibonacci.getSequencia());
        System.out.println("Sequencia de fatoriais: " + fatoriais.getSequencia());
    }
}
