import java.lang.Math;
import java.util.Scanner;

public class Infos {
    private int i, j, k;
    
    public Infos(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public int soma() {
        return i + j + k;
    }

    public double media() {
        return (double) (i + j + k) / 3;
    }

    public double[] raizQuadrada() {
        return new double[]{Math.sqrt(i), Math.sqrt(j), Math.sqrt(k)};
    }

    public int maior() {
        return Math.max(Math.max(i, j), k);
    }

    public int menor() {
        return Math.min(Math.min(i, j), k);
    }

    public double[] computar() {
        return new double[]{soma(), media(), Math.sqrt(i), Math.sqrt(j), Math.sqrt(k), maior(), menor()};
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tam = 2, a, b, c;
        Infos[] info = new Infos[tam];
        for (int i = 0; i < tam; i++) {
            System.out.println("--------------------------------");
            System.out.println("Elemento " + (i + 1) + ":");
            System.out.print("Digite o 1º número: ");
            a = entrada.nextInt();
            System.out.print("Digite o 2º número: ");
            b = entrada.nextInt();
            System.out.print("Digite o 3º número: ");
            c = entrada.nextInt();
            System.out.println("--------------------------------");
            info[i] = new Infos(a, b, c);
        }
        for (int i = 0; i < tam; i++) {
            double[] resultado = info[i].computar();
            System.out.println("--------------------------------");
            System.out.println("Infosrmações do " + (i + 1) + "º elemento:");
            System.out.println("Soma: " + resultado[0]);
            System.out.println("Média: " + resultado[1]);
            System.out.println("Raiz quadrada do 1º número: " + resultado[2]);
            System.out.println("Raiz quadrada do 2º número: " + resultado[3]);
            System.out.println("Raiz quadrada do 3º número: " + resultado[4]);
            System.out.println("Maior número: " + resultado[5]);
            System.out.println("Menor número: " + resultado[6]);
            System.out.println("--------------------------------");
        }
        entrada.close();
    }
}
