import java.util.concurrent.locks.ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        //quadrado
        Geometria quadradoTeste = new Quadrado(5);
        System.out.println(quadradoTeste.calcularArea());

        //retangulo
        Geometria retangulo = new Retangulo(10, 5);
        System.out.println(retangulo.calcularArea());


        //circulo
        Geometria circulo = new Circulo(5);
        System.out.println(circulo.calcularArea());

    }
}