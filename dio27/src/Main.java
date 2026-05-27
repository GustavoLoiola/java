public class Main {
    public static void main(String[] args) {
        Runnable testeNum = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread tLet = new Thread(() -> {
           for(char c = 'A'; c <=  'J'; c++ ) {
               System.out.println(c);
           }
        });

        Thread tNum = new Thread(testeNum);

        tNum.start();
        tLet.start();
    }
}