import java.util.*;

public class Opcional {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> users = new ArrayList<>();

        System.out.println("CADASTRO DE USUÁRIOS");

        while (true) {
            System.out.println("(X para parar) Digite o nome do usuário que deseja cadastrar: ");
            String user = input.nextLine();

            if("X".equals(user.toUpperCase())) {
                break;
            }

            users.add(user);
        }

        System.out.println("Digite um nome para verificar se ele está na lista: ");

        String name = input.nextLine();

        Optional<String> userFind =
                users.stream()
                        .filter(u -> u.equalsIgnoreCase(name))
                        .findFirst();

        System.out.println(userFind.orElse("Usuário não encontrado!"));
    }
}
