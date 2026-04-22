import com.gustavoloiola.UserTest;

public class App {
    public static void main(String[] args) {
        UserTest test = new UserTest();
        test.setNome("Gustavo");

        System.out.println(test.getNome());
    }
}
