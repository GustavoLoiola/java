import java.util.Scanner;
import java.util.ArrayList;

public class App {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Pessoa> pessoas = new ArrayList<>();
    public static void main(String[] args) {

        Menu();
       
        System.out.println("Fim do Programa.");
        entrada.close();
    }

        public static void Cadastrar() {

            entrada.nextLine();

            System.out.println("Digite o nome: ");
            String nomeCadastro = entrada.nextLine();

            System.out.println("Digite a idade: ");
            int idadeCadastro = entrada.nextInt();

            entrada.nextLine();

            System.out.println("Digite o CPF: ");
            String cpfCadastro = entrada.nextLine();


            System.out.println("Digite a nacionalidade: ");
            String nacionalidadeCadastro = entrada.nextLine();

            Pessoa pessoa = new Pessoa(nomeCadastro, idadeCadastro, cpfCadastro, nacionalidadeCadastro);

            pessoas.add(pessoa);

            System.out.println("Pessoa Cadastrada!");
        }

        public static void Exibir() {
           if(pessoas.isEmpty()) {
                System.out.println("Não existem usuários cadastrados!");
           }
           else {
                for(Pessoa i : pessoas) {
                    i.mostrarDados();
                    System.out.println("-------------------------------------------------------");
                }
           }
        }


         public static void Menu() {
            while (true) {
                System.out.println("MENU PRINCIPAL");
            
                System.out.println("1 - Cadastrar Pessoa / 2 - Ver Pessoas / 0 - Sair");
                int num = entrada.nextInt();

                
                switch (num) {
                    case 1 -> Cadastrar();
                    case 2 -> Exibir();
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
             }
            }
        }
}
