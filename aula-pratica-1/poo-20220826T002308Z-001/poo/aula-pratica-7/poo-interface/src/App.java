import java.util.Random;

public class App {
    public static void main(String[] args) {
        CalculadoraInteiros cInt = new CalculadoraInteiros();
        CalculadoraComplexos cComp = new CalculadoraComplexos();

        Random rand = new Random();

        int i1 = rand.nextInt() % 10;
        int i2 = rand.nextInt() % 10;

        Complexo c1 = new Complexo(rand.nextInt() % 10, rand.nextInt() % 10);
        Complexo c2 = new Complexo(rand.nextInt() % 10, rand.nextInt() % 10);

        System.out.println("Numeros gerados: \n");

        System.out.println(i1 + ", " + i2 + ";");
        System.out.println("[" + c1.toString() + "], [" + c2.toString() + "];\n");

        System.out.println("Soma dos inteiros: " + cInt.somar(i1, i2));
        System.out.println("Subtração dos inteiro0s: " + cInt.subtrair(i1, i2));
        System.out.println("Soma dos complexos: " + cComp.somar(c1, c2));
        System.out.println("Subtração dos complexos: " + cComp.subtrair(c1, c2));
    }
}