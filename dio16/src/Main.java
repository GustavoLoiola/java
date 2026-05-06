public class Main {
    public static void main(String[] args) {
        ContaPoupanca poup1 = new ContaPoupanca();
        poup1.exibirSaldo();
        poup1.setSaldo(2000);
        poup1.sacar(560);
        poup1.exibirSaldo();

        ContaCorrente corr1 = new ContaCorrente();
        corr1.exibirSaldo();
        corr1.setSaldo(2000);
        corr1.sacar(560);
        corr1.exibirSaldo();
    }
}