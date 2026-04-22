import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.Arrays;

public class Anagrama {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("TESTE DE ANAGRAMA");

        System.out.println("Digite a primeira palavra para ver se ela é um anagrama: ");
        String palavra1 = entrada.nextLine();

        System.out.println("Digite a segunda palavra: ");
        String palavra2 = entrada.nextLine();

        if(palavra1.length() != palavra2.length()) {
            System.out.println("Não é um anagrama e não possui a mesma quantidade de caracteres!");
            return ;
        }
        else {
            char[] a = palavra1.toLowerCase().replaceAll("\\s", "").toCharArray();
            char[] b = palavra2.toLowerCase().replaceAll("\\s", "").toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if(Arrays.equals(a,b)) {
                System.out.println("As palavras são anagramas!");
            }
            else {
                System.out.println("Não é um anagrama!");
            }
        }

    }
}