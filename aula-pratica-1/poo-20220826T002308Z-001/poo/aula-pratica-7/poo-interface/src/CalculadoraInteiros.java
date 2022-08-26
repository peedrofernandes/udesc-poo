public class CalculadoraInteiros implements IOperacoesBasicas<Integer> {
    int n1;
    int n2;

    public Integer somar(Integer n1, Integer n2) {
        return n1 + n2;
    }

    public Integer subtrair(Integer n1, Integer n2) {
        return n1 - n2;
    }
}