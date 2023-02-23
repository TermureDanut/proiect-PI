import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GUIAdaugaProdus extends JFrame{
    private JLabel main;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8 ,l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21 ,l22, l23, l24, l25, l26, l27, l28, l29, l30;
    private JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;
    private JTextField t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30;
    private JButton add, done, clear, addImagini;
    public GUIAdaugaProdus(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adauga Produs");
        setSize(new Dimension(1261, 908));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(234, 227, 210));

        l1 = new JLabel("Model:");
        l1.setSize(new Dimension(158, 46));
        l1.setBounds(14, 14, 158, 46);
        l1.setFont(new Font("Monaco", Font.BOLD, 15));
        l1.setBackground(new Color(234, 227, 210));
        l1.setForeground(new Color(28, 56, 121));
        add(l1);

        l2 = new JLabel("Motor(cc):");
        l2.setSize(new Dimension(158, 46));
        l2.setBounds(14, 72, 158, 46);
        l2.setFont(new Font("Monaco", Font.BOLD, 15));
        l2.setBackground(new Color(234, 227, 210));
        l2.setForeground(new Color(28, 56, 121));
        add(l2);

        l3 = new JLabel("Putere(cp):");
        l3.setSize(new Dimension(158, 46));
        l3.setBounds(14, 132, 158, 46);
        l3.setFont(new Font("Monaco", Font.BOLD, 15));
        l3.setBackground(new Color(234, 227, 210));
        l3.setForeground(new Color(28, 56, 121));
        add(l3);


        l4 = new JLabel("Putere(kw):");
        l4.setSize(new Dimension(158, 46));
        l4.setBounds(14, 191, 158, 46);
        l4.setFont(new Font("Monaco", Font.BOLD, 15));
        l4.setBackground(new Color(234, 227, 210));
        l4.setForeground(new Color(28, 56, 121));
        add(l4);

        l5 = new JLabel("Rezervor(litrii): ");
        l5.setSize(new Dimension(158, 46));
        l5.setBounds(14, 251, 158, 46);
        l5.setFont(new Font("Monaco", Font.BOLD, 15));
        l5.setBackground(new Color(234, 227, 210));
        l5.setForeground(new Color(28, 56, 121));
        add(l5);

        l6 = new JLabel("Rezerva(litrii): ");
        l6.setSize(new Dimension(158, 46));
        l6.setBounds(14, 309, 158, 46);
        l6.setFont(new Font("Monaco", Font.BOLD, 15));
        l6.setBackground(new Color(234, 227, 210));
        l6.setForeground(new Color(28, 56, 121));
        add(l6);

        l7 = new JLabel("Combustibil: ");
        l7.setSize(new Dimension(158, 46));
        l7.setBounds(14, 365, 158, 46);
        l7.setFont(new Font("Monaco", Font.BOLD, 15));
        l7.setBackground(new Color(234, 227, 210));
        l7.setForeground(new Color(28, 56, 121));
        add(l7);

        l8 = new JLabel("Viteza maxima: ");
        l8.setSize(new Dimension(158, 46));
        l8.setBounds(14, 424, 158, 46);
        l8.setFont(new Font("Monaco", Font.BOLD, 15));
        l8.setBackground(new Color(234, 227, 210));
        l8.setForeground(new Color(28, 56, 121));
        add(l8);

        l9 = new JLabel("Tip propulsie: ");
        l9.setSize(new Dimension(158, 46));
        l9.setBounds(14, 482, 158, 46);
        l9.setFont(new Font("Monaco", Font.BOLD, 15));
        l9.setBackground(new Color(234, 227, 210));
        l9.setForeground(new Color(28, 56, 121));
        add(l9);

        l10 = new JLabel("Nr locuri: ");
        l10.setSize(new Dimension(158, 46));
        l10.setBounds(14, 536, 158, 46);
        l10.setFont(new Font("Monaco", Font.BOLD, 15));
        l10.setBackground(new Color(234, 227, 210));
        l10.setForeground(new Color(28, 56, 121));
        add(l10);

        l11 = new JLabel("Nr usi: ");
        l11.setSize(new Dimension(158, 46));
        l11.setBounds(14, 594, 158, 46);
        l11.setFont(new Font("Monaco", Font.BOLD, 15));
        l11.setBackground(new Color(234, 227, 210));
        l11.setForeground(new Color(28, 56, 121));
        add(l11);

        l12 = new JLabel("Emisii: ");
        l12.setSize(new Dimension(158, 46));
        l12.setBounds(14, 653, 158, 46);
        l12.setFont(new Font("Monaco", Font.BOLD, 15));
        l12.setBackground(new Color(234, 227, 210));
        l12.setForeground(new Color(28, 56, 121));
        add(l12);

        l13 = new JLabel("Lungime: ");
        l13.setSize(new Dimension(158, 46));
        l13.setBounds(14, 712, 158, 46);
        l13.setFont(new Font("Monaco", Font.BOLD, 15));
        l13.setBackground(new Color(234, 227, 210));
        l13.setForeground(new Color(28, 56, 121));
        add(l13);

        l14 = new JLabel("Latime: ");
        l14.setSize(new Dimension(158, 46));
        l14.setBounds(14, 767, 158, 46);
        l14.setFont(new Font("Monaco", Font.BOLD, 15));
        l14.setBackground(new Color(234, 227, 210));
        l14.setForeground(new Color(28, 56, 121));
        add(l14);

        l15 = new JLabel("Inaltime: ");
        l15.setSize(new Dimension(158, 46));
        l15.setBounds(14, 822, 158, 46);
        l15.setFont(new Font("Monaco", Font.BOLD, 15));
        l15.setBackground(new Color(234, 227, 210));
        l15.setForeground(new Color(28, 56, 121));
        add(l15);

        l16 = new JLabel("Tip cutie: ");
        l16.setSize(new Dimension(158, 46));
        l16.setBounds(575, 14, 158, 46);
        l16.setFont(new Font("Monaco", Font.BOLD, 15));
        l16.setBackground(new Color(234, 227, 210));
        l16.setForeground(new Color(28, 56, 121));
        add(l16);

        l17 = new JLabel("Masa totala: ");
        l17.setSize(new Dimension(158, 46));
        l17.setBounds(575, 72, 158, 46);
        l17.setFont(new Font("Monaco", Font.BOLD, 15));
        l17.setBackground(new Color(234, 227, 210));
        l17.setForeground(new Color(28, 56, 121));
        add(l17);

        l18 = new JLabel("Pret euro: ");
        l18.setSize(new Dimension(158, 46));
        l18.setBounds(575, 132, 158, 46);
        l18.setFont(new Font("Monaco", Font.BOLD, 15));
        l18.setBackground(new Color(234, 227, 210));
        l18.setForeground(new Color(28, 56, 121));
        add(l18);

        l19 = new JLabel("Volum portbagaj: ");
        l19.setSize(new Dimension(158, 46));
        l19.setBounds(575, 191, 158, 46);
        l19.setFont(new Font("Monaco", Font.BOLD, 15));
        l19.setBackground(new Color(234, 227, 210));
        l19.setForeground(new Color(28, 56, 121));
        add(l19);

        l20 = new JLabel("Culoare: ");
        l20.setSize(new Dimension(158, 46));
        l20.setBounds(575, 251, 158, 46);
        l20.setFont(new Font("Monaco", Font.BOLD, 15));
        l20.setBackground(new Color(234, 227, 210));
        l20.setForeground(new Color(28, 56, 121));
        add(l20);

        l21 = new JLabel("Imagine principala: ");
        l21.setSize(new Dimension(158, 46));
        l21.setBounds(575, 309, 158, 46);
        l21.setFont(new Font("Monaco", Font.BOLD, 15));
        l21.setBackground(new Color(234, 227, 210));
        l21.setForeground(new Color(28, 56, 121));
        add(l21);

        l22 = new JLabel("Culoare interior: ");
        l22.setSize(new Dimension(158, 46));
        l22.setBounds(575, 364, 158, 46);
        l22.setFont(new Font("Monaco", Font.BOLD, 15));
        l22.setBackground(new Color(234, 227, 210));
        l22.setForeground(new Color(28, 56, 121));
        add(l22);

        l23 = new JLabel("Categorie: ");
        l23.setSize(new Dimension(158, 46));
        l23.setBounds(575, 424, 158, 46);
        l23.setFont(new Font("Monaco", Font.BOLD, 15));
        l23.setBackground(new Color(234, 227, 210));
        l23.setForeground(new Color(28, 56, 121));
        add(l23);

        l24 = new JLabel("Culoare ext1: ");
        l24.setSize(new Dimension(158, 46));
        l24.setBounds(575, 482, 158, 46);
        l24.setFont(new Font("Monaco", Font.BOLD, 15));
        l24.setBackground(new Color(234, 227, 210));
        l24.setForeground(new Color(28, 56, 121));
        add(l24);

        l25 = new JLabel("Culoare ext2: ");
        l25.setSize(new Dimension(158, 46));
        l25.setBounds(575, 536, 158, 46);
        l25.setFont(new Font("Monaco", Font.BOLD, 15));
        l25.setBackground(new Color(234, 227, 210));
        l25.setForeground(new Color(28, 56, 121));
        add(l25);

        l26 = new JLabel("Culoare int1: ");
        l26.setSize(new Dimension(158, 46));
        l26.setBounds(575, 594, 158, 46);
        l26.setFont(new Font("Monaco", Font.BOLD, 15));
        l26.setBackground(new Color(234, 227, 210));
        l26.setForeground(new Color(28, 56, 121));
        add(l26);

        l27 = new JLabel("Culoare int2: ");
        l27.setSize(new Dimension(158, 46));
        l27.setBounds(575, 653, 158, 46);
        l27.setFont(new Font("Monaco", Font.BOLD, 15));
        l27.setBackground(new Color(234, 227, 210));
        l27.setForeground(new Color(28, 56, 121));
        add(l27);

        l28 = new JLabel("Tip jante1: ");
        l28.setSize(new Dimension(158, 46));
        l28.setBounds(575, 712, 158, 46);
        l28.setFont(new Font("Monaco", Font.BOLD, 15));
        l28.setBackground(new Color(234, 227, 210));
        l28.setForeground(new Color(28, 56, 121));
        add(l28);

        l29 = new JLabel("Tip jante2: ");
        l29.setSize(new Dimension(158, 46));
        l29.setBounds(575, 767, 158, 46);
        l29.setFont(new Font("Monaco", Font.BOLD, 15));
        l29.setBackground(new Color(234, 227, 210));
        l29.setForeground(new Color(28, 56, 121));
        add(l29);

        l30 = new JLabel("Tip jante3: ");
        l30.setSize(new Dimension(158, 46));
        l30.setBounds(575, 822, 158, 46);
        l30.setFont(new Font("Monaco", Font.BOLD, 15));
        l30.setBackground(new Color(234, 227, 210));
        l30.setForeground(new Color(28, 56, 121));
        add(l30);


        t1 = new JTextField();
        t1.setSize(new Dimension(276, 46));
        t1.setBounds(189, 14, 276, 46);
        t1.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t1);

        t2 = new JTextField();
        t2.setSize(new Dimension(276, 46));
        t2.setBounds(189, 73, 276, 46);
        t2.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t2);

        t3 = new JTextField();
        t3.setSize(new Dimension(276, 46));
        t3.setBounds(189, 133, 276, 46);
        t3.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t3);

        t4 = new JTextField();
        t4.setSize(new Dimension(276, 46));
        t4.setBounds(189, 192, 276, 46);
        t4.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t4);

        t5 = new JTextField();
        t5.setSize(new Dimension(276, 46));
        t5.setBounds(189, 252, 276, 46);
        t5.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t5);

        t6 = new JTextField();
        t6.setSize(new Dimension(276, 46));
        t6.setBounds(189, 310, 276, 46);
        t6.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t6);

        t7 = new JTextField();
        t7.setSize(new Dimension(276, 46));
        t7.setBounds(189, 366, 276, 46);
        t7.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t7);

        t8 = new JTextField();
        t8.setSize(new Dimension(276, 46));
        t8.setBounds(189, 425, 276, 46);
        t8.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t8);

        t9 = new JTextField();
        t9.setSize(new Dimension(276, 46));
        t9.setBounds(189, 483, 276, 46);
        t9.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t9);

        t10 = new JTextField();
        t10.setSize(new Dimension(276, 46));
        t10.setBounds(189, 537, 276, 46);
        t10.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t10);

        t11 = new JTextField();
        t11.setSize(new Dimension(276, 46));
        t11.setBounds(189, 595, 276, 46);
        t11.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t11);

        t12 = new JTextField();
        t12.setSize(new Dimension(276, 46));
        t12.setBounds(189, 654, 276, 46);
        t12.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t12);

        t13 = new JTextField();
        t13.setSize(new Dimension(276, 46));
        t13.setBounds(189, 713, 276, 46);
        t13.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t13);

        t14 = new JTextField();
        t14.setSize(new Dimension(276, 46));
        t14.setBounds(189, 763, 276, 46);
        t14.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t14);

        t15 = new JTextField();
        t15.setSize(new Dimension(276, 46));
        t15.setBounds(189, 823, 276, 46);
        t15.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t15);

        t16 = new JTextField();
        t16.setSize(new Dimension(276, 46));
        t16.setBounds(749, 14, 276, 46);
        t16.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t16);

        t17 = new JTextField();
        t17.setSize(new Dimension(276, 46));
        t17.setBounds(749, 73, 276, 46);
        t17.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t17);

        t18 = new JTextField();
        t18.setSize(new Dimension(276, 46));
        t18.setBounds(749, 132, 276, 46);
        t18.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t18);

        t19 = new JTextField();
        t19.setSize(new Dimension(276, 46));
        t19.setBounds(749, 192, 276, 46);
        t19.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t19);

        t20 = new JTextField();
        t20.setSize(new Dimension(276, 46));
        t20.setBounds(749, 252, 276, 46);
        t20.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t20);

        t21 = new JTextField();
        t21.setSize(new Dimension(276, 46));
        t21.setBounds(749, 310, 276, 46);
        t21.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t21);

        t22 = new JTextField();
        t22.setSize(new Dimension(276, 46));
        t22.setBounds(749, 366, 276, 46);
        t22.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t22);

        t23 = new JTextField();
        t23.setSize(new Dimension(276, 46));
        t23.setBounds(749, 425, 276, 46);
        t23.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t23);

        t24 = new JTextField();
        t24.setSize(new Dimension(276, 46));
        t24.setBounds(749, 483, 276, 46);
        t24.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t24);

        t25 = new JTextField();
        t25.setSize(new Dimension(276, 46));
        t25.setBounds(749, 537, 276, 46);
        t25.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t25);

        t26 = new JTextField();
        t26.setSize(new Dimension(276, 46));
        t26.setBounds(749, 595, 276, 46);
        t26.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t26);

        t27 = new JTextField();
        t27.setSize(new Dimension(276, 46));
        t27.setBounds(749, 654, 276, 46);
        t27.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t27);

        t28 = new JTextField();
        t28.setSize(new Dimension(276, 46));
        t28.setBounds(749, 713, 276, 46);
        t28.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t28);

        t29 = new JTextField();
        t29.setSize(new Dimension(276, 46));
        t29.setBounds(749, 763, 276, 46);
        t29.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t29);

        t30 = new JTextField();
        t30.setSize(new Dimension(276, 46));
        t30.setBounds(749, 823, 276, 46);
        t30.setFont(new Font("Monaco", Font.PLAIN,15));
        add(t30);

        add = new JButton("ADD");
        add.setSize(new Dimension(213, 59));
        add.setBounds(1065, 297, 213, 59);
        add.setFont(new Font("Monaco", Font.BOLD, 20));
        add.setBackground(new Color(234, 227, 210));
        add.setForeground(new Color(28, 56, 121));
        add(add);

        done = new JButton("DONE");
        done.setSize(new Dimension(213, 59));
        done.setBounds(1065, 505, 213, 59);
        done.setFont(new Font("Monaco", Font.BOLD, 20));
        done.setBackground(new Color(234, 227, 210));
        done.setForeground(new Color(28, 56, 121));
        add(done);

        clear = new JButton("CLEAR");
        clear.setSize(new Dimension(213, 59));
        clear.setBounds(1065, 402, 213, 59);
        clear.setFont(new Font("Monaco", Font.BOLD, 20));
        clear.setBackground(new Color(234, 227, 210));
        clear.setForeground(new Color(28, 56, 121));
        add(clear);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String model = t1.getText();
                int motorCC = Integer.parseInt(t2.getText());
                int putereCP = Integer.parseInt(t3.getText());
                int putereKW = Integer.parseInt(t4.getText());
                int rezervorLitrii = Integer.parseInt(t5.getText());
                int rezervaLitrii = Integer.parseInt(t6.getText());
                String combustibil = t7.getText();
                int vitezaMaxima = Integer.parseInt(t8.getText());
                String tipPropulsie = t9.getText();
                int nrLocuri  = Integer.parseInt(t10.getText());
                int nrUsi  = Integer.parseInt(t11.getText());
                String emisii = t12.getText();
                int lungime  = Integer.parseInt(t13.getText());
                int latime  = Integer.parseInt(t14.getText());
                int inaltime  = Integer.parseInt(t15.getText());
                String tipCutie = t16.getText();
                int masaTotala = Integer.parseInt(t17.getText());
                double pretEuro = Double.parseDouble(t18.getText());
                int volumPortbagaj =  Integer.parseInt(t19.getText());
                String culoare = t20.getText();
                String imaginePrincipala = t21.getText();
                String culoareInterior = t22.getText();
                String categorie  = t23.getText();
                String extC1 = t24.getText();
                String extC2 = t25.getText();
                String intC1 = t26.getText();
                String intC2 = t27.getText();
                String tipJ1 = t28.getText();
                String tipJ2 = t29.getText();
                String tipJ3 = t30.getText();


                String sql = " insert into masina (model, motorCC, putereCP, putereKW, rezervorLitrii, rezervaLitrii, combustibil, vitezaMaxima, tipPropulsie, nrLocuri, nrUsi," +
                        " emisii, lungime, latime, inaltime, tipCutie, masaTotala, pretEuro, volumPortbagaj, culoare, imaginePrincipala, " +
                        "culoareInterior, categorie, extC1, extC2, intC1, intC2, tipJ1, tipJ2, tipJ3)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try{
                    PreparedStatement addStmt = connection.prepareStatement(sql);

                    addStmt.setString(1, model);
                    addStmt.setInt(2, motorCC);
                    addStmt.setInt(3, putereCP);
                    addStmt.setInt(4, putereKW);
                    addStmt.setInt(5, rezervorLitrii);
                    addStmt.setInt(6, rezervaLitrii);
                    addStmt.setString(7, combustibil);
                    addStmt.setInt(8, vitezaMaxima);
                    addStmt.setString(9, tipPropulsie);
                    addStmt.setInt(10, nrLocuri);
                    addStmt.setInt(11, nrUsi);
                    addStmt.setString(12, emisii);
                    addStmt.setInt(13, lungime);
                    addStmt.setInt(14, latime);
                    addStmt.setInt(15, inaltime);
                    addStmt.setString(16, tipCutie);
                    addStmt.setInt(17, masaTotala);
                    addStmt.setDouble(18, pretEuro);
                    addStmt.setInt(19, volumPortbagaj);
                    addStmt.setString(20, culoare);
                    addStmt.setString(21, imaginePrincipala);
                    addStmt.setString(22, culoareInterior);
                    addStmt.setString(23, categorie);
                    addStmt.setString(24, extC1);
                    addStmt.setString(25, extC2);
                    addStmt.setString(26, intC1);
                    addStmt.setString(27, intC2);
                    addStmt.setString(28, tipJ1);
                    addStmt.setString(29, tipJ2);
                    addStmt.setString(30, tipJ3);

                    addStmt.execute();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    JOptionPane.showMessageDialog(null, "ADAUGAT");
                }
            }
        });

        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                GUIAdminModificari newAdmin = new GUIAdminModificari(connection);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");
                t14.setText("");
                t15.setText("");
                t16.setText("");
                t17.setText("");
                t18.setText("");
                t19.setText("");
                t20.setText("");
                t21.setText("");
                t22.setText("");
                t23.setText("");
                t24.setText("");
                t25.setText("");
                t26.setText("");
                t27.setText("");
                t28.setText("");
                t29.setText("");
                t30.setText("");
            }
        });
    }

}
