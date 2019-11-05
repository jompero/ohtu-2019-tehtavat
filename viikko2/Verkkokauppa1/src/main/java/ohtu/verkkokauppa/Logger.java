package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Logger {
    public void lisaaTapahtuma(String tapahtuma);

    public ArrayList<String> getTapahtumat();
}