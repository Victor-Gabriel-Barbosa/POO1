public class mainVetor {
  public static void main(String[] args) {
    vetor3D t1 = new vetor3D(3, 2, 5);
    vetor3D t2 = new vetor3D(4, 1, 7);
    vetor3D res = new vetor3D();

    double mod;

    res = t1.ProdutoVetorial(t2);

    System.out.println("O produto vetorial de t1 e t2 é: ");
    System.out.printf("x = %f, y = %f, z = %f\n", res.getX(), res.getY(), res.getZ());

    mod = res.moduloVetor();

    System.out.printf("O módulo do vetor resultante é: %f\n", mod);
  }
}
