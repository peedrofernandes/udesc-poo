package pkg;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    Cliente c1 = new Cliente("c1");
    Cliente c2 = new Cliente("c2");
    Cliente c3 = new Cliente("c3");
    Cliente c4 = new Cliente("c4");
    Cliente c5 = new Cliente("c5");

    Servidor s1 = new Servidor(generateIP());
    Servidor s2 = new Servidor(generateIP());
    Servidor s3 = new Servidor(generateIP());

    s1.adicionar(c1);
    s1.adicionar(c2);
    s1.adicionar(c4);

    s2.adicionar(c1);
    s2.adicionar(c3);
    s2.adicionar(c2);
    s2.adicionar(c5);

    s3.adicionar(c4);
    s3.adicionar(c5);
    s3.adicionar(c3);

    s1.enviarMensagem("Oi!");
    s2.enviarMensagem("Tudo bem?");
    s3.enviarMensagem("Receba!");

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
    System.out.println(c4);
    System.out.println(c5);
  }

  private static String generateIP() {
    Random randint = new Random();

    String ip = "";

    for (int i = 1; i <= 4; i++) {
      int number = randint.nextInt() % 256;
      if (number < 0)
        number = -2 * number;
      ip += Integer.toString(number);
      if (i != 4)
        ip += ".";
    }

    return ip;
  }
}
