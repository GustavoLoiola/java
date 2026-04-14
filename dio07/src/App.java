import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import br.UserDAO;
import br.com.UserModel;
import br.com.dio.dao.MenuOption;;

public class App {

    private static UserDAO dao = new UserDAO();
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       System.out.println("Menu Principal!");
       System.out.println("1 - Cadastrar");
       System.out.println("2 - Atualizar");
       System.out.println("3 - Excluir");
       System.out.println("4 - Buscar por ID");
       System.out.println("5 - Listar Todos");
       System.out.println("6 - Sair");
       var userInput = scanner.nextInt();
       Runnable runnable = () -> System.out.println("test");

       while(true) {
        var selectedOption = MenuOption.values()[userInput -1];
        switch (selectedOption) {
            case SAVE -> {
                var user = requestUserInfo();
            }
        }
        
       }
    }

    private static UserModel requestUserInfo() {
        System.out.println("Digite o nome do usuário: ");
        var name = scanner.next();
        System.out.println("Digite o E-mail do usuário: ");
        var email = scanner.next();
        System.out.println("Digite a data de nascimento do usuário (dd/mm/yyyy): ");
        var birthdayString = scanner.next();
        var formatter = new DateTimeFormatter.ofPattern("dd/mm/yyyy");
        var birthday = OffsetDateTime.parse(birthdayString, formatter);
        return new UserModel(0, name, email, birthday );
    }
}
