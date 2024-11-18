public class Batalha {
    private Jogador jogador1;
    private Jogador jogador2;
    private CampoDeJogo campo;

    public Batalha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    public void iniciar() {
        campo = new CampoDeJogo(10, 10);
        jogador1.reiniciarVidas();
        jogador2.reiniciarVidas();
        System.out.println("--------------------------------");
        System.out.println("Batalha Naval");
        System.out.println("Jogador 1: " + jogador1.getNome());
        System.out.println("Jogador 2: " + jogador2.getNome());
        System.out.println("--------------------------------");
        System.out.println("Iniciando a batalha...");
        System.out.println("--------------------------------");
        LimparTela.limpar("Aperte [ENTER] para iniciar...");
        while (!jogador1.isMorto() && !jogador2.isMorto()) {
            // Jogador 1 atacar
            System.out.println("--------------------------------");
            System.out.println("Jogador 1: " + jogador1.getNome());
            System.out.println("Jogador 2: " + jogador2.getNome());
            System.out.println("--------------------------------");
            System.out.println("Turno do Jogador 1");
            int x = GeradorAleatorio.gerarNumero(0, 9);
            int y = GeradorAleatorio.gerarNumero(0, 9);
            Bloco bloco = campo.getBloco(x, y);
            if (bloco != null && bloco.isSolido()) {
                System.out.println("Jogador 2 atacou o bloco (" + (x + 1) + "," + (y + 1) + ")");
                bloco.setSolido(false);
                if (bloco.isDestruido()) {
                    jogador2.perderVida();
                    System.out.println("Jogador 2 perdeu uma vida");
                }
            } else {
                System.out.println("Jogador 2 não atacou nenhum bloco");
                System.out.println("--------------------------------");
            }
            // Jogador 2 atacar
            System.out.println("--------------------------------");
            System.out.println("Jogador 1: " + jogador1.getNome());
            System.out.println("Jogador 2: " + jogador2.getNome());
            System.out.println("--------------------------------");
            System.out.println("Turno do Jogador 2");
            x = GeradorAleatorio.gerarNumero(0, 9);
            y = GeradorAleatorio.gerarNumero(0, 9);
            bloco = campo.getBloco(x, y);
            if (bloco != null && bloco.isSolido()) {
                System.out.println("Jogador 1 atacou o bloco (" + (x + 1) + "," + (y + 1) + ")");
                bloco.setSolido(false);
            }
        }
    }
}
