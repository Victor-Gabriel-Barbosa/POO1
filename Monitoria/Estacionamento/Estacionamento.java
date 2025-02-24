import java.util.Scanner;

public class Estacionamento {
  private int chapa;
  private String marca;
  private final Tempo tempoEntrada = new Tempo();
  private final Tempo tempoSaida = new Tempo();

  // A)
  public void entradaEstacionamento() {
    Scanner entrada = new Scanner(System.in);

    System.out.print("Digite o número da chapa do carro: ");
    chapa = Integer.parseInt(entrada.nextLine());

    System.out.print("Digite a marca do carro: ");
    marca = entrada.nextLine();

    System.out.print("Digite a hora de entrada: ");
    tempoEntrada.setHora(Integer.parseInt(entrada.nextLine()));

    System.out.print("Digite os minutos de entrada: ");
    tempoEntrada.setMin(Integer.parseInt(entrada.nextLine()));

    System.out.print("Digite os segundos de entrada: ");
    tempoEntrada.setSeg(Integer.parseInt(entrada.nextLine()));

    System.out.print("Digite a hora de saída: ");
    tempoSaida.setHora(Integer.parseInt(entrada.nextLine()));

    System.out.print("Digite os minutos de saída: ");
    tempoSaida.setMin(Integer.parseInt(entrada.nextLine()));

    System.out.print("Digite os segundos de saída: ");
    tempoSaida.setSeg(Integer.parseInt(entrada.nextLine()));

    entrada.close();
  }

  // B)

  public void imprimeCarro() {
    System.out.println("--- Dados do carro ---");
    System.out.println("Número da chapa: " + chapa);
    System.out.println("Marca: " + marca);

    System.out.println("--- Hora de entrada ---");
    tempoEntrada.imprimir();

    System.out.println("--- Hora de saída ---");
    tempoSaida.imprimir();
  }

  // C)
  public double cobranca() {
    return tempoSaida.subtrai(tempoEntrada).getHora() * 3;
  }

  public void imprimeCobranca() {
    System.out.println("Valor total cobrado: R$" + cobranca());
  }
}