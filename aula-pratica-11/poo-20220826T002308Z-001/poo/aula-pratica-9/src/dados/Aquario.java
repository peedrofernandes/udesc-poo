package dados;

import java.util.List;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    private List<Peixe> peixes;

    public float calcularEspaco() {
        float s = this.getComprimento() * this.getLargura() * this.altura;
        return s;
    } 

    public float getAltura() {

        return this.altura;
    }

    public float getTemperatura() {
        return this.temperatura;
    }

    public List<Peixe> getPeixes() {
        return this.peixes;
    }
}