import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("cadastro de produtos");

        StringBuilder produtos = new StringBuilder();

        for(int i = 1; i <= 5; i++) {
            System.out.printf("Produto %d: %n", i);
            String novoProduto= input.nextLine();
            produtos.append(novoProduto);
            produtos.append(" | ");

        }

        System.out.println("Produtos encontrados: " + produtos);

        StringBuilder inverso = new StringBuilder(produtos);

        System.out.println("Lista ao contrário: " + inverso.reverse());

        String textoLimpo = produtos.toString().replace(" ", "").replace("|", "");

        System.out.println("Quantidade de caractéres: " + textoLimpo.length());
    }
}