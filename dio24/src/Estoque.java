import java.util.*;

public class Estoque {
    public static void main(String[] args) {
        System.out.println("Sistema de estoque!");
        Scanner input = new Scanner(System.in);

        Map<String, Integer> produtos = new HashMap<>();
        produtos.put("camiseta", 15);
        produtos.put("calça moletom", 8);
        produtos.put("cropped oversized", 52);

        System.out.println("Digite o nome de um produto para verificar a disponibilidade dele no estoque: ");
        String produto = input.nextLine();
        produto = produto.toLowerCase();

        if(produtos.containsKey(produto)) {
            System.out.printf("%s: %d unidades%n", produto, produtos.get(produto));
        }
        else {
            System.out.println("Produto não encontrado.");
        }
    }
}