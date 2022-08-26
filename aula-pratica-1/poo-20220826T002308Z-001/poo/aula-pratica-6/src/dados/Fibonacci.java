package dados;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends Gerador {
    public void gerar(int quantidade) {
        List<Integer> sequencia = new ArrayList<Integer>();

        sequencia = fibonacci(quantidade);

        this.setSequencia(sequencia);
    }

    private List<Integer> fibonacci(int n) {
        List<Integer> fib = new ArrayList<>();

        if (n >= 1)
            fib.add(0);
        if (n >= 2)
            fib.add(1);
        if (n >= 3) {
            for (int i = 2; i < n; i++)
                fib.add(fib.get(i - 2) + fib.get(i - 1));
        }

        return fib;
    }
}