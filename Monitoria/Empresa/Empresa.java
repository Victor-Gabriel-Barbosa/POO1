// Classe abstrata base para todos os funcionários
abstract class Funcionario {
  private String nome;
  private String codigoFuncional;
  protected final double RENDA_BASICA = 1000.00;

  public Funcionario(String nome, String codigoFuncional) {
    this.nome = nome;
    this.codigoFuncional = codigoFuncional;
  }

  public String getNome() {
    return nome;
  }

  public String getCodigoFuncional() {
    return codigoFuncional;
  }

  public abstract double calcularRendaTotal();

  public abstract String getNivelEscolaridade();

  public abstract String getInfoEscolar();
}

// Funcionário que não estudou
class FuncionarioSemEstudo extends Funcionario {
  public FuncionarioSemEstudo(String nome, String codigoFuncional) {
    super(nome, codigoFuncional);
  }

  @Override
  public double calcularRendaTotal() {
    return RENDA_BASICA;
  }

  @Override
  public String getNivelEscolaridade() {
    return "Sem escolaridade formal";
  }

  @Override
  public String getInfoEscolar() {
    return "Nenhuma informação escolar registrada";
  }
}

// Funcionário com ensino básico
class FuncionarioEnsinoBasico extends Funcionario {
  private String escola;

  public FuncionarioEnsinoBasico(String nome, String codigoFuncional, String escola) {
    super(nome, codigoFuncional);
    this.escola = escola;
  }

  @Override
  public double calcularRendaTotal() {
    return RENDA_BASICA * 1.10; // Acréscimo de 10%
  }

  @Override
  public String getNivelEscolaridade() {
    return "Ensino Básico";
  }

  @Override
  public String getInfoEscolar() {
    return "Escola de Ensino Básico: " + escola;
  }
}

// Funcionário com ensino médio
class FuncionarioEnsinoMedio extends Funcionario {
  private String escola;

  public FuncionarioEnsinoMedio(String nome, String codigoFuncional, String escola) {
    super(nome, codigoFuncional);
    this.escola = escola;
  }

  @Override
  public double calcularRendaTotal() {
    return RENDA_BASICA * 1.50; // Acréscimo de 50%
  }

  @Override
  public String getNivelEscolaridade() {
    return "Ensino Médio";
  }

  @Override
  public String getInfoEscolar() {
    return "Escola de Ensino Médio: " + escola;
  }
}

// Funcionário com graduação
class FuncionarioGraduado extends Funcionario {
  private String universidade;
  private String curso;

  public FuncionarioGraduado(String nome, String codigoFuncional, String universidade, String curso) {
    super(nome, codigoFuncional);
    this.universidade = universidade;
    this.curso = curso;
  }

  @Override
  public double calcularRendaTotal() {
    return RENDA_BASICA * 2.00; // Acréscimo de 100%
  }

  @Override
  public String getNivelEscolaridade() {
    return "Graduação";
  }

  @Override
  public String getInfoEscolar() {
    return "Universidade: " + universidade + ", Curso: " + curso;
  }
}

// Classe principal que contém o método main
public class Empresa {
  public static void main(String[] args) {
    // Criando um array de 10 funcionários
    Funcionario[] funcionarios = new Funcionario[10];

    // Inicializando alguns funcionários com diferentes níveis de escolaridade
    funcionarios[0] = new FuncionarioSemEstudo("João Silva", "F001");
    funcionarios[1] = new FuncionarioEnsinoBasico("Maria Oliveira", "F002", "Escola Municipal Aurora");
    funcionarios[2] = new FuncionarioEnsinoMedio("Pedro Santos", "F003", "Colégio Estadual Progresso");
    funcionarios[3] = new FuncionarioGraduado("Ana Pereira", "F004", "Universidade Federal", "Administração");
    funcionarios[4] = new FuncionarioSemEstudo("Carlos Souza", "F005");
    funcionarios[5] = new FuncionarioEnsinoBasico("Fernanda Lima", "F006", "Escola Fundamental Novos Caminhos");
    funcionarios[6] = new FuncionarioEnsinoMedio("Ricardo Alves", "F007", "Escola Técnica Industrial");
    funcionarios[7] = new FuncionarioGraduado("Julia Costa", "F008", "Universidade Estadual", "Engenharia");
    funcionarios[8] = new FuncionarioEnsinoMedio("Marcos Ferreira", "F009", "Colégio Dom Pedro");
    funcionarios[9] = new FuncionarioGraduado("Patricia Ribeiro", "F010", "Universidade Tecnológica",
        "Sistemas de Informação");

    // Gerando relatório
    gerarRelatorio(funcionarios);
  }

  public static void gerarRelatorio(Funcionario[] funcionarios) {
    System.out.println("=== RELATÓRIO DE FUNCIONÁRIOS ===\n");

    double custoTotalSalarios = 0;
    double custoSemEstudo = 0;
    double custoEnsinoBasico = 0;
    double custoEnsinoMedio = 0;
    double custoGraduacao = 0;
    int countSemEstudo = 0;
    int countEnsinoBasico = 0;
    int countEnsinoMedio = 0;
    int countGraduacao = 0;

    // Listando todos os funcionários
    for (Funcionario f : funcionarios) {
      System.out.println("Código: " + f.getCodigoFuncional());
      System.out.println("Nome: " + f.getNome());
      System.out.println("Nível de Escolaridade: " + f.getNivelEscolaridade());
      System.out.println("Informação Escolar: " + f.getInfoEscolar());
      System.out.printf("Salário: R$ %.2f\n", f.calcularRendaTotal());
      System.out.println("------------------------------");

      // Calculando custos
      double salario = f.calcularRendaTotal();
      custoTotalSalarios += salario;

      // Contabilizando por nível de escolaridade
      if (f instanceof FuncionarioSemEstudo) {
        custoSemEstudo += salario;
        countSemEstudo++;
      } else if (f instanceof FuncionarioEnsinoBasico) {
        custoEnsinoBasico += salario;
        countEnsinoBasico++;
      } else if (f instanceof FuncionarioEnsinoMedio) {
        custoEnsinoMedio += salario;
        countEnsinoMedio++;
      } else if (f instanceof FuncionarioGraduado) {
        custoGraduacao += salario;
        countGraduacao++;
      }
    }

    // Resumo financeiro
    System.out.println("\n=== RESUMO FINANCEIRO ===");
    System.out.printf("Custo total com salários: R$ %.2f\n", custoTotalSalarios);
    System.out.println("\nCustos por nível de escolaridade:");
    System.out.printf("- Sem escolaridade formal (%d funcionários): R$ %.2f\n", countSemEstudo, custoSemEstudo);
    System.out.printf("- Ensino Básico (%d funcionários): R$ %.2f\n", countEnsinoBasico, custoEnsinoBasico);
    System.out.printf("- Ensino Médio (%d funcionários): R$ %.2f\n", countEnsinoMedio, custoEnsinoMedio);
    System.out.printf("- Graduação (%d funcionários): R$ %.2f\n", countGraduacao, custoGraduacao);
  }
}
