import javax.swing.*;

public class Comunicare {
    private JButton butonImagine;
    private Produs informatiiButon;

    public Comunicare(JButton butonImagine, Produs informatiiButon){
        this.butonImagine = butonImagine;
        this.informatiiButon = informatiiButon;
    }

    public JButton getButonImagine() {
        return butonImagine;
    }

    public Produs getInformatiiButon() {
        return informatiiButon;
    }
}
