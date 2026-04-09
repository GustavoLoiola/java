import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Calculo de área de Retângulo.");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite a altura do retângulo: ");
        float altura = entrada.nextFloat();
        System.out.print("Digite a largura do retângulo: ");
        float largura = entrada.nextFloat();
        float area = altura * largura;
        System.out.printf("A área do retângulo é de: %.2f%n", area);
    }
}
