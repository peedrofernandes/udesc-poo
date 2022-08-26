package principal;

import utils.Person;

import java.util.Scanner;

public class Ex2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Person group[] = new Person[5];

    for (int i = 0; i < 5; i++) {
      System.out.print("Digite o nome da pessoa " + (i + 1) + ":");
      group[i].nome = input.nextLine();
      System.out.print("Digite a idade da pessoa " + (i + 1) + ":");
      group[i].idade = input.nextInt();
    }

    for (int i = 0; i < 5; i++) {
      for (int j = i; j < 5; j++) {
        if (group[j].idade > group[i].idade) {
          Person aux = new Person();
          aux = group[j];
          group[j] = group[i];
          group[i] = aux;
        }
      }
      System.out.println("Nome: " + group[i].nome + ", idade: " + group[i].idade);
    }



    input.close();
  }
}
