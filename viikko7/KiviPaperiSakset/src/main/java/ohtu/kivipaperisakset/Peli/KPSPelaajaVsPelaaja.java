package ohtu.kivipaperisakset.Peli;

import ohtu.kivipaperisakset.Pelaaja.IO;
import ohtu.kivipaperisakset.Pelaaja.IhminenIO;

public class KPSPelaajaVsPelaaja extends Pelimoodi {

    IO pelaaja = new IhminenIO();

    @Override
    protected void processMovePlayerOne() {
        ekanSiirto = pelaaja.annaSiirto();
    }

    @Override
    protected void processMovePlayerTwo() {
        tokanSiirto = pelaaja.annaSiirto();
    }
}