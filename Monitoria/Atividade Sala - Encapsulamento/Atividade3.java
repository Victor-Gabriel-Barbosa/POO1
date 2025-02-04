
/** Classe que representa uma conta bancária com operações básicas */
class Conta {
  // Atributos privados para encapsulamento
  private String Nome;
  private double Saldo;

  /**
   * Construtor que inicializa uma conta vazia
   */
  public Conta() {
    Nome = "";
    Saldo = 0;
  }

  /**
   * Adiciona um valor ao saldo da conta
   *
   * @param valor Quantia a ser depositada
   */
  public void deposita(double valor) {
    if (valor > 0) {
      Saldo += valor;
    } else {
      System.out.println("Valor inválido para depósito!");
    }
  }

  /**
   * Aplica rendimento ao saldo atual
   *
   * @param valor Taxa de rendimento (em decimal)
   */
  public void rendimento(double valor) {
    Saldo += Saldo * valor;
  }

  /**
   * Realiza saque se houver saldo suficiente
   *
   * @param valor Quantia a ser sacada
   */
  public void saque(double valor) {
    if (Saldo >= valor) {
      Saldo -= valor;
    } else {
      System.out.println("Saldo insuficiente.");
    }
  }

  // Métodos getters e setters
  public String getNome() {
    return Nome;
  }

  public double getSaldo() {
    return Saldo;
  }

  public void setNome(String Nome) {
    if (Nome != null && !Nome.isEmpty()) {
      this.Nome = Nome;
    } else {
      System.out.println("Nome inválido!");
    }
  }

  public void setSaldo(double Saldo) {
    if (Saldo >= 0) {
      this.Saldo = Saldo;
    } else {
      System.out.println("Saldo inválido!");
    }
  }
}

/**
 * Classe principal que demonstra operações bancárias básicas
 */
public class Atividade3 {
  public static void main(String[] args) {
    // Criação e operações da primeira conta
    Conta c1 = new Conta();
    c1.setNome("Alice");
    c1.deposita(1000);
    c1.rendimento(0.05);
    System.out.println("Nome: " + c1.getNome());
    System.out.println("Saldo: $" + c1.getSaldo());

    // Criação e operações da segunda conta
    Conta c2 = new Conta();
    c2.setNome("Bob");
    c2.deposita(2000);
    c2.rendimento(0.05);
    System.out.println("Nome: " + c2.getNome());
    System.out.println("Saldo: $" + c2.getSaldo());

    // Demonstração de saques
    c1.saque(500);
    System.out.println("Nome: " + c1.getNome());
    System.out.println("Saldo: $" + c1.getSaldo());

    c2.saque(1500);
    System.out.println("Nome: " + c2.getNome());
    System.out.println("Saldo: $" + c2.getSaldo());

    // Cálculo e exibição do saldo total das contas
    System.out.println("Total de saldos: \n$" + (c1.getSaldo() + "\n$" + c2.getSaldo()));
  }
}