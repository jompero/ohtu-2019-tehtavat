package ohtu;

import javax.swing.JTextField;

public class Clear extends Command {

    public Clear(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    protected void operate() {
        sovellus.nollaa();
    }

}
