public class Main {
    public static void main(String[] args) {

        //sem lambda
        Produto alimento = new Alimentacao(200);
        System.out.println(alimento.calcularImposto());

        //com lambda
        Produto vesturario = () -> 200 *0.025;
        System.out.println(vesturario.calcularImposto());

    }
}