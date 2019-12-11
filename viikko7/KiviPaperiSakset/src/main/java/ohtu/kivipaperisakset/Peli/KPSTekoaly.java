package ohtu.kivipaperisakset.Peli;

import ohtu.kivipaperisakset.Pelaaja.IO;
import ohtu.kivipaperisakset.Pelaaja.IhminenIO;
import ohtu.kivipaperisakset.Pelaaja.TekoalyIO;

public class KPSTekoaly extends Pelimoodi {

    IO ihminen = new IhminenIO();
    TekoalyIO tekoaly = new TekoalyIO();

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