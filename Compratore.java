public class Compratore extends Thread {
    private String nome;
    private Botteghino botteghino;

    public Compratore(String nome, Botteghino botteghino) {
        this.nome = nome;
        this.botteghino = botteghino;
    }

    public void run() {
        try {
            botteghino.acquistaBiglietto(nome);
        } catch (InterruptedException e) {
        }
    }
}