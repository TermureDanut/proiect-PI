public class User {
    private int idUser;
    private String nume, prenume, telefon, adresa, email, parola;
    private int existaProgramare;
    private int zi, luna, an, idProdus;

    public User(){}

    public User(int idUser, String nume, String prenume, String telefon, String adresa, String email, String parola) {
        this.idUser = idUser;
        this.nume = nume;
        this.prenume = prenume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.email = email;
        this.parola = parola;
    }

    public void setIdProdus(int idProdus) {
        this.idProdus = idProdus;
    }

    public int getIdUser(){
        return idUser;
    }

    public int getExistaProgramare() {
        return existaProgramare;
    }

    public int getZi() {
        return zi;
    }

    public int getLuna() {
        return luna;
    }

    public int getAn() {
        return an;
    }


    public void setExistaProgramare(int existaProgramare) {
        this.existaProgramare = existaProgramare;
    }

    public void setZi(int zi) {
        this.zi = zi;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public String getEmail() {
        return this.email;
    }

    public String getParola() {
        return this.parola;
    }

    public String getNume(){
        return this.nume;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }


}
