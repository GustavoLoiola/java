import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner entrada = new Scanner(System.in);
       System.out.println("TRIÂNGULO RETÂNGULO");
       System.out.print("Digite o número da base do triângulo retângulo: ");
       int base = entrada.nextInt();
       String asterisco = "*";
       for(int i=0; i < base; i++) {
        System.out.println(asterisco);
        asterisco += "*";
       }
    entrada.close();
    }
}
