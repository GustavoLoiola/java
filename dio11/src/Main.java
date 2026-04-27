import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o lado do quadrado: ");
        int lado = entrada.nextInt();
        String area = "* ".repeat(lado);

        System.out.println(area);
        for(int i=2; i < lado; i++) {

            System.out.println("* " + "  ".repeat(lado - 2) + "*");
        }
        System.out.println(area);
    }
}