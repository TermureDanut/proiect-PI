public class Produs {
    private int idMasina;
    private String model;
    private int motorCC, putereCP, putereKW, rezervor, rezerva;
    private String combustibil;
    private int vitezaMaxima;
    private String tipPropulsie;
    private int nrLocuri, nrUsi;
    private String emisii;
    private int lungime, latime, inaltime;
    private String tipCutie;
    private int masaTotala;
    private double pretEuro;
    private int volumPortbagaj;
    private String culoare, imaginePrincipala, culoareInterior, categorie;

    public Produs(int idMasina, String model, int motorCC, int putereCP, int putereKW, int rezervor, int rezerva, String combustibil, int vitezaMaxima,
                  String tipPropulsie, int nrLocuri, int nrUsi, String emisii, int lungime, int latime, int inaltime, String tipCutie, int masaTotala,
                  double pretEuro, int volumPortbagaj, String culoare, String imaginePrincipala, String culoareInterior, String categorie) {
        this.idMasina = idMasina;
        this.model = model;
        this.motorCC = motorCC;
        this.putereCP = putereCP;
        this.putereKW = putereKW;
        this.rezervor = rezervor;
        this.rezerva = rezerva;
        this.combustibil = combustibil;
        this.vitezaMaxima = vitezaMaxima;
        this.tipPropulsie = tipPropulsie;
        this.nrLocuri = nrLocuri;
        this.nrUsi = nrUsi;
        this.emisii = emisii;
        this.lungime = lungime;
        this.latime = latime;
        this.inaltime = inaltime;
        this.tipCutie = tipCutie;
        this.masaTotala = masaTotala;
        this.pretEuro = pretEuro;
        this.volumPortbagaj = volumPortbagaj;
        this.culoare = culoare;
        this.imaginePrincipala = imaginePrincipala;
        this.culoareInterior = culoareInterior;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Mercedez-Benz " + model + " " + motorCC;
    }

    public int getID(){
        return this.idMasina;
    }
    public String getModel() {
        return model;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getImaginePrincipala() {
        return imaginePrincipala;
    }
    public String toString1() {
        return "Model : " + model +
                "\nCategorie : " + categorie +
                "\n\nMotor(CC) :" + motorCC +
                "\nPutere (CP) : " + putereCP +
                "\nPutere (KW) : " + putereKW +
                "\nViteza Maxima : " + vitezaMaxima +
                "\nTip Propulsie : " + tipPropulsie +
                "\nTip Cutie : " + tipCutie +
                "\n\nRezervor : " + rezervor +
                "\nRezerva : " + rezerva +
                "\nCombustibil : " + combustibil +
                "\nEmisii :" + emisii +
                "\n\nNumar Locuri : " + nrLocuri +
                "\nNumar Usi : " + nrUsi +
                "\nLungime :" + lungime +
                "\nLatime : " + latime +
                "\nInaltime : " + inaltime +
                "\nMasa Totala : " + masaTotala +
                "\nVolum Portbagaj : " + volumPortbagaj +
                "\n\nCuloare : " + culoare +
                "\nCuloare Interior  : " + culoareInterior;
    }

    public double getPret(){
        return pretEuro;
    }

    public int getPutereCP() {
        return putereCP;
    }

    public int getPutereKW() {
        return putereKW;
    }
}

