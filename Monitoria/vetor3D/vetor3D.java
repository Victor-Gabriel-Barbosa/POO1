public class vetor3D extends vetor2D {
  protected double z;

  vetor3D() {
    super();
    z = 0.0;
  }

  vetor3D(double x, double y, double z) {
    super(x, y);
    this.z = z;
  }

  void setZ(int z) {
    this.z = z;
  }

  double getZ() {
    return z;
  }

  public vetor3D ProdutoVetorial(vetor3D vet) {
    vetor3D resultado = new vetor3D();
    
    resultado.x = (this.y * vet.z - vet.y * this.z);

    resultado.y = (-1) * (this.x * vet.z - vet.x * this.z);

    resultado.z = (this.x * vet.y - vet.x * this.y);

    return resultado;
  }

  public double moduloVetor() {
    return Math.sqrt(x * x + y * y + z * z);
  }
}