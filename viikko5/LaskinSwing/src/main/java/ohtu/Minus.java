package ohtu;

import javax.swing.JTextField;

public class Minus extends Command {

    public Minus(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }


    @Override
    protected void operate() {
        sovellus.miinus(entry);
    }
}
