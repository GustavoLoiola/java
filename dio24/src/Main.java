import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> notas = new HashMap<>();
        notas.put("João", 7.3);
        notas.put("Maria", 9.7);
        notas.put("Ana", 5.2);

        System.out.println("Alunos: ");
        for(String nome : notas.keySet()) {
            System.out.println(nome);
        }

        System.out.println("Notas: ");

        for(Double nota : notas.values()) {
            System.out.println(nota);
        }

        System.out.println("Nomes + notas: ");

        for(Map.Entry<String, Double> item : notas.entrySet() ) {
            System.out.println(item.getKey() + " -> " + item.getValue());
        }
    }
}