public class Complexo {
    private int parteReal;
    private int parteImaginaria;

    public Complexo() {};

    public Complexo(int parteReal, int parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    public String toString() {
        String str = "";

        str += this.parteReal + " + " + this.parteImaginaria + "i";

        return str;
    }

    public int getParteReal() {
        return this.parteReal;
    }

    public int getParteImaginaria() {
        return this.parteImaginaria;
    }
}