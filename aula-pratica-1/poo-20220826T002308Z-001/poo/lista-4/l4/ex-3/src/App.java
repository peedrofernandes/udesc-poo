import pkg.SistemaArquivos;

import pkg.arquivos.Video.Qualidade;

public class App {
  private static SistemaArquivos fs;

  public static void main(String[] args) throws Exception {
    fs = new SistemaArquivos();

    fs.criarDocumento("lista-de-mercado", "referencias", "ovo,leite,carne");
    fs.criarDocumento("tarefas-do-dia", "referencias", "trabalho,academia");
    fs.criarMusica("industry-baby", "lazer", 240);
    fs.criarVideo("cortando-placa-youtube", "lazer", Qualidade.Q720P);
    fs.criarVideo("equaciona-paulo-pereira", "referencias", Qualidade.Q240P);

    System.out.println(fs);
  }
}
