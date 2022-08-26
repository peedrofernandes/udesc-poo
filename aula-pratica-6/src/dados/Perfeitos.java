package dados;

import java.util.ArrayList;
import java.util.List;

public class Perfeitos extends Naturais {
    public void gerar(int quantidade) {
        List<Integer> sequencia = new ArrayList<Integer>();

        for (int i = 0; i < quantidade; i++) {
            int somaDosDivisores = 0;

            for (int n = 1; n < i; n++) {
                if (i % n == 0)
                    somaDosDivisores += n;
            }

            if (somaDosDivisores == i)
                sequencia.add(i);
        }

        this.setSequencia(sequencia);
    }
}