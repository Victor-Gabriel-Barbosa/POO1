public class AppEstacionamento {
  public static void main(String[] args) {
    Estacionamento[] estacionamento = new Estacionamento[5];

    // Inicializar cada elemento do array
    for (int i = 0; i < estacionamento.length; i++) {
      estacionamento[i] = new Estacionamento();
    }

    System.out.println("----- Estacionamento -----");
    for (Estacionamento estaciona : estacionamento) {
      estaciona.entradaEstacionamento();
    }

    System.out.println("----- Relatório -----");
    for (Estacionamento estaciona : estacionamento) {
      estaciona.imprimeCobranca();
    }
  }
}