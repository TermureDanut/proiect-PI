import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static javax.swing.SwingConstants.CENTER;

public class GUIMainPage extends JFrame{
    private JLabel iconita;
    private JButton toate, cabrio, combi, compacta, coupe, suv;
    private JButton admin, about, raport, login, register, searchBtn;
    private JTextArea info;
    private JTextField search;
    private JPanel panelAfisare;
    private JScrollPane scrollPaneAfisare;
    private List<JPanel> panelMasina;
    private List<Produs> masiniDinDB;
    public GUIMainPage(Connection connection){
        setTitle("Masini Mercedes-Benz Noi");
        setSize(new Dimension(1320, 800));
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setLayout(null);

        retreive(connection);

        ImageIcon imgIconita = new ImageIcon("imagini\\mercedeslogo.jpeg");
        Image imagineIconita = imgIconita.getImage();
        Image imgFinal = imagineIconita.getScaledInstance(249, 140, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        iconita = new JLabel(imgIconita);
        iconita.setBackground(Color.white);
        iconita.setSize(new Dimension(249, 140));
        iconita.setBounds(14, 14, 249, 140);
        add(iconita);

        info = new JTextArea("Aplicatie pentru configurare si programare inspirata de Mercedes-Benz");
        info.setLineWrap(true);
        info.setSize(new Dimension(982, 54));
        info.setBounds(290, 84, 982, 54);
        info.setForeground(Color.WHITE);
        info.setBackground(Color.BLACK);
        info.setFont(new Font("Calibri", Font.PLAIN, 30));
        add(info);

        String s;
        UIManager.put("ToolTip.font", new Font("Calibri", Font.BOLD, 17));
        UIManager.put("ToolTip.background", Color.WHITE);
        ToolTipManager.sharedInstance().setInitialDelay(0);

        s = "APASA CA SA VEZI TOATE MASINILE";
        toate = new JButton("TOATE");
        toate.setToolTipText(s);
        toate.setSize(new Dimension(173, 55));
        toate.setBounds(14, 167, 172, 55);
        toate.setBackground(Color.WHITE);
        toate.setForeground(Color.BLACK);
        toate.setFont(new Font("Calibri", Font.BOLD, 21));
        toate.setHorizontalAlignment(SwingConstants.LEFT);
        add(toate);

        s = "APASA CA SA VEZI MASINILE DIN CATEGORIA 'CABRIO'";
        imgIconita = new ImageIcon("imagini\\cabrioLogo.jpeg");
        imagineIconita = imgIconita.getImage();
        imgFinal = imagineIconita.getScaledInstance(173, 55, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        cabrio = new JButton(imgIconita);
        cabrio.setToolTipText(s);
        cabrio.setSize(new Dimension(173, 55));
        cabrio.setBounds(14, 231, 172, 55);
        add(cabrio);

        s = "APASA CA SA VEZI MASINILE DIN CATEGORIA 'COMBI'";
        imgIconita = new ImageIcon("imagini\\combiLogo.jpeg");
        imagineIconita = imgIconita.getImage();
        imgFinal = imagineIconita.getScaledInstance(173, 55, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        combi = new JButton(imgIconita);
        combi.setToolTipText(s);
        combi.setSize(new Dimension(173, 55));
        combi.setBounds(14, 299, 172, 55);
        add(combi);

        s = "APASA CA SA VEZI MASINILE DIN CATEGORIA 'COMPACTA'";
        imgIconita = new ImageIcon("imagini\\compactLogo.jpeg");
        imagineIconita = imgIconita.getImage();
        imgFinal = imagineIconita.getScaledInstance(173, 55, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        compacta = new JButton(imgIconita);
        compacta.setToolTipText(s);
        compacta.setSize(new Dimension(173, 55));
        compacta.setBounds(14, 366, 173, 55);
        add(compacta);

        s = "APASA CA SA VEZI MASINILE DIN CATEGORIA 'COUPE'";
        imgIconita = new ImageIcon("imagini\\coupeLogo.jpeg");
        imagineIconita = imgIconita.getImage();
        imgFinal = imagineIconita.getScaledInstance(173, 55, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        coupe = new JButton(imgIconita);
        coupe.setToolTipText(s);
        coupe.setSize(new Dimension(173, 55));
        coupe.setBounds(14, 433, 173, 55);
        add(coupe);

        s = "APASA CA SA VEZI MASINILE DIN CATEGORIA 'SUV'";
        imgIconita = new ImageIcon("imagini\\suvLogo.jpeg");
        imagineIconita = imgIconita.getImage();
        imgFinal = imagineIconita.getScaledInstance(173, 55, Image.SCALE_SMOOTH);
        imgIconita = new ImageIcon(imgFinal);
        suv = new JButton(imgIconita);
        suv.setToolTipText(s);
        suv.setSize(new Dimension(173, 55));
        suv.setBounds(14, 500, 173, 55);
        add(suv);

        s = "BUTONUL ESTE FACUT SPECIAL PENTRU CLIENTI CA EI SA POATE RAPORTA O PROBLEMA INTALNITA";
        raport = new JButton("RAPORTEAZA");
        raport.setToolTipText(s);
        raport.setSize(new Dimension(173, 57));
        raport.setBounds(14, 597, 173, 57);
        raport.setFont(new Font("Calibri", Font.BOLD, 15));
        raport.setBackground(Color.WHITE);
        raport.setForeground(Color.BLACK);
        add(raport);

        /*admin = new JButton("admin");
        admin.setSize(new Dimension(70, 56));
        admin.setBounds(14, 694, 70, 56);
        admin.setFont(new Font("Calibri", Font.PLAIN, 13));
        admin.setBackground(Color.WHITE);
        admin.setForeground(Color.BLACK);
        add(admin);
*/
        about = new JButton("about");
        about.setSize(new Dimension(70, 56));
        about.setBounds(117, 694, 70, 56);
        about.setFont(new Font("Calibri", Font.PLAIN, 13));
        about.setBackground(Color.WHITE);
        about.setForeground(Color.BLACK);
        add(about);

        search = new JTextField();
        search.setSize(new Dimension(321, 49));
        search.setBounds(500, 14, 321, 49);
        search.setFont(new Font("Calibri", Font.BOLD, 18));
        search.setBackground(Color.WHITE);
        search.setForeground(Color.BLACK);
        add(search);

        login = new JButton("LOGIN");
        login.setSize(new Dimension(147, 41));
        login.setBounds(959, 14, 147, 41);
        login.setFont(new Font("Calibri", Font.BOLD, 17));
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        add(login);

        register = new JButton("REGISTER");
        register.setSize(new Dimension(147, 41));
        register.setBounds(1125, 14, 147, 41);
        register.setFont(new Font("Calibri", Font.BOLD, 17));
        register.setBackground(Color.WHITE);
        register.setForeground(Color.BLACK);
        add(register);

        searchBtn = new JButton("OK");
        searchBtn.setToolTipText("CAUTA O CATEGORIE DE MASINI");
        searchBtn.setSize(new Dimension(52, 49));
        searchBtn.setBounds(836, 14, 52, 49);
        searchBtn.setFont(new Font("Calibri", Font.BOLD, 15));
        searchBtn.setBackground(Color.WHITE);
        searchBtn.setForeground(Color.BLACK);
        add(searchBtn);

        addToPanelPrincipal(connection, "toate");
        toate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "toate");
            }
        });

        coupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "coupe");
            }
        });

        suv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "suv");
            }
        });

        compacta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "compacta");
            }
        });

        cabrio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "cabrio");
            }
        });

        combi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePanel();
                addToPanelPrincipal(connection, "combi");
            }
        });

        /*admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dispose();
                    setVisible(false);
                    GUIAdmin guiAdmin = new GUIAdmin(connection);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });*/

        raport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIRaport guiRaport = new GUIRaport(connection);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIAbout guiAbout = new GUIAbout();
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                GUILogin guiLogin = new GUILogin(connection);
            }
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                GUIRegister guiRegister = new GUIRegister(connection);
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = search.getText();
                str = str.toLowerCase(Locale.ROOT);
                if (existaInDbMasina(str) == false){
                    JOptionPane.showMessageDialog(null, "Masina nu a fost gasita.");
                }
                else{
                    deletePanel();
                    addToPanelPrincipal(connection, str);
                }
            }
        });
    }

    public boolean existaInDbMasina(String deCautat){
        boolean ok = false;
        for (Produs m : masiniDinDB){
            if (deCautat.equals(m.getCategorie())){
                ok = true;
            }
        }
        return ok;
    }

    public int nrMasiniCategorie(String categorie){
        int count = 0;
        for (Produs m : masiniDinDB){
            if (categorie.equals(m.getCategorie())){
                count++;
            }

            if (categorie.equals("toate")){
                count++;
            }
        }
        return count;
    }

    public int urmatorulMultiplu(int n){
        int x = n;
        boolean ok = false;
        while (ok == false){
            if (x % 3 == 0){
                ok = true;
                return x;
            }
            x = x + 1;
        }
        return x;
    }

    public int getNrIntrari(Connection connection){
        Statement stmt = null;
        int count;

        try {
            stmt = connection.createStatement();
            String query = "select count(*) from masina";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }

    public void addToPanelPrincipal(Connection connection, String categorie){
        panelMasina = new ArrayList<>();
        addToListPanel(connection, categorie);

        int count = nrMasiniCategorie(categorie);
        int nr = getNrIntrari(connection);
        int urmatorulMultiplu = urmatorulMultiplu(nr);

        panelAfisare = new JPanel();
        panelAfisare.setBackground(Color.WHITE);
        panelAfisare.setLayout(new GridLayout(urmatorulMultiplu / 3, 3));;

        for (JPanel p : panelMasina){
            panelAfisare.add(p);
            panelAfisare.updateUI();
        }

        for (int i = 0; i < urmatorulMultiplu - count; i++) {
            JButton produs = new JButton();
            produs.setLayout(null);
            produs.setBorderPainted(false);
            produs.setContentAreaFilled(false);
            produs.setFocusPainted(false);
            produs.setOpaque(true);
            produs.setMargin(new Insets(10, 10, 10, 10));
            produs.setSize(new Dimension(300, 400));
            produs.setBackground(Color.WHITE);
            panelAfisare.add(produs);
        }

        scrollPaneAfisare = new JScrollPane(panelAfisare);
        scrollPaneAfisare.setSize(new Dimension(1082, 592));
        scrollPaneAfisare.setBounds(210, 165, 1082, 592);
        scrollPaneAfisare.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneAfisare.setOpaque(true);
        add(scrollPaneAfisare);

    }
    public void deletePanel(){
        remove(panelAfisare);
        remove(scrollPaneAfisare);
    }
    public void addToListPanel(Connection connection, String categorie) {
        for (Produs m : masiniDinDB) {
            if (categorie.equals(m.getCategorie())) {
                JPanel masina = new JPanel();
                masina.setPreferredSize(new Dimension(354, 351));
                masina.setLayout(null);

                JTextArea info = new JTextArea(m.toString());
                info.setFont(new Font("Calibri", Font.BOLD, 30));
                info.setBackground(Color.WHITE);
                info.setForeground(Color.BLACK);
                info.setSize(new Dimension(354, 47));
                info.setBounds(0, 0, 354, 47);
                masina.add(info);

                ImageIcon imgMasina = new ImageIcon(m.getImaginePrincipala());
                Image imagineMasina = imgMasina.getImage();
                Image imgFinal = imagineMasina.getScaledInstance(354, 228, Image.SCALE_DEFAULT);
                imgMasina = new ImageIcon(imgFinal);
                JLabel imagine = new JLabel(imgMasina);
                imagine.setSize(new Dimension(354, 228));
                imagine.setBounds(0, 47, 354, 228);
                masina.add(imagine);

                JButton btn = new JButton("VEZI DETALII");
                btn.setFont(new Font("Calibri", Font.BOLD, 20));
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
                btn.setSize(new Dimension(354, 76));
                btn.setBounds(0, 275, 354, 76);
                btn.setBorderPainted(false);
                btn.setContentAreaFilled(false);
                btn.setFocusPainted(false);
                btn.setOpaque(true);
                btn.setMargin(new Insets(10, 10, 10, 10));
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GUIConfNelogat guiConf = new GUIConfNelogat(connection, m);
                    }
                });
                masina.add(btn);

                panelMasina.add(masina);
            }

            if (categorie.equals("toate")){
                JPanel masina = new JPanel();
                masina.setPreferredSize(new Dimension(354, 351));
                masina.setLayout(null);

                JTextArea info = new JTextArea(m.toString());
                info.setFont(new Font("Calibri", Font.BOLD, 18));
                info.setBackground(Color.WHITE);
                info.setForeground(Color.BLACK);
                info.setSize(new Dimension(354, 47));
                info.setBounds(0, 0, 354, 47);
                masina.add(info);

                ImageIcon imgMasina = new ImageIcon(m.getImaginePrincipala());
                Image imagineMasina = imgMasina.getImage();
                Image imgFinal = imagineMasina.getScaledInstance(354, 228, Image.SCALE_DEFAULT);
                imgMasina = new ImageIcon(imgFinal);
                JLabel imagine = new JLabel(imgMasina);
                imagine.setBackground(Color.WHITE);
                imagine.setSize(new Dimension(354, 228));
                imagine.setBounds(0, 47, 354, 228);
                masina.add(imagine);

                JButton btn = new JButton("VEZI DETALII");
                btn.setFont(new Font("Calibri", Font.BOLD, 20));
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
                btn.setSize(new Dimension(354, 76));
                btn.setBounds(0, 275, 354, 76);
                btn.setBorderPainted(false);
                btn.setContentAreaFilled(false);
                btn.setFocusPainted(false);
                btn.setOpaque(true);
                btn.setMargin(new Insets(10, 10, 10, 10));
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GUIConfNelogat guiConf = new GUIConfNelogat(connection, m);
                    }
                });
                masina.add(btn);

                panelMasina.add(masina);
            }
        }
    }

    public int nrIntrariDb(Connection connection){
        int count;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "select count(*) from masina";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }

    public void retreive(Connection connection){
        masiniDinDB = new ArrayList<>();
        int count = nrIntrariDb(connection);
        for (int i = 1; i <= count; i++){
            try{
                int idMasina = i;
                String model = null;
                int motorCC = 0, putereCP = 0, putereKW = 0, rezervor = 0, rezerva = 0;
                String combustibil = null;
                int vitezaMaxima = 0;
                String tipPropulsie = null;
                int nrLocuri = 0, nrUsi = 0;
                String emisii = null;
                int lungime = 0, latime = 0, inaltime = 0;
                String tipCutie = null;
                int masaTotala = 0;
                double pretEuro = 0;
                int volumPortbagaj = 0;
                String culoare = null, imaginePrincipala = null, culoareInterior = null, categorie = null;

                PreparedStatement prep = connection.prepareStatement("select model from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                ResultSet rs = prep.executeQuery();
                if (rs.next()) {
                    model = rs.getString("model");
                }

                prep = connection.prepareStatement("select motorCC from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    motorCC = rs.getInt("motorCC");
                }

                prep = connection.prepareStatement("select putereCP from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    putereCP = rs.getInt("putereCP");
                }

                prep = connection.prepareStatement("select putereKW from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    putereKW = rs.getInt("putereKW");
                }

                prep = connection.prepareStatement("select rezervorLitrii from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    rezervor = rs.getInt("rezervorLitrii");
                }

                prep = connection.prepareStatement("select rezervaLitrii from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    rezerva = rs.getInt("rezervaLitrii");
                }

                prep = connection.prepareStatement("select combustibil from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    combustibil = rs.getString("combustibil");
                }

                prep = connection.prepareStatement("select vitezaMaxima from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    vitezaMaxima = rs.getInt("vitezaMaxima");
                }

                prep = connection.prepareStatement("select tipPropulsie from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    tipPropulsie = rs.getString("tipPropulsie");
                }

                prep = connection.prepareStatement("select nrLocuri from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    nrLocuri = rs.getInt("nrLocuri");
                }

                prep = connection.prepareStatement("select nrUsi from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    nrUsi = rs.getInt("nrUsi");
                }

                prep = connection.prepareStatement("select emisii from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    emisii = rs.getString("emisii");
                }

                prep = connection.prepareStatement("select lungime from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    lungime = rs.getInt("lungime");
                }

                prep = connection.prepareStatement("select latime from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    latime = rs.getInt("latime");
                }

                prep = connection.prepareStatement("select inaltime from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    inaltime = rs.getInt("inaltime");
                }

                prep = connection.prepareStatement("select tipCutie from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    tipCutie = rs.getString("tipCutie");
                }

                prep = connection.prepareStatement("select masaTotala from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    masaTotala = rs.getInt("masaTotala");
                }

                prep = connection.prepareStatement("select pretEuro from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    pretEuro = rs.getDouble("pretEuro");
                }

                prep = connection.prepareStatement("select volumPortbagaj from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    volumPortbagaj = rs.getInt("volumPortbagaj");
                }

                prep = connection.prepareStatement("select culoare from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    culoare = rs.getString("culoare");
                }

                prep = connection.prepareStatement("select imaginePrincipala from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    imaginePrincipala = rs.getString("imaginePrincipala");
                }

                prep = connection.prepareStatement("select culoareInterior from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    culoareInterior = rs.getString("culoareInterior");
                }

                prep = connection.prepareStatement("select categorie from masina where (idMasina)=(?)");
                prep.setInt(1, i);
                rs = prep.executeQuery();
                if (rs.next()) {
                    categorie = rs.getString("categorie");
                }

                masiniDinDB.add(new Produs(idMasina, model, motorCC, putereCP, putereKW, rezervor, rezerva, combustibil, vitezaMaxima, tipPropulsie, nrLocuri, nrUsi, emisii, lungime,
                        latime, inaltime, tipCutie, masaTotala, pretEuro, volumPortbagaj, culoare, imaginePrincipala, culoareInterior, categorie));
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}

