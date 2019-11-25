package ohtu;

import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
 
public class Tapahtumankuuntelija implements ActionListener {
    private JButton undo;
    private Sovelluslogiikka sovellus;
    private HashMap<JButton, Command> commands;
    private Command prevCommand;
 
    public Tapahtumankuuntelija(JButton plus, JButton miinus, JButton nollaa, JButton undo, JTextField tuloskentta, JTextField syotekentta) {
        this.undo = undo;
        this.sovellus = new Sovelluslogiikka();
        this.commands = new HashMap<>();
        commands.put(plus, new Plus(tuloskentta, syotekentta, sovellus));
        commands.put(miinus, new Minus(tuloskentta, syotekentta, sovellus));
        commands.put(nollaa, new Clear(tuloskentta, syotekentta, sovellus));
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if ( event.getSource() != undo ) {
            Command command = commands.get((JButton)event.getSource());
            command.run();
            prevCommand = command;
            undo.setEnabled(true);
        } else {
            prevCommand.undo();
            prevCommand = null;
            undo.setEnabled(false);
        } 
    }
 
}