public class gravarRegistros {
  private int conta;
  private String nome;
  private double saldo;

  // Construtor sem parâmetros
  public gravarRegistros() {
    this(0, "", 0.0);
  }

  // Construtor com todos os parâmetros
  public gravarRegistros(int conta, String nome, double saldo) {
    this.conta = conta;
    this.nome = nome;
    this.saldo = saldo;
  }

  // Getters e setters
  public int getConta() {
    return conta;
  }

  public void setConta(int conta) {
    this.conta = conta;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }
}