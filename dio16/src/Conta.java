public class Conta {
    private double saldo;

    public  void sacar(double valor) {
        saldo -= valor;
    }

    public  void depositar(double valor) {
        saldo += valor;
    }

    //GET e SET

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void exibirSaldo() {
        System.out.printf("Seu saldo atual é de: R$%.2f%n", getSaldo());
    }

}

class ContaPoupanca extends Conta {

    @Override
    public void sacar(double valor) {
        double saldo = getSaldo();
        if(valor > 0 && getSaldo() >= valor) {
            setSaldo(saldo -= valor);
            System.out.println("Valor sacado com sucesso!");
        }
            else {
            System.out.println("Não é possível sacar esse valor!");
            }
    }
}
class ContaCorrente extends Conta {

    @Override
    public void sacar(double valor) {
        double saldo = getSaldo();
        double taxa = valor * 0.01;
        double total = valor + taxa;

        if(getSaldo() >= total && total > 0) {
            setSaldo(saldo -= total);
            System.out.printf("R$%.2f sacados com sucesso!%n", total);
        }
        else {
            System.out.println("Não é possível sacar esse valor!");
        }
    }
}