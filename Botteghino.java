public class Botteghino {
    private int bigliettiDisponibili = 15;
    private int bigliettiVenduti = 0;
    private int venditoriOccupati = 0;

    public synchronized void acquistaBiglietto(String compratore) throws InterruptedException {
        while (bigliettiDisponibili == 0 || venditoriOccupati >= 3) {
            wait();
        }

        venditoriOccupati++;

        Thread.sleep(1000);

        bigliettiDisponibili--;
        bigliettiVenduti++;
        venditoriOccupati--;

        System.out.println(compratore + " ha acquistato un biglietto.");
        System.out
                .println("Biglietti disponibili: " + bigliettiDisponibili + ", Biglietti venduti: " + bigliettiVenduti);

        System.out.println("--------------------------------");

        notifyAll();
    }

    public synchronized void restituisciBiglietto(String compratore) {
        bigliettiDisponibili++;
        bigliettiVenduti--;

        System.out.println(compratore + " ha restituito il biglietto.");
        System.out
                .println("Biglietti disponibili: " + bigliettiDisponibili + ", Biglietti venduti: " + bigliettiVenduti);

        System.out.println("--------------------------------");

        notifyAll();
    }
}