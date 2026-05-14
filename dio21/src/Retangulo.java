public class Retangulo implements Geometria{
    double altura;
    double largura;

    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }
}
