public class App {
    public static void main(String[] args) {
       var num1 = 6;
       var num2 = 7;

       var num1Bin = Integer.toBinaryString(num1);
       var num2Bin = Integer.toBinaryString(num2);

       var soma = num1 + num2;
       var somaBin = Integer.toBinaryString(soma);

       var or = num1 | num2;
       var orBin = Integer.toBinaryString(or);

       System.out.printf("Número: %d / Binário: %s%n", num1, num1Bin);
       System.out.printf("Número: %d / Binário: %s%n", num2, num2Bin);

       System.out.printf("%d + %d = %d (bin: %s)%n", num1, num2, soma, somaBin);

       System.out.printf("%d | %d = %d (bin: %s)%n", num1, num2, or, orBin);
    }
}