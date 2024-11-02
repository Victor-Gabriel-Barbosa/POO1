import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    String s = "2";
    int x = Integer.parseInt(s);
    double d = Double.parseDouble("420.24");
    boolean b = new Boolean("true").booleanValue();
    System.out.println(s + " " + x + " " + d + " " + b);
    
    System.out.println(String.format("%,d", 10000000));
    System.out.println(String.format("Tenho %.2f bugs para corrigir", 476578.09876));
    System.out.println(String.format("Ele tem %,.2f bugs para corrigir", 476578.09876));
    System.out.println(String.format("Teste: %,6.1f", 4275.0000));
    System.out.println(String.format("Octal: %o", 42759878));
    System.out.println(String.format("Hexadecimal: %x", 42759878));
    System.out.println(String.format("Caracter: %c", 12));
    System.out.println(String.format("A classificação é %1$,d", 12));
    
    Date today = new Date();
    
    System.out.println(String.format("Datas %tA, %tB, %td: ", today, today, today));

    // Formato completo com dia da semana
    SimpleDateFormat fullFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
    System.out.println("Formato completo: " + fullFormat.format(today));

    // Apenas data
    SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("dd/MM/yyyy");
    System.out.println("Data (dd/MM/yyyy): " + dateOnlyFormat.format(today));

    // Data em formato abreviado
    SimpleDateFormat shortDateFormat = new SimpleDateFormat("MM/dd/yy");
    System.out.println("Data abreviada (MM/dd/yy): " + shortDateFormat.format(today));

    // Apenas hora
    SimpleDateFormat timeOnlyFormat = new SimpleDateFormat("HH:mm:ss");
    System.out.println("Hora (HH:mm:ss): " + timeOnlyFormat.format(today));

    // Data e hora com padrão ISO 8601
    SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    System.out.println("Formato ISO 8601: " + isoFormat.format(today));

    // Dia da semana, dia do mês e ano
    SimpleDateFormat dayMonthYearFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
    System.out.println("Dia da semana, dia e ano: " + dayMonthYearFormat.format(today));
    
    System.out.println();
    // Obtém a instância atual de Calendar
    Calendar calendar = Calendar.getInstance();
    calendar.set(1956, 0, 7, 15, 100);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // Data e hora atuais
    System.out.println("Data e hora atuais: " + sdf.format(calendar.getTime()));
    
    calendar.add(calendar.DATE, 35);
    System.out.println("Teste: " + sdf.format(calendar.getTime()));
    
    calendar.roll(calendar.DATE, 35);
    System.out.println("Teste22: " + sdf.format(calendar.getTime()));

    // Adicionar dias
    calendar.add(Calendar.DAY_OF_MONTH, 5);
    System.out.println("Data após adicionar 5 dias: " + sdf.format(calendar.getTime()));

    // Subtrair meses
    calendar.add(Calendar.MONTH, -2);
    System.out.println("Data após subtrair 2 meses: " + sdf.format(calendar.getTime()));

    // Definir uma data específica (Ex: 25 de dezembro de 2024)
    calendar.set(Calendar.YEAR, 2024);
    calendar.set(Calendar.MONTH, Calendar.DECEMBER);
    calendar.set(Calendar.DAY_OF_MONTH, 25);
    System.out.println("Data definida para: " + sdf.format(calendar.getTime()));

    // Verificar o dia da semana (Ex: dia da semana de 25 de dezembro de 2024)
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    System.out.println("Dia da semana para 25/12/2024: " + dayOfWeek); // 1=Domingo, 2=Segunda, etc.

    // Ajustar hora, minuto e segundo
    calendar.set(Calendar.HOUR_OF_DAY, 15);  // 15 horas (3 PM)
    calendar.set(Calendar.MINUTE, 30);
    calendar.set(Calendar.SECOND, 45);
    System.out.println("Data e hora ajustadas: " + sdf.format(calendar.getTime()));

    // Resetar a data para hoje
    calendar = Calendar.getInstance();
    System.out.println("Data resetada para agora: " + sdf.format(calendar.getTime()));

    // Verificar o último dia do mês atual
    int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    System.out.println("Último dia do mês atual: " + lastDayOfMonth);
    
  }
}
