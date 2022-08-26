package dados;

import java.util.ArrayList;
import java.util.List;

public class Naturais extends Gerador {
    public void gerar(int quantidade) {
        List<Integer> sequencia = new ArrayList<>();

        for (int i = 0; i < quantidade; i++)
            sequencia.add(i);

        this.setSequencia(sequencia);
    }
}