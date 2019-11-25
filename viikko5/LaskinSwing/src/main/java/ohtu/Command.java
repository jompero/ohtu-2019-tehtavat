package ohtu;
import javax.swing.JTextField;

public abstract class Command {
    JTextField tuloskentta;
    JTextField syotekentta;
    Sovelluslogiikka sovellus;
    int entry;
    int prevResult;

    public Command(JTextField tuloskentta, JTextField syotekentta, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.sovellus = sovellus;
    }

    protected void run() {
        getPrevResult();
        getEntry();
        operate();
        setResult();
    };
    
    public void undo() {
        sovellus.aseta(prevResult);
        setResult();
    };
    
    protected abstract void operate();
    
    protected void getEntry() {
        entry = Integer.parseInt(syotekentta.getText());
    }
    
    protected void getPrevResult() {
        prevResult = sovellus.tulos();
    }
    
    protected void setResult() {
        tuloskentta.setText(Integer.toString(sovellus.tulos()));
    }
}