class Conta {
    int saldo = 0;

    public synchronized void depositar(int valor) {
        saldo = saldo + valor;
    }
}