package ohtu.kivipaperisakset;

import java.util.Scanner;

import ohtu.kivipaperisakset.Peli.KPSParempiTekoaly;
import ohtu.kivipaperisakset.Peli.KPSPelaajaVsPelaaja;
import ohtu.kivipaperisakset.Peli.KPSTekoaly;
import ohtu.kivipaperisakset.Peli.Pelimoodi;

public class Pelitehdas {

    private static final Scanner scanner = new Scanner(System.in);
    private static Pelimoodi peli;

    public static void suorita() {

        System.out.println("\nValitse pelataanko"
        + "\n (a) ihmistä vastaan "
        + "\n (b) tekoälyä vastaan"
        + "\n (c) parannettua tekoälyä vastaan"
        + "\nmuilla valinnoilla lopetataan");

        switch(scanner.nextLine()) {
            case "a":
                peli = new KPSPelaajaVsPelaaja();
                break;
            case "b":
                peli = new KPSTekoaly();
                break;
            case "c":
                peli = new KPSParempiTekoaly();
                break;
            default: break;
        }

        if (peli != null) {
            peli.pelaa();
            peli = null;
            suorita();
        }
    }
}