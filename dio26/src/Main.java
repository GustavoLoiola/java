import java.util.*;
import java.util.stream.Collectors;

/* Crie um sistema que:
    1 - peça 10 nomes ao usuário
    2 - remova nomes repetidos
    3 - ordene alfabeticamente
    4 - transforme em maiúsculo
    5 - mostre apenas nomes com mais de 4 letras
    6 - salve em uma nova lista
    7 - mostre o resultado final */

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            System.out.println("Digite o nome de um usuário: ");
            String newName = input.nextLine();
            names.add(newName);
        }

        List<String> newList =
                names.stream()
                .sorted()
                .distinct()
                .filter(nome -> nome.length() > 4)
                .map(nome -> nome.toUpperCase())
                .collect(Collectors.toList());

        newList.stream()
                .forEach(System.out::println);
    }
}