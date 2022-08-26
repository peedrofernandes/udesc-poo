package dados;

public class Endereco {
  private int id;
  private String rua;
  private int numero;
  private String cidade;
  private int idPessoa;
  
  public Endereco(int id, String rua, int numero, String cidade) {
    this.id = id;
    this.rua = rua;
    this.numero = numero;
    this.cidade = cidade;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public int getIdPessoa() {
    return idPessoa;
  }

  public void setIdPessoa(int idPessoa) {
    this.idPessoa = idPessoa;
  }


}
