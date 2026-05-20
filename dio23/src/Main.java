import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Gustavo");
        names.add("Gusttavo");
        names.add("Carlos");
        names.add("Giovana");
        names.add("Gustavo");
        names.add("Rebeca");
        names.add("Rebeca");
        names.add("Ana");

        Set<String>uniqueNames = new HashSet<>(names);
        for(String name : uniqueNames) {
            System.out.println(name);
        }
    }
}