import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class App {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            System.out.println("Digite um nome para cadastrar: ");
            String newName = input.nextLine();
            names.add(newName);
        }

       Collections.sort(names);

        System.out.println("Digite um nome para verificar se está na lista: ");
        String searchName = input.nextLine();

        boolean nameIsTrue = false;

        for(String name : names) {
            if(name.equalsIgnoreCase(searchName)) {
                nameIsTrue = true;
                break;
            }
        }

        if(!nameIsTrue) {
            System.out.printf("%s não está na lista!%n", searchName);
        }
        else {
            System.out.printf("%s está na lista!%n", searchName);
        }

        for(String name : names) {
            System.out.println(name);
        }
    }
}