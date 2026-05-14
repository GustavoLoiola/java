public class Alimentacao implements Produto{

    private double valor;

    public Alimentacao(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.01;
    }
}
