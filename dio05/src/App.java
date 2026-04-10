import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um número para ver o dia da semana correspondente: ");
        int dia = entrada.nextInt();
        switch (dia) {
           case 1 -> System.out.println("Segunda");
           case 2 -> System.out.println("Terça");
           case 3 -> System.out.println("Quarta");
           case 4 -> System.out.println("Quinta");
           case 5 -> System.out.println("Sexta");
           case 6 -> System.out.println("Sábado");
           case 7 -> System.out.println("Domingo");
           default -> System.out.println("Esse número não representa nenhum dia da semana!");
        }
    }
}
