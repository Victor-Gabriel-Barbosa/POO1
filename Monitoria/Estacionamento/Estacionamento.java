import java.util.Scanner;

public class Estacionamento {
  private int chapa;
  private String marca;
  private Tempo tempoEntrada = new Tempo();
  private Tempo tempoSaida = new Tempo();

  // A)
  public void entradaEstacionamento() {
    Scanner entrada = new Scanner(System.in);
    System.out.print("Digite o número da chapa do carro: ");
    chapa = entrada.nextInt();

    System.out.print("Digite o número da chapa do carro: ");
    marca = entrada.nextLine();

    System.out.print("Digite a hora de entrada: ");
    tempoEntrada.setHora(entrada.nextInt());

    System.out.print("Digite os minutos de entrada: ");
    tempoEntrada.setMin(entrada.nextInt());

    System.out.print("Digite os segundos de entrada: ");
    tempoEntrada.setSeg(entrada.nextInt());

    System.out.print("Digite a hora de saída: ");
    tempoSaida.setHora(entrada.nextInt());

    System.out.print("Digite os minutos de saída: ");
    tempoSaida.setMin(entrada.nextInt());

    System.out.print("Digite os segundos de saída: ");
    tempoSaida.setSeg(entrada.nextInt());
  }

  // B)

  public void imprimeCarro() {
    System.out.println("Número da chapa: " + chapa);
    System.out.println("Marca: " + marca);

    System.out.println("Hora de entrada:");
    tempoEntrada.imprimir();

    System.out.println("Hora de saída:");
    tempoSaida.imprimir();
  }

  // C)
  public double cobranca() {
    Tempo tempoTotal = new Tempo();
    tempoTotal = tempoSaida.subtrai(tempoEntrada);
    double totalValor = tempoTotal.getHora() * 3;
    return totalValor;
  }

  public void imprimeCobranca() {
    System.out.println("Valor total cobrado: R$" + cobranca());
  }
}