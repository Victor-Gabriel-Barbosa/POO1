/**
 * Classe que representa um número complexo na forma a + bi
 * onde 'a' é a parte real e 'b' é a parte imaginária
 */
class NComplexo {
  private double real, img;

  // Construtor padrão - inicializa com zero
  public NComplexo() {
    this.real = 0;
    this.img = 0;
  }

  /** 
   * Construtor com parâmetros
   * @param real Parte real do número complexo
   * @param img Parte imaginária do número complexo
   */
  public NComplexo(double real, double img) {
    this.real = real;
    this.img = img;
  }

  // Getters e setters
  public double getReal() {
    return real;
  }

  public void setReal(double real) {
    this.real = real;
  }

  public double getImg() {
    return img;
  }

  public void setImg(double img) {
    this.img = img;
  }

  /**
   * Calcula o módulo do número complexo usando |z| = √(a² + b²)
   */
  public double modulo() {
    return Math.sqrt(real * real + img * img);
  }

  /**
   * Calcula o argumento (ângulo) do número complexo em radianos
   */
  public double argumento() {
    return Math.atan2(img, real);
  }

  /**
   * Realiza a soma de dois números complexos
   * @param outro Número complexo a ser somado
   * @return Novo número complexo resultante da soma
   */
  public NComplexo soma(NComplexo outro) {
    return new NComplexo(real + outro.real, img + outro.img);
  }

  /**
   * Realiza a subtração de dois números complexos
   * @param outro Número complexo a ser subtraído
   * @return Novo número complexo resultante da subtração
   */
  public NComplexo subtracao(NComplexo outro) {
    return new NComplexo(real - outro.real, img - outro.img);
  }

  /**
   * Exibe o número complexo no formato "a + bi"
   */
  public void printComplexo() {
    System.out.println(real + " + " + img + "i");
  }
}

/**
 * Classe principal com testes das operações com números complexos
 */
public class Atividade2 {
  public static void main(String[] args) {
    // Criação de números complexos para teste
    NComplexo z1 = new NComplexo(); // Cria número complexo 0 + 0i
    NComplexo z2 = new NComplexo(1, 2); // Cria número complexo 1 + 2i

    z1.printComplexo();
    z2.printComplexo();

    z1.setImg(11);
    z1.setReal(12);

    z1.printComplexo();

    System.out.println("Módulo de z1: " + z1.modulo());
    System.out.println("Argumento de z1: " + Math.toDegrees(z1.argumento()));

    z1.printComplexo();
    z2.printComplexo();

    System.out.println("Soma de z1 e z2:");
    NComplexo soma = z1.soma(z2);
    soma.printComplexo();

    System.out.println("Subtração de z2 de z1:");
    NComplexo sub = z1.subtracao(z2);
    sub.printComplexo();
  }
}