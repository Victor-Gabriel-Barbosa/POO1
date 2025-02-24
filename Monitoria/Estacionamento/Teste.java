public class Teste {
  public static void main(String[] args) {
      System.out.println(metodo());
  }

  public static String metodo() {
      try {
          System.out.println("Try");
          return "Retornando do try";
      } finally {
          System.out.println("Finally será executado antes do retorno");
      }
  }
}