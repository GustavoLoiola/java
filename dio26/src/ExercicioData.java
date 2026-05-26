import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ExercicioData {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do evento: ");
        String evento = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Digite a data do evento: ");
        String data = input.nextLine();

        LocalDate dataEvento = LocalDate.parse(data, formatter);

        LocalDate hoje = LocalDate.now();

        long days = ChronoUnit.DAYS.between(hoje, dataEvento);

        System.out.println("Evento: " + evento);
        System.out.println("Faltam " + days + " dias até o evento!");

        input.close();
    }
}