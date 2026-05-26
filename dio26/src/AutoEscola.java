import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class AutoEscola {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("SISTEMA DE AGENDAMENTO");

        System.out.println("Digite o nome de um aluno para agendar uma aula: ");
        String name = input.nextLine();

        System.out.println("Digite o ano em que deseja marcar a aula: ");
        int year = input.nextInt();

        System.out.println("Digite mês em que deseja marcar a aula: ");
        int month = input.nextInt();

        System.out.println("Digite o dia em que deseja marcar a aula: ");
        int day = input.nextInt();

        System.out.println("Digite o horário em que deseja marcar a aula (1hora e 30min de duração): ");
        int hour = input.nextInt();

        System.out.println("Digite o minuto em que deseja marcar a aula: ");
        int min = input.nextInt();

        LocalDate dataAula = LocalDate.of(year, month, day);
        LocalDate proxAula = dataAula.plusDays(7);

        LocalTime horaAula  = LocalTime.of(hour, min);
        LocalTime fimAula = horaAula.plusMinutes(90);

        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("---------------------------------------------");
        System.out.println("Aluno: " + name.toUpperCase());
        System.out.println("Data da aula: " + dataAula.format(formatar));
        System.out.println("Horário de início da aula: " + horaAula.format(formatarHora));
        System.out.println("Horário do fim da aula: " + fimAula.format(formatarHora));
        System.out.println("Próximo dia de aula: " + proxAula.format(formatar) );
        System.out.println("---------------------------------------------");


        input.close();
    }
}