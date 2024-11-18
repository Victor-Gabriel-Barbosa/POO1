public class Jogador {
    private String nome;
    private int vidas;
    
    public Jogador(String nome, int vidas) {
        this.nome = nome;
        this.vidas = vidas;
    }

    public void perderVida() {
        vidas--;
    }

    public boolean isMorto() {
        return vidas <= 0;
    }

    public String getNome() {
        return nome;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void reiniciarVidas() {
        vidas = 3;
    }   
}
