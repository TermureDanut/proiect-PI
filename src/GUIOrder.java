import javax.swing.*;
import java.awt.*;

public class GUIOrder extends JFrame {
    private JButton done;
    private JTextArea tArea;
    public GUIOrder(Order o){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comenzi");
        setSize(new Dimension(770, 500));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(234, 227, 210));

        String deAfisat = "Comanda pentru: " + o.getUsr().getNume() + " din data: " + o.getData() + ", are status: " + o.getStatus();

        tArea = new JTextArea(deAfisat);
        tArea.setSize(new Dimension(610, 123));
        tArea.setBounds(80, 91,610, 123 );
        tArea.setFont(new Font("Monaco", Font.PLAIN, 15));
        add(tArea);
    }
}
