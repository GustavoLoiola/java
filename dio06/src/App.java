import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        while (true) {
             System.out.println("MENU PRINCIPAL");
             System.out.printf("1 - Cadastrar Pessoa / 2 - Ver Pessoas / 0 - Sair");
             int num = entrada.nextInt();
             switch (num) {
                case 1 -> {System.out.println("Digite o nome: ");
                String nome = entrada.nextLine();

                System.out.println("Digite o CPF: ");
                int cpf = entrada.nextInt();

                System.out.println("Digite a idade: ");
                int idade = entrada.nextInt();

                System.out.println("Digite a nacionalidade: ");
                String nacionalidade = entrada.nextLine();

                }
                case 2 -> System.out.println("teste2");
                case 0 -> {
                    break;
                }
                default -> System.out.println("Opção inválida!");
             }
        System.out.println("Fim do Programa.");
        }
       
        /*pessoa pessoa1 = new pessoa();
            pessoa1.idade = 3;
           
            pessoa1.cpf = 1234567;
            pessoa1.nacionalidade = "Brasil";
            pessoa1.cumprimentar(); */
        
    }
}
