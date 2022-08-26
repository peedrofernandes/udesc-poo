import java.util.Random;
import java.util.Scanner;

import pkg.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Soma soma = new Soma();
    MDC mdc = new MDC();
    Mod mod = new Mod();
    Multiplicacao multiplicacao = new Multiplicacao();

    Scanner inputScanner = new Scanner(System.in);
    String input, output;
    Random genRandom = new Random();

    do {
      output = "";

      int n1 = genRandom.nextInt() % 100;
      int n2 = genRandom.nextInt() % 100;

      if (n1 < 0)
        n1 = -2 * n1;
      if (n2 < 0)
        n2 = -2 * n2;

      output += "Números gerados: (" + n1 + "," + n2 + ") \n";
      output += "Soma: " + soma.executar(n1, n2) + "\n";
      output += "MDC: " + mdc.executar(n1, n2) + "\n";
      output += "Mod: " + mod.executar(n1, n2) + "\n";
      output += "Multiplicação: " + multiplicacao.executar(n1, n2) + "\n";

      System.out.println(output);
      System.out.print("Digite qualquer coisa para encerrar ou pressione enter para continuar... ");

      input = inputScanner.nextLine();
      
    } while (input.equals(""));

    inputScanner.close();
  }
}
