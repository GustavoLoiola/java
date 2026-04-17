import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.UserDAO;
import br.com.*;
import br.com.dio.dao.MenuOption;

public class App {

    private static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por ID");
            System.out.println("5 - Listar Todos");
            System.out.println("6 - Sair");

            var userInput = scanner.nextInt();
            scanner.nextLine(); // CORREÇÃO

            var selectedOption = MenuOption.values()[userInput - 1];

            switch (selectedOption) {

                case SAVE -> {
                    dao.save(requestToSave());
                    System.out.println("Usuário cadastrado!");
                }

                case UPDATE -> {
                    dao.update(requestToUpdate());
                    System.out.println("Usuário atualizado!");
                }

                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuário deletado!");
                }

                case FIND_BY_ID -> {
                    var id = requestId();
                    var user = dao.findById(id);
                    System.out.println("Usuário encontrado:");
                    System.out.println(user);
                }

                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados:");
                    users.forEach(System.out::println);
                }

                case EXIT -> {
                    System.out.println("Fim do programa!");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static long requestId() {
        System.out.println("Digite o ID do usuário:");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() {
        System.out.println("Digite o nome do usuário:");
        var name = scanner.nextLine(); // CORREÇÃO

        System.out.println("Digite o e-mail do usuário:");
        var email = scanner.nextLine(); // CORREÇÃO

        System.out.println("Digite a data de nascimento (dd/MM/yyyy):");
        var birthdayString = scanner.nextLine(); // CORREÇÃO

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return new UserModel(0, name, email, birthday); // CORREÇÃO
    }

    private static UserModel requestToUpdate() {
        System.out.println("Digite o ID do usuário:");
        var id = scanner.nextLong();
        scanner.nextLine(); // CORREÇÃO

        System.out.println("Digite o nome do usuário:");
        var name = scanner.nextLine(); // CORREÇÃO

        System.out.println("Digite o e-mail do usuário:");
        var email = scanner.nextLine(); // CORREÇÃO

        System.out.println("Digite a data de nascimento (dd/MM/yyyy):");
        var birthdayString = scanner.nextLine(); // CORREÇÃO

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var birthday = LocalDate.parse(birthdayString, formatter);

        return new UserModel(id, name, email, birthday);
    }
}