package dados;

import java.util.ArrayList;
import java.util.List;

public class Abundantes extends Gerador {
    public void gerar(int quantidade) {
        List<Integer> sequencia = new ArrayList<Integer>();

        for (int i = 0; i < quantidade; i++) {
            int somaDosDivisores = 0;

            for (int j = 1; j < i; j++) {
                if (i % j == 0)
                    somaDosDivisores++;
            }

            if (somaDosDivisores > i)
                sequencia.add(i);
        }

        this.setSequencia(sequencia);
    }
}