import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       int[]numeros = {10,30,11,45,0,-1,234};
       int maior = numeros[0];
       for(int i=1; i < numeros.length; i++) {
          if(numeros[i] > maior) {
              maior = numeros[i];
          }
       }
       System.out.printf("O maior número da lista é: %d", maior);
    }
}