import pkg.Animais;
import pkg.AnimaisFactory;
import pkg.Animal;

public class App {
  static AnimaisFactory animaisFactory;

  public static void main(String[] args) throws Exception {
    animaisFactory = AnimaisFactory.getInstance();

    Animal gato = animaisFactory.create(Animais.GATO);
    Animal cobra = animaisFactory.create(Animais.COBRA);
    Animal cao = animaisFactory.create(Animais.CAO);

    System.out.println(gato.emitirSom());
    System.out.println(cobra.emitirSom());
    System.out.println(cao.emitirSom());

  }
}
