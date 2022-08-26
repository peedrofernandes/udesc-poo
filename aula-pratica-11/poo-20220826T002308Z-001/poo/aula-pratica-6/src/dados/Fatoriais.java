package dados;

import java.util.ArrayList;
import java.util.List;

public class Fatoriais extends Gerador {
    public void gerar(int quantidade) {
        List<Integer> sequencia = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++)
            sequencia.add(fatorial(i));

        this.setSequencia(sequencia);
    }

    private int fatorial(int n) {
        if (n == 0)
            return 1;

        return n * fatorial (n - 1);
    }
}