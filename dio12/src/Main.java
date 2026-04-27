import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person male = new Person();
        male.setName("João");
        male.setAge(12);
        Person female = new Person();
        female.setName("Maria");
        female.setAge(10);

        System.out.printf("Male name: %s | Male age: %d", male.getName(), male.getAge());
    }
}