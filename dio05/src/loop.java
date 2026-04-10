import java.util.Scanner;

public class loop {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int s = 0;
        while (true) {
            System.out.print("(0 para terminar) Digite um número: ");
            int num = entrada.nextInt();
            if(num == 0) {
                break;
            }
            s += num;
        }
        System.out.printf("A soma de todos os números é igual a: %d", s);
    }
}
