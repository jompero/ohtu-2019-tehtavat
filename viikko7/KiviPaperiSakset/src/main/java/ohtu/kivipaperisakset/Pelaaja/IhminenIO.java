package ohtu.kivipaperisakset.Pelaaja;

import java.util.Scanner;

public class IhminenIO implements IO {
    
    private static final Scanner scanner = new Scanner(System.in);

    public String annaSiirto() {
        String siirto = scanner.nextLine();
        return siirto;
    }
    
}
