package ohtu.kivipaperisakset.Peli;

import ohtu.kivipaperisakset.Pelaaja.IO;
import ohtu.kivipaperisakset.Pelaaja.IhminenIO;
import ohtu.kivipaperisakset.Pelaaja.TekoalyParannettuIO;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends Pelimoodi {

    final IO ihminen = new IhminenIO();
    final TekoalyParannettuIO tekoaly = new TekoalyParannettuIO(20);

    @Override
    protected void processMovePlayerOne() {
        ekanSiirto = ihminen.annaSiirto();
    }

    @Override
    protected void processMovePlayerTwo() {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
    }
}
