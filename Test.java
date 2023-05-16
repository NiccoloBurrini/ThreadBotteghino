import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Botteghino botteghino = new Botteghino();
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            String nomeCompratore = "Compratore " + i;
            Compratore compratore = new Compratore(nomeCompratore, botteghino);
            Thread thread = new Thread(compratore);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        botteghino.restituisciBiglietto("Compratore 1");
        System.exit(0);
    }
}