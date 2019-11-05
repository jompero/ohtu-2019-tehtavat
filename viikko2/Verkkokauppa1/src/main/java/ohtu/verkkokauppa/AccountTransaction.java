package ohtu.verkkokauppa;

public interface AccountTransaction {
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}