package pkg;

public class AnimaisFactory {
  private static AnimaisFactory instance = null;

  private AnimaisFactory() {};
  
  public static AnimaisFactory getInstance() {
    if (instance != null)
      return instance;
    
    return new AnimaisFactory();
  }

  public Animal create(Animais desc) {
    if (desc == Animais.CAO)
      return new Cao();
    else if (desc == Animais.GATO)
      return new Gato();
    else if (desc == Animais.RATO)
      return new Rato();
    else if (desc == Animais.SAPO)
      return new Sapo();
    else if (desc == Animais.COBRA)
      return new Cobra();
    return null;
  }
}
