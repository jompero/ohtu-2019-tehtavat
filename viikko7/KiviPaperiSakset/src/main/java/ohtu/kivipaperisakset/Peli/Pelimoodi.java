package ohtu.kivipaperisakset.Peli;

import java.util.Scanner;

public abstract class Pelimoodi {
    
    protected static final Scanner scanner = new Scanner(System.in);
    protected String ekanSiirto;
    protected String tokanSiirto;
    
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
        
        while (processMoves()) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private boolean processMoves() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        processMovePlayerOne();

        System.out.print("Tokan pelaajan siirto: ");
        processMovePlayerTwo();

        return onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto);
    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract void processMovePlayerOne();
    protected abstract void processMovePlayerTwo();
    
}