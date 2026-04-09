import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //Sintaxe para comentários!!!
        Scanner entrada = new Scanner(System.in);
        System.out.println("Olá, seja bem vindo ao meu programa!");
        System.out.println("Digite um número para ver o seu fatorial: ");
        int num = entrada.nextByte();
        int numF = num;
        int res = 1;
        for(int i= 1; i < num + 1; i++) {
            res *= i;
        }
        System.out.printf("O fatorial de %d é: %d", numF, res);
    }
}
