import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class GUIConfNelogat extends JFrame {
    private double total;
    private JLabel labelTitlu;
    private JTextArea labelMotorizare;
    private JComboBox comboBoxMotorizare, culoareInt, culoareExt, comboBoxJante;
    private JTextArea info1, info2, pretCalculat;
    private JButton calculeazaPret;
    private JTextArea finalizare;
    private String extfataC1, extspateC1, intFataC1, intSpateC1, extfataC2, extspateC2, intFataC2, intSpateC2, jante1, jante2, jante3;
    private JLabel extfataC1L, extspateC1L, intFataC1L, intSpateC1L, extfataC2L, extspateC2L, intFataC2L, intSpateC2L, jante1L, jante2L, jante3L;
    private String extC1, extC2, intC1, intC2, tipJ1, tipJ2, tipJ3;
    private JPanel imagini, imaginiJante, sp, sp1, sp2;
    private JScrollPane imaginiScroll, janteScroll;

    public GUIConfNelogat(Connection connection, Produs p){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurare");
        setSize(new Dimension(1200, 1000));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        UIManager.put("ToolTip.font", new Font("Calibri", Font.BOLD, 17));
        UIManager.put("ToolTip.background", Color.WHITE);
        ToolTipManager.sharedInstance().setInitialDelay(0);

        retrieve(connection, p);
        addToPanel();

        labelTitlu = new JLabel(p.toString());
        labelTitlu.setSize(new Dimension(553, 56));
        labelTitlu.setBackground(Color.BLACK);
        labelTitlu.setBounds(0, 0, 553, 56);
        labelTitlu.setFont(new Font("Calibri", Font.PLAIN, 19));
        labelTitlu.setForeground(Color.WHITE);
        add(labelTitlu);

        String[] motoare = {"2000", "2500", "3000"};
        comboBoxMotorizare = new JComboBox(motoare);
        comboBoxMotorizare.setToolTipText("ALEGE O MOTOROZARE DORITA");
        comboBoxMotorizare.setSize(new Dimension(199, 44));
        comboBoxMotorizare.setBounds(14, 56, 199, 44);
        comboBoxMotorizare.setBackground(Color.BLACK);
        comboBoxMotorizare.setForeground(Color.WHITE);
        comboBoxMotorizare.setFont(new Font("Calibri", Font.PLAIN, 19));
        add(comboBoxMotorizare);

        String[] culori = {extC1, extC2};

        culoareExt = new JComboBox(culori);
        culoareExt.setToolTipText("SELECTEAZA O CULOARE PENTRU EXTERIOR");
        culoareExt.setSize(new Dimension(199, 44));
        culoareExt.setBounds(14, 115, 199, 44);
        culoareExt.setBackground(Color.BLACK);
        culoareExt.setForeground(Color.WHITE);
        culoareExt.setFont(new Font("Calibri", Font.PLAIN, 19));
        add(culoareExt);

        String[] culoriInt = {intC1, intC2};
        culoareInt = new JComboBox(culoriInt);
        culoareInt.setToolTipText("SELECTEAZA O CULOARE PENTRU INTERIOR");
        culoareInt.setSize(new Dimension(199, 44));
        culoareInt.setBounds(14, 462, 199, 44);
        culoareInt.setBackground(Color.BLACK);
        culoareInt.setForeground(Color.WHITE);
        culoareInt.setFont(new Font("Calibri", Font.PLAIN, 19));
        add(culoareInt);

        String[] jante = {tipJ1, tipJ2, tipJ3};
        comboBoxJante = new JComboBox(jante);
        comboBoxJante.setToolTipText("SELECTEAZA O MARIME PENTRU JANTE");
        comboBoxJante.setSize(new Dimension(199, 44));
        comboBoxJante.setBounds(14, 520, 199, 44);
        comboBoxJante.setBackground(Color.BLACK);
        comboBoxJante.setForeground(Color.WHITE);
        comboBoxJante.setFont(new Font("Calibri", Font.PLAIN, 19));
        add(comboBoxJante);

        calculeazaPret = new JButton("CALCULEAZA");
        calculeazaPret.setBackground(Color.BLACK);
        calculeazaPret.setForeground(Color.WHITE);
        calculeazaPret.setFont(new Font("Calibri", Font.BOLD, 17));
        calculeazaPret.setSize(new Dimension(196, 70));
        calculeazaPret.setBounds(17, 700,196, 70);
        add(calculeazaPret);

        afisare(0, 0, 0, 0, p, culori, culoriInt, jante);

        calculeazaPret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetare();

                int variantaMotor = comboBoxMotorizare.getSelectedIndex();
                int variantaExt = culoareExt.getSelectedIndex();
                int variantaInt = culoareInt.getSelectedIndex();
                int variantaJante = comboBoxJante.getSelectedIndex();

                afisare(variantaMotor, variantaExt, variantaInt, variantaJante, p, culori, culoriInt, jante);
            }
        });

        info2 = new JTextArea(p.toString1());
        info2.setLineWrap(true);
        info2.setBackground(Color.BLACK);
        info2.setForeground(Color.WHITE);
        info2.setFont(new Font("Calibri", Font.PLAIN, 20));
        info2.setSize(new Dimension(400, 664));
        info2.setBounds(950, 108, 400, 664);
        add(info2);

        finalizare = new JTextArea("CONECTEAZA-TE CA SA POTI\nFACE O PROGRAMARE LA O\nREPREZENTATA");
        finalizare.setLineWrap(true);
        finalizare.setBackground(Color.BLACK);
        finalizare.setForeground(Color.WHITE);
        finalizare.setFont(new Font("Calibri", Font.BOLD, 17));
        finalizare.setSize(new Dimension(215, 70));
        finalizare.setBounds(950, 826,215, 70);
        add(finalizare);
    }

    public void afisare(int variantaMotor, int variantaExt, int variantaInt, int variantaJante, Produs p, String[] culori, String[] culoriInt, String[] jante){
        total = p.getPret();
        String mesaj = null;
        if (variantaMotor == 0){
            mesaj = "Pret motor : 1000 euro || Consum mixt : 5.8 l/100km || Putere (cp) : " + p.getPutereCP() + "\nPutere (kw) : " + p.getPutereKW() + " || Emisii CO2 mixt : 152 g/km";
            //total = p.getPret() + 1000;
        }
        if (variantaMotor == 1){
            int cp = p.getPutereCP() + 30;
            int kw = p.getPutereKW() + 30;
            mesaj = "Pret motor : 2000 euro || Consum mixt : 7.7 l/100km || Putere (cp) : " + cp + "\nPutere (kw) : " + kw + " || Emisii CO2 mixt : 176 g/km";
            total = total + 2000;
        }
        if (variantaMotor == 2){
            int cp = p.getPutereCP() + 60;
            int kw = p.getPutereKW() + 60;
            mesaj = "Pret motor : 3000 euro || Consum mixt : 8.9  l/100km || Putere (cp) : " + cp + "\nPutere (kw) : " + kw + " || Emisii CO2 mixt : 202 g/km";
            total = total + 3000;
        }

        String mesaj1 = null;
        if (variantaExt == 0 && !culori[variantaExt].equals('-')){
            mesaj1 = "Culoare Exterior : " + culori[variantaExt] + "\nPret : 500 euro\nTip culoare : metalizat";
            //total = total + 500;
        }

        if (variantaExt == 1 && !culori[variantaExt].equals('-')){
            mesaj1 = "Culoare Exterior : " + culori[variantaExt] + "\nPret : 1000 euro\nTip culoare : metalizat";
            total = total + 1000;
        }

        String mesaj2 = null;
        if (variantaInt == 0 && !culoriInt[variantaInt].equals('-')){
            mesaj2 = "Culoare Interior : " + culoriInt[variantaInt] + "\nPret : 500 euro\nTip culoare : metalizat";
            //total = total + 500;
        }

        if (variantaInt == 1 && !culoriInt[variantaInt].equals('-')){
            mesaj2 = "Culoare Interior : " + culoriInt[variantaInt] + "\nPret : 1000 euro\nTip culoare : metalizat";
            total = total + 1000;
        }

        String mesaj3 = null;
        if (variantaJante == 0 && !jante[variantaJante].equals('-')){
            mesaj3 = "Jante marimea : " + jante[variantaJante] + "\nPret : 200 euro";
            //total = total + 200;
        }

        if (variantaJante == 1 && !jante[variantaJante].equals('-')){
            mesaj3 = "Jante marimea : " + jante[variantaJante] + "\nPret : 400 euro";
            total = total + 400;
        }

        if (variantaJante == 2 && !jante[variantaJante].equals('-')) {
            mesaj3 = "Jante marimea : " + jante[variantaJante] + "\nPret : 1000 euro";
            total = total + 1000;
        }

        String msg = mesaj1 + '\n' + mesaj2 + '\n' + mesaj3;
        info1 = new JTextArea(msg);
        info1.setLineWrap(true);
        info1.setBackground(Color.BLACK);
        info1.setForeground(Color.WHITE);
        info1.setFont(new Font("Calibri", Font.PLAIN, 16));
        info1.setSize(new Dimension(198, 277));
        add(info1);

        sp1 = new JPanel(new FlowLayout());
        sp1.add(info1);
        sp1.setSize(new Dimension(198, 277));
        sp1.setBackground(Color.BLACK);
        sp1.setBounds(14, 174, 198, 277);
        add(sp1);

        labelMotorizare = new JTextArea();
        labelMotorizare.setText(mesaj);
        labelMotorizare.setLineWrap(true);
        labelMotorizare.setSize(new Dimension(589, 44));
        labelMotorizare.setBackground(Color.BLACK);
        labelMotorizare.setFont(new Font("Calibri", Font.PLAIN, 17));
        labelMotorizare.setForeground(Color.WHITE);

        sp = new JPanel(new FlowLayout());
        sp.add(labelMotorizare);
        sp.setSize(new Dimension(589, 44));
        sp.setBackground(Color.BLACK);
        sp.setBounds(234, 56, 589, 44);
        add(sp);

        pretCalculat = new JTextArea("Pret euro: " + total);
        pretCalculat.setLineWrap(true);
        pretCalculat.setBackground(Color.BLACK);
        pretCalculat.setForeground(Color.WHITE);
        pretCalculat.setFont(new Font("Calibri", Font.PLAIN, 22));
        pretCalculat.setSize(new Dimension(414, 50));
        //pretCalculat.setBounds(950, 53, 414, 50);
        //add(pretCalculat);

        sp2 = new JPanel(new FlowLayout());
        sp2.add(pretCalculat);
        sp2.setSize(new Dimension(414, 50));
        sp2.setBackground(Color.BLACK);
        sp2.setBounds(950, 53, 414, 50);
        add(sp2);
    }

    public void resetare(){
        remove(pretCalculat);
        remove(sp2);
        remove(info1);
        remove(sp1);
        remove(labelMotorizare);
        remove(sp);
    }

    public void retrieve(Connection connection, Produs p){
        try{
            int i = p.getID();

            PreparedStatement prep = connection.prepareStatement("select extFataC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                this.extfataC1 = rs.getString("extFataC1");
            }

            //System.out.println(this.extfataC1);

            prep = connection.prepareStatement("select extSpateC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.extspateC1 = rs.getString("extSpateC1");
            }

            //System.out.println(this.extspateC1);

            prep = connection.prepareStatement("select intFataC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intFataC1 = rs.getString("intFataC1");
            }

            //System.out.println(this.intFataC1);

            prep = connection.prepareStatement("select intSpateC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intSpateC1 = rs.getString("intSpateC1");
            }

            //System.out.println(this.intSpateC1);

            prep = connection.prepareStatement("select extFataC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.extfataC2 = rs.getString("extFataC2");
            }

            //System.out.println(this.extfataC2);

            prep = connection.prepareStatement("select extSpateC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.extspateC2 = rs.getString("extSpateC2");
            }

            //System.out.println(this.extspateC2);

            prep = connection.prepareStatement("select intFataC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intFataC2 = rs.getString("intFataC2");
            }

            //System.out.println(this.intFataC2);

            prep = connection.prepareStatement("select intSpateC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intSpateC2 = rs.getString("intSpateC2");
            }

            //System.out.println(this.intSpateC2);

            prep = connection.prepareStatement("select jante1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.jante1 = rs.getString("jante1");
            }

            //System.out.println(this.jante1);

            prep = connection.prepareStatement("select jante2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.jante2 = rs.getString("jante2");
            }

            //System.out.println(this.jante2);

            prep = connection.prepareStatement("select jante3 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.jante3 = rs.getString("jante3");
            }

            //System.out.println(this.jante3);

            prep = connection.prepareStatement("select extC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.extC1 = rs.getString("extC1");
            }

            //System.out.println(this.extC1);

            prep = connection.prepareStatement("select extC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.extC2 = rs.getString("extC2");
            }

            //System.out.println(this.extC2);

            prep = connection.prepareStatement("select intC1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intC1 = rs.getString("intC1");
            }

            //System.out.println(this.intC1);

            prep = connection.prepareStatement("select intC2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.intC2 = rs.getString("intC2");
            }

            //System.out.println(this.intC2);

            prep = connection.prepareStatement("select tipJ1 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.tipJ1 = rs.getString("tipJ1");
            }

            //System.out.println(this.tipJ1);

            prep = connection.prepareStatement("select tipJ2 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.tipJ2 = rs.getString("tipJ2");
            }

            //System.out.println(this.tipJ2);

            prep = connection.prepareStatement("select tipJ3 from masina where (idMasina)=(?)");
            prep.setInt(1, i);
            rs = prep.executeQuery();
            if (rs.next()) {
                this.tipJ3 = rs.getString("tipJ3");
            }

            //System.out.println(this.tipJ3);

        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void addToPanel(){
        imagini = new JPanel();
        imagini.setLayout(new GridLayout(8, 1));
        ImageIcon imgButton;
        Image imagineButton;
        Image imagineButtonFinal;
        if (!extfataC1.equals('-')) {
            imgButton = new ImageIcon(extfataC1);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            extfataC1L = new JLabel(imgButton);
            extfataC1L.setToolTipText("IMAGINE DIN EXTERIOR CU VEDERE IN FATA. CULOAREA " + extC1.toUpperCase());
            extfataC1L.setPreferredSize(new Dimension(660, 347));
            imagini.add(extfataC1L);
        }

        if (!extspateC1.equals('-')) {
            imgButton = new ImageIcon(extspateC1);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            extspateC1L = new JLabel(imgButton);
            extspateC1L.setToolTipText("IMAGINE DIN EXTERIOR CU VEDERE IN SPATE. CULOAREA " + extC1.toUpperCase());
            extspateC1L.setPreferredSize(new Dimension(660, 347));
            imagini.add(extspateC1L);
        }

        if (!intFataC1.equals('-')) {
            imgButton = new ImageIcon(intFataC1);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            intFataC1L = new JLabel(imgButton);
            intFataC1L.setToolTipText("IMAGINE DIN INTERIOR CU VEDERE LA PARTEA DIN FATA. CULOAREA " + intC1.toUpperCase());
            intFataC1L.setPreferredSize(new Dimension(660, 347));
            imagini.add(intFataC1L);
        }

        if (!intSpateC1.equals('-')) {
            imgButton = new ImageIcon(intSpateC1);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            intSpateC1L = new JLabel(imgButton);
            intSpateC1L.setToolTipText("IMAGINE DIN INTERIOR CU VEDERE LA PARTEA DIN SPATE. CULOAREA " + intC1.toUpperCase());
            intSpateC1L.setPreferredSize(new Dimension(660, 347));
            imagini.add(intSpateC1L);
        }

        if (!extfataC2.equals('-')) {
            imgButton = new ImageIcon(extfataC2);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            extfataC2L = new JLabel(imgButton);
            extfataC2L.setToolTipText("IMAGINE DIN EXTERIOR CU VEDERE IN FATA. CULOAREA " + extC2.toUpperCase());
            extfataC2L.setPreferredSize(new Dimension(660, 347));
            imagini.add(extfataC2L);
        }

        if (!extspateC2.equals('-')) {
            imgButton = new ImageIcon(extspateC2);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            extspateC2L = new JLabel(imgButton);
            extspateC2L.setToolTipText("IMAGINE DIN EXTERIOR CU VEDERE IN SPATE. CULOAREA " + extC2.toUpperCase());
            extspateC2L.setPreferredSize(new Dimension(660, 347));
            imagini.add(extspateC2L);
        }

        if (!intFataC2.equals('-')) {
            imgButton = new ImageIcon(intFataC2);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            intFataC2L = new JLabel(imgButton);
            intFataC2L.setToolTipText("IMAGINE DIN INTERIOR CU VEDERE LA PARTEA DIN FATA. CULOAREA " + intC2.toUpperCase());
            intFataC2L.setPreferredSize(new Dimension(660, 347));
            imagini.add(intFataC2L);
        }

        if (!intSpateC2.equals('-')) {
            imgButton = new ImageIcon(intSpateC2);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(660, 347, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            intSpateC2L = new JLabel(imgButton);
            intSpateC2L.setToolTipText("IMAGINE DIN INTERIOR CU VEDERE LA PARTEA DIN SPATE. CULOAREA " + intC2.toUpperCase());
            intSpateC2L.setPreferredSize(new Dimension(660, 347));
            imagini.add(intSpateC2L);
        }

        imaginiJante = new JPanel(new GridLayout(1, 3));

        if (!jante1.equals('-')) {
            imgButton = new ImageIcon(jante1);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(199, 174, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            jante1L = new JLabel(imgButton);
            jante1L.setToolTipText("JANTE " + tipJ1 +" INCHI");
            jante1L.setPreferredSize(new Dimension(199, 174));
            imaginiJante.add(jante1L);
        }

        if (!jante2.equals('-')) {
            imgButton = new ImageIcon(jante2);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(199, 174, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            jante2L = new JLabel(imgButton);
            jante2L.setToolTipText("JANTE " + tipJ2 +" INCHI");
            jante2L.setPreferredSize(new Dimension(199, 174));
            imaginiJante.add(jante2L);
        }

        if (!jante3.equals('-')) {
            imgButton = new ImageIcon(jante3);
            imagineButton = imgButton.getImage();
            imagineButtonFinal = imagineButton.getScaledInstance(199, 174, Image.SCALE_SMOOTH);
            imgButton = new ImageIcon(imagineButtonFinal);
            jante3L = new JLabel(imgButton);
            jante3L.setToolTipText("JANTE " + tipJ3 +" INCHI");
            jante3L.setPreferredSize(new Dimension(199, 174));
            imaginiJante.add(jante3L);
        }

        janteScroll = new JScrollPane(imaginiJante);
        janteScroll.setPreferredSize(new Dimension(650, 180));
        janteScroll.setBounds(14, 785, 650, 180);
        //janteScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(janteScroll);

        imaginiScroll = new JScrollPane(imagini);
        imaginiScroll.setPreferredSize(new Dimension(684, 664));
        imaginiScroll.setBounds(234, 108, 684, 664);
        imaginiScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(imaginiScroll);
    }

    public double calculeazaPret(){
        return 0;
    }
}
