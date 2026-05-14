public class Vestuario implements Produto{
    double valor;

    public Vestuario(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularImposto() {
        return valor * 0.025;
    }
}
