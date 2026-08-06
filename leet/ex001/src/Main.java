import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Map<Character, Integer> romano = new HashMap<>();

        romano.put('I', 1);
        romano.put('V', 5);
        romano.put('X', 10);
        romano.put('L', 50);
        romano.put('C', 100);
        romano.put('D', 500);
        romano.put('M', 1000);

        System.out.print("Digite um número romano: ");
        String numeroRomano = input.nextLine().toUpperCase();

        int resultado = 0;

        for(int i = 0; i < numeroRomano.length(); i++) {

            int valorAtual = romano.get(numeroRomano.charAt(i));

            if(i < numeroRomano.length() - 1) {

                int proximoValor = romano.get(numeroRomano.charAt(i + 1));

                if (valorAtual < proximoValor) {
                    resultado -= valorAtual;
                }
                else {
                    resultado += valorAtual;
                }

            }
            else {
                resultado += valorAtual;
            }
        }

        System.out.println("Resultado: " + resultado);

        input.close();
    }
}