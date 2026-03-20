import java.util.Scanner;

public class media {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a primeira nota do aluno (0 a 5): ");
        double nota1 = entrada.nextDouble();

        if (nota1 < 0 || nota1 > 5) {
            System.out.println("Erro! Por favor digite uma nota entre 0 e 5.");
            return;
        }

        System.out.println("Digite a segunda nota do aluno (0 a 5): ");
        double nota2 = entrada.nextDouble();

        if (nota2 < 0 || nota2 > 5) {
            System.out.println("Erro! Por favor digite uma nota entre 0 e 5.");
            return;
        }

        double notaFinal = (nota1 + nota2) / 2;

        if (notaFinal >= 3) {
            System.out.println("Aluno aprovado!!!");
        } else {
            System.out.println("Aluno reprovado.");
        }
    }
}