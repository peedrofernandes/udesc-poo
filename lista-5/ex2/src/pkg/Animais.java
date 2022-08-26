package pkg;

public enum Animais {
  CAO("cão"),
  GATO("gato"),
  RATO("rato"),
  SAPO("sapo"),
  COBRA("cobra");

  String desc;
  
  private Animais(String desc) {
    this.desc = desc;
  }

  public String getDescricao() {
    return this.desc;
  }

}
