import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        int num = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.println("---CADASTRO DE USUÁRIOS---");

        while(true) {
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Ver usuarios");
            System.out.println("3 - Sair");
            int opc = entrada.nextInt();
            entrada.nextLine();

            if (opc == 1) {
                Usuario usuario = new Usuario();

                System.out.println("Digite o nome do Usuário: ");
                String nome = entrada.nextLine();

                 if (nome.length()< 2) {
                    System.out.println("Nome inválido! O nome deve conter pelo menos 2 caracteres.");
                }

                usuario.setNome(nome);

                System.out.println("Digite a idade do Usuário: ");
                int idade = entrada.nextInt();

                if (idade > 130 || idade < 0) {
                    System.out.println("Idáde inválida! Por favor tente novamente!");
                }

                entrada.nextLine();
                usuario.setIdade(idade);

                System.out.println("Digite o email do Usuário: ");
                String email = entrada.nextLine();

                if (!email.contains("@") || !email.contains(".")) {
                    System.out.println("O email digitado não corresponde a um email válido! Tente novamente");
                }

                usuario.setEmail(email);

                usuarios.add(usuario);
                System.out.printf("Usuário %s cadastrado com sucesso!%n", usuario.getNome());
            }
            else if (opc == 2) {
               System.out.println("===============================");
               for(Usuario u : usuarios) {
                   System.out.printf("Nome: %s%n", u.getNome());
                   System.out.printf("Idade: %d%n", u.getIdade());
                   System.out.printf("Email: %s%n", u.getEmail());
                   System.out.println("===============================");
               }

            }
            else if (opc == 3) {
              break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Fim do programa!");
        entrada.close();
    }
}