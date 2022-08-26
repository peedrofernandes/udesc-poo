package pkg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkg.exceptions.NomeInvalidoException;

import pkg.arquivos.*;
import pkg.arquivos.Video.Qualidade;

public class SistemaArquivos {
  private List<Arquivo> arquivos;
  private Map<String, List<Arquivo>> diretorios;

  public SistemaArquivos() {
    this.arquivos = new ArrayList<>();
    this.diretorios = new HashMap<>();
  }

  public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException {
    Documento d = new Documento(nome, texto);
    inserirArquivo(d, diretorio);
  }

  public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException {
    Musica m = new Musica(nome, duracao);
    inserirArquivo(m, diretorio);
  }

  public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException {
    Video v = new Video(nome, qualidade);
    inserirArquivo(v, diretorio);
  }

  private void inserirArquivo(Arquivo arquivo, String diretorio) {
    List<Arquivo> key = this.diretorios.get(diretorio.toLowerCase());

    if (key == null)
      this.diretorios.put(diretorio.toLowerCase(), new ArrayList<Arquivo>());

    this.diretorios.get(diretorio.toLowerCase()).add(arquivo);
    this.arquivos.add(arquivo);
  }

  public String toString() {
    String str = "";

    for (String dir : this.diretorios.keySet()) {
      str += dir + "\n\n";

      for (Arquivo arq : this.diretorios.get(dir)) {
        str += arq.getNome() + "." + arq.getExtensao() + "\n";
        if (arq instanceof Documento) {
          Documento doc = (Documento) arq;
          str += "Texto: " + doc.getTexto() + "\n\n";
        }
        if (arq instanceof Musica) {
          Musica msc = (Musica) arq;
          str += "Duração: " + msc.getDuracao() + "\n\n";
        }
        if (arq instanceof Video) {
          Video vid = (Video) arq;
          str += "Qualidade: " + vid.getQualidade().toString() + "\n\n";
        }
      }
      
    }

    return str;
  }
}
