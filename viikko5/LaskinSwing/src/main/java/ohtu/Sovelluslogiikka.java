package ohtu;

public class Sovelluslogiikka {
 
    private int tulos;
 
    public void plus(int luku) {
        tulos += luku;
    }
     
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    public void nollaa() {
        tulos = 0;
    }
    
    public void aseta(int luku) {
        tulos = luku;
    }
 
    public int tulos() {
        return tulos;
    }
}
