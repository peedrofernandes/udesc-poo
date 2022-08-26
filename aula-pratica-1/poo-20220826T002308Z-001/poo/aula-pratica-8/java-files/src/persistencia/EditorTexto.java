package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {
    public void gravarTexto(String caminho, List<String> dados) {
        try {

            FileWriter fw = new FileWriter(caminho);
            for (String s : dados)
                fw.write(s + "\n");
            fw.close();

        } catch (Exception e) {

            System.err.println("Houve um erro ao inserir dados no arquivo!" + e);
            System.exit(0);

        }
    }

    public void gravarTexto(String caminho, String linha) {
        try {

            FileWriter fw = new FileWriter(caminho);
            fw.write(linha);
            fw.close();

        } catch (Exception e) {

            System.err.println("Houve um erro ao inserir uma linha no arquivo!" + e);
            System.exit(0);
        
        }
    }

    public List<String> lerTexto(String caminho) {
        List<String> personList = new LinkedList<>();
        String person = "";

        try {

            FileReader fr = new FileReader(caminho);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                person = br.readLine();
                if (person == null) break;
                personList.add(person);
            }
            br.close();

        } catch (Exception e) {

            System.err.println("Houve um erro ao ler os dados do arquivo! " + e);
            System.exit(0);

        }

        return personList;
    }
}