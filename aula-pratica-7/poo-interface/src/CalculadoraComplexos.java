
public class CalculadoraComplexos implements IOperacoesBasicas<Complexo> {
    public Complexo somar(Complexo n1, Complexo n2) {
        int r1 = n1.getParteReal();
        int i1 = n1.getParteImaginaria();

        int r2 = n2.getParteReal();
        int i2 = n2.getParteImaginaria();

        Complexo res = new Complexo(r1 + r2, i1 + i2);

        return res;
    }

    public Complexo subtrair(Complexo n1, Complexo n2) {
        int r1 = n1.getParteReal();
        int i1 = n1.getParteImaginaria();

        int r2 = n2.getParteReal();
        int i2 = n2.getParteImaginaria();

        Complexo res = new Complexo(r1 - r2, i1 - i2);

        return res;
    }
}