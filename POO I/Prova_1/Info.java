import java.lang.Math;

public class Info {
    private int i, j, k;

    public Info(int i, int j, int k) {
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
}
