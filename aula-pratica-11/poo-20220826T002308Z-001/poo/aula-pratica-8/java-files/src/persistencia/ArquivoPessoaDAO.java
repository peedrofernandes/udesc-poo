package persistencia;

import java.util.LinkedList;
import java.util.List;

import dados.Pessoa;

public class ArquivoPessoaDAO {
    private final String caminho = "files/pessoas.csv";
    private static EditorTexto arquivo = new EditorTexto();

    private String toCSV (Pessoa pessoa) {
        String p = "";

        p += pessoa.getNome() + ",";
        p += pessoa.getIdade() + ",";
        p += pessoa.getMassa() + ",";
        p += pessoa.getAltura() + ",";

        return p;
    }

    private Pessoa fromCSV(String linha) {
        Pessoa p = new Pessoa();

        try {

            String[] elems = linha.split(",");

            p.setNome(elems[0]);
            p.setIdade(Integer.parseInt(elems[1]));
            p.setMassa(Float.parseFloat(elems[2]));
            p.setAltura(Float.parseFloat(elems[3]));

        } catch (Exception e) {

            System.err.println("Houve um erro na conversão de CSV para objeto!" + e);
            System.exit(0);

        }

        return p;
    }

    private List<String> listaPessoaToString(List<Pessoa> pessoas) {
        List<String> stringPessoas = new LinkedList<>();

        for (Pessoa p : pessoas)
            stringPessoas.add(toCSV(p));

        return stringPessoas;
    }

    private List<Pessoa> stringToListaPessoa(List<String> arquivo) {
        List<Pessoa> pessoas = new LinkedList<>();

        for (String s : arquivo)
            pessoas.add(fromCSV(s));

        return pessoas;
    }   

    public List<Pessoa> lerPessoasNoArquivo() {
        return stringToListaPessoa(arquivo.lerTexto(caminho));
    }

    public void salvarPessoasNoArquivo(List<Pessoa> pessoas) {
        arquivo.gravarTexto(caminho, listaPessoaToString(pessoas));
    }

    public void salvarPessoaNoArquivo(Pessoa p) {
        arquivo.gravarTexto(caminho, toCSV(p));
    }
}