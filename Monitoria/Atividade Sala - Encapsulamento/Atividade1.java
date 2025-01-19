/**
 * Classe que representa um funcionário com atributos básicos e gerenciamento de salário
 */
class Funcionario {
  // Atributos privados para encapsulamento dos dados
  private String nome;
  private double salario;
  private String secao;

  // Construtor padrão - inicializa com valores vazios
  Funcionario() {
    nome = "";
    salario = 0;
    secao = "";
  }

  // Construtor completo com todos os atributos
  Funcionario(String nome, double salario, String secao) {
    this.nome = nome;
    this.salario = salario;
    this.secao = secao;
  }

  // Construtor parcial - sem seção
  Funcionario(String nome, double salario) {
    this.nome = nome;
    this.salario = salario;
    this.secao = "";
  }

  // Construtor parcial - apenas nome
  Funcionario(String nome) {
    this.nome = nome;
    this.salario = 0;
    this.secao = "";
  }

  /**
   * Aumenta o salário em 10%
   */
  public void bonificacao() {
    salario += 0.1 * salario;
  }

  // Métodos getters e setters para acesso controlado aos atributos
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getSecao() {
    return secao;
  }
  
  public void setSecao(String secao) {
    this.secao = secao;
  }
}

public class Atividade1 {
  public static void main(String[] args) {
    // Teste com diferentes construtores e exibição dos dados
    // Funcionário com nome e salário
    Funcionario f1 = new Funcionario("João", 1000.00);
    f1.bonificacao();
    System.out.println("Nome: " + f1.getNome());
    System.out.println("Salário: " + f1.getSalario());
    System.out.println("Secção: " + f1.getSecao());

    // Funcionário com todos os dados
    Funcionario f2 = new Funcionario("Maria", 2000.00, "RH");
    f2.bonificacao();
    System.out.println("Nome: " + f2.getNome());
    System.out.println("Salário: " + f2.getSalario());
    System.out.println("Secção: " + f2.getSecao());

    // Funcionário apenas com nome
    Funcionario f3 = new Funcionario("José");
    f3.bonificacao();
    System.out.println("Nome: " + f3.getNome());
    System.out.println("Salário: " + f3.getSalario());
    System.out.println("Secção: " + f3.getSecao());

    // Funcionário sem dados iniciais
    Funcionario f4 = new Funcionario();
    f4.bonificacao();
    System.out.println("Nome: " + f4.getNome());
    System.out.println("Salário: " + f4.getSalario());
    System.out.println("Secção: " + f4.getSecao());

    // Alteração de dados
    f4.setNome("Ana");
    f4.setSalario(1500.00);
    f4.setSecao("TI");
    f4.bonificacao();
    System.out.println("Nome: " + f4.getNome());
    System.out.println("Salário: " + f4.getSalario());
    System.out.println("Secção: " + f4.getSecao());
  }
}