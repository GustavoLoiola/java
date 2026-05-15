import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
       ArrayList<String> Nomes = new ArrayList<>();
       Nomes.add("Gustavo");
       Nomes.add("Carlos");
       Nomes.add("Ana");
       Nomes.add("Julia");
       Nomes.add("Marcelo");

        System.out.println("Tamanho do Array: " + Nomes.size());

        for(String nome : Nomes) {
            System.out.println(nome);
        }

        System.out.println("Existe Ana?");

        boolean anaExists = false;

        for(String nome : Nomes) {
          if(nome.equalsIgnoreCase("Ana")) {
              anaExists = true;
              break;
          }
        }

        System.out.println("Ana está na lista? " + anaExists);

        Nomes.remove("Gustavo");

        Collections.sort(Nomes);

        System.out.println("Lista Ordenada: ");

        for(String nome : Nomes) {
            System.out.println(nome);
        }
    }
}