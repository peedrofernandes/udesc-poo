package dados;

public class Vendedor extends Pessoa {
    private String clt;
    private Contrato[] vendas;
    private int comissao;

    public String getClt() {
        return this.clt;
    }
    public Contrato[] getVendas() {
        return this.vendas;
    }
    public int getComissao() {
        return this.comissao;
    }
    public void setClt(String clt) {
        this.clt = clt;
    }
    public void setVendas(Contrato[] vendas) {
        this.vendas = vendas;
    }
    public void setComissao(int comissao) {
        this.comissao = comissao;
    }

}