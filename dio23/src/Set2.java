import java.util.*;

public class Set2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while(true) {
            System.out.println("Digite um número: ");
            int newNumber = input.nextInt();
            numbers.add(newNumber);
            input.nextLine();
            System.out.println("Digite X para parar ou qualquer letra para continuar: ");
            String quest = input.nextLine();
            if(quest.equalsIgnoreCase("x")) {
                break;
            }
        }

        Set<Integer >setNumbers = new TreeSet<>(numbers);

        Set<Integer> uniqueNumbers = new HashSet<>();

        for(int num : numbers) {
            uniqueNumbers.add(num);
        }

       for(int num : setNumbers) {
           System.out.println(num);
       }

       System.out.println("Números únicos: ");
       for(int num : uniqueNumbers) {
           System.out.println(num);
       }

        System.out.printf("Quantidade de números únicos: %s%n", setNumbers.size());
    }
}