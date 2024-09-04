public class CampoDeJogo {
    private Bloco[][] campo;

    public CampoDeJogo(int n, int m) {
        campo = new Bloco[n][m];
    }

    public void colocarBloco(Bloco bloco, int x, int y) {
        campo[x][y] = bloco;
    }

    public Bloco getBloco(int x, int y) {
        return campo[x][y];
    }

    public boolean verificarColisao(Bloco bloco, int x, int y) {
        if (x < 0 || x >= campo.length || y < 0 || y >= campo[0].length) {
            return true;
        }
        return campo[x][y] != null && campo[x][y].isSolido();
    }

    public int getTotalBlocos() {
        int total = 0;
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] != null) {
                    total++;
                }
            }
        }
        return total;
    }

    public int getTotalBlocosSolidos() {
        int total = 0;
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                if (campo[i][j] != null && campo[i][j].isSolido()) {
                    total++;
                }
            }
        }
        return total;
    }

    public void imprimir() {
        for (int i = 0; i < campo.length; i++) {
            for (int j = 0; j < campo[0].length; j++) {
                System.out.print(((campo[i][j]!= null && campo[i][j].isSolido())? "[Solido]" : "[Vazio]") + " ");
            }
            System.out.println();
        }
    }
}
