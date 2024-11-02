import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();
        LocalTime horaAtual = LocalTime.now();
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataHoraAtual.format(formatter);

        LocalDate dataFutura = dataAtual.plusDays(7);
        LocalDate dataPassada = dataAtual.minusMonths(1);

        LocalTime horaFutura = horaAtual.plusHours(2);
        LocalTime horaPassada = horaAtual.minusMinutes(30);

        System.out.println("Data e hora atual formatada: " + dataHoraFormatada);
        System.out.println("Data futura (+7 dias): " + dataFutura);
        System.out.println("Data passada (-1 mês): " + dataPassada);
        System.out.println("Hora futura (+2 horas): " + horaFutura);
        System.out.println("Hora passada (-30 minutos): " + horaPassada);
    }
}
