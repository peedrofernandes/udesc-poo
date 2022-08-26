package principal;
import java.util.Scanner;

public class Ex1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] values = new int[5];
    float avg = 0;
    
    for (int i = 0; i < 5; i++) {
      System.out.print("Digite o valor " + (i + 1) + ": ");
      values[i] = input.nextInt();
      avg += values[i];
    }
    
    avg = avg / 5;

    System.out.println("Média final: " + avg);

    input.close();

  }
}