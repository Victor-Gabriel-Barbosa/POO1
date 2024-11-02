import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        ZoneId fusoHorarioPadraoAntes = ZoneId.systemDefault();
        String novoFusoHorarioPadrao = "Asia/Tokyo";
        System.setProperty("user.timezone", novoFusoHorarioPadrao);
        ZoneId fusoHorarioPadraoDepois = ZoneId.systemDefault();
        
        ZonedDateTime dataHoraConvertida = dataHoraAtual.atZone(fusoHorarioPadraoDepois);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");
        String dataHoraFormatada = dataHoraConvertida.format(formatter);

        System.out.println("Data e hora convertida: " + dataHoraFormatada);
    }
}
