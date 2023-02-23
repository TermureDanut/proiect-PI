import javax.swing.*;
import java.awt.*;

public class GUIAbout extends JFrame {
    private JTextArea t;
    public GUIAbout(){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setSize(new Dimension(700, 700));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        t = new JTextArea("Proiectul presupune crearea unei aplicații de configurare a unei mașini dintre cele disponibile cu scopul de a vedea un preț în funcție de opțiunile alese și a programa o ședință cu un reprezentant al companiei. Mașina are un preț\nde pornire standard care poate crește în funcție de opțiunile alese de client, acest lucru constituind principala funcționalitate de care dispune clientul ce\nfolosește aplicatia. Pe lângă această funcționalitate, clientul are o opțiune prin care poate sesiza diverse nefunctionalități pe care le întâlnește folosind\naplicația sau poate propune modificări in ceea ce privește aspectul aplicației.\nUn client nou venit poate să își creeze un cont sau să se conecteze la cel existent. În cont se salveaza datele clientului, se începe procesul de configurare sau,\ndacă el a fost finalilzat, se va stabili o întâlnire cu un reprezentant fizic într-o\ndată stabilită.");
        t.setSize(new Dimension(650, 650));
        t.setBounds(14, 14, 650, 650);
        t.setForeground(Color.WHITE);
        t.setBackground(Color.BLACK);
        t.setFont(new Font("Calibri", Font.PLAIN, 20));
        t.setLineWrap(true);
        add(t);
    }
}
