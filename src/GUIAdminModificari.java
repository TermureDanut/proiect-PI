import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIAdminModificari extends JFrame{
    private JLabel label1;
    private JButton addProd, deleteProd, updateProd;
    private JScrollPane afisareSP;
    private JTextArea afisare;
    private List<Produs> listaProduse;
    private List<String> raporturi;
    public GUIAdminModificari(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setSize(new Dimension(770, 500));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(234, 227, 210));

        label1 = new JLabel("ADMIN");
        label1.setSize(new Dimension(213, 59));
        label1.setBounds(32, 14, 213, 59);
        label1.setFont(new Font("Monaco", Font.BOLD, 30));
        label1.setBackground(new Color(234, 227, 210));
        label1.setForeground(new Color(28, 56, 121));
        add(label1);

        addProd = new JButton("ADAUGA PRODUS");
        addProd.setSize(new Dimension(195, 41));
        addProd.setBounds(32, 117, 195, 41);
        addProd.setFont(new Font("Monaco", Font.BOLD, 15));
        addProd.setBackground(new Color(249, 245, 235));
        addProd.setForeground(new Color(28, 56, 121));
        add(addProd);

        deleteProd = new JButton("STERGE PRODUS");
        deleteProd.setSize(new Dimension(195, 41));
        deleteProd.setBounds(32, 168, 195, 41);
        deleteProd.setFont(new Font("Monaco", Font.BOLD, 15));
        deleteProd.setBackground(new Color(249, 245, 235));
        deleteProd.setForeground(new Color(28, 56, 121));
        add(deleteProd);

        updateProd = new JButton("UPDATE PRODUS");
        updateProd.setSize(new Dimension(195, 41));
        updateProd.setBounds(32, 220, 195, 41);
        updateProd.setFont(new Font("Monaco", Font.BOLD, 15));
        updateProd.setBackground(new Color(249, 245, 235));
        updateProd.setForeground(new Color(28, 56, 121));
        add(updateProd);


        addProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUIAdaugaProdus newAdaugaProdus = new GUIAdaugaProdus(connection);
            }
        });

        deleteProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUIStergeProdus newStergeProdus = new GUIStergeProdus(connection);
            }
        });

        updateProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUIUpdateProdus newUpdateProdus = new GUIUpdateProdus(connection);
            }
        });
    }

    public void show(String s){
        afisare = new JTextArea(s);
        afisare.setFont(new Font("Monaco", Font.PLAIN, 15));
        afisare.setSize(new Dimension(446, 452));
        afisare.setBounds(309, 14, 446, 452);
        afisare.setBackground(new Color(249, 245, 235));
        afisare.setOpaque(true);
        add(afisare);

        afisareSP = new JScrollPane(afisare);
        afisareSP.setSize(new Dimension(446, 452));
        afisareSP.setBounds(309, 14, 446, 452);
        afisareSP.setBackground(new Color(249, 245, 235));
        afisareSP.setOpaque(true);
        afisareSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(afisareSP);
    }
}
