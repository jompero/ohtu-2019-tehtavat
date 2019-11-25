package ohtu;

import javax.swing.JTextField;

public class Plus extends Command {

    public Plus(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, sovellus);
    }

    @Override
    protected void operate() {
        sovellus.plus(entry);
    }
    
    
}