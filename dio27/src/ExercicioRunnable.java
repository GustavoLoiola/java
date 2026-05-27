public class ExercicioRunnable {
    public static void main(String[] args) throws InterruptedException {

        Conta conta = new Conta();

        Runnable deposito = () -> {
            for (int i = 0; i < 100000; i++) {
                conta.depositar(1);
            }
        };

        Thread t1 = new Thread(deposito);
        Thread t2 = new Thread(deposito);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Saldo final: " + conta.saldo);
    }
}