import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.twilio.Twilio;
import com.twilio.converter.Promoter;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class GUIRegister extends JFrame {
    private JLabel nume, prenume, telefon, adresa, email, parola, confParola;
    private JTextField tfNume, tfPrenume, tfTelefon, tfAdresa, tfEmail;
    private JPasswordField tfParola, tfConfirmare;
    private JCheckBox arataParola1, arataParola2;
    private JButton reg, back;
    public static final int PASSWORD_LENGTH = 10;
    public static final String ACCOUNT_SID = "AC1779549c53c199d39d31d876422e64aa";
    public static final String AUTH_TOKEN = "34b217e2197726f0a6143a0d6dd13c8b";

    public GUIRegister(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTER");
        setSize(new Dimension(770, 500));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        nume = new JLabel("Nume: ");
        nume.setSize(new Dimension(155, 36));
        nume.setBounds(50, 25, 155, 36);
        nume.setFont(new Font("Calibri", Font.BOLD, 18));
        nume.setBackground(Color.BLACK);
        nume.setForeground(Color.WHITE);
        add(nume);

        prenume = new JLabel("Prenume: ");
        prenume.setSize(new Dimension(155, 36));
        prenume.setBounds(50, 72, 155, 36);
        prenume.setFont(new Font("Calibri", Font.BOLD, 18));
        prenume.setBackground(Color.BLACK);
        prenume.setForeground(Color.WHITE);
        add(prenume);

        email = new JLabel("Email: ");
        email.setSize(new Dimension(155, 36));
        email.setBounds(50, 122, 155, 36);
        email.setFont(new Font("Calibri", Font.BOLD, 18));
        email.setBackground(Color.BLACK);
        email.setForeground(Color.WHITE);
        add(email);

        parola = new JLabel("Parola: ");
        parola.setSize(new Dimension(155, 36));
        parola.setBounds(50, 174, 155, 36);
        parola.setFont(new Font("Calibri", Font.BOLD, 18));
        parola.setBackground(Color.BLACK);
        parola.setForeground(Color.WHITE);
        add(parola);

        confParola = new JLabel("Confirmare parola: ");
        confParola.setSize(new Dimension(155, 36));
        confParola.setBounds(50, 226, 155, 36);
        confParola.setFont(new Font("Calibri", Font.BOLD, 18));
        confParola.setBackground(Color.BLACK);
        confParola.setForeground(Color.WHITE);
        add(confParola);

        telefon = new JLabel("Telefon: ");
        telefon.setSize(new Dimension(155, 36));
        telefon.setBounds(50, 274, 155, 36);
        telefon.setFont(new Font("Calibri", Font.BOLD, 18));
        telefon.setBackground(Color.BLACK);
        telefon.setForeground(Color.WHITE);
        add(telefon);

        adresa = new JLabel("Adresa: ");
        adresa.setSize(new Dimension(155, 36));
        adresa.setBounds(50, 322, 155, 36);
        adresa.setFont(new Font("Calibri", Font.BOLD, 18));
        adresa.setBackground(Color.BLACK);
        adresa.setForeground(Color.WHITE);
        add(adresa);

        tfNume = new JTextField();
        tfNume.setSize(new Dimension(235, 36));
        tfNume.setBounds(247, 25, 235, 36);
        tfNume.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfNume);

        tfPrenume = new JTextField();
        tfPrenume.setSize(new Dimension(235, 36));
        tfPrenume.setBounds(247, 72, 235, 36);
        tfPrenume.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfPrenume);

        tfEmail = new JTextField();
        tfEmail.setSize(new Dimension(235, 36));
        tfEmail.setBounds(247, 122, 235, 36);
        tfEmail.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfEmail);

        tfParola = new JPasswordField();
        tfParola.setEchoChar('•');
        tfParola.setSize(new Dimension(235, 36));
        tfParola.setBounds(247, 174, 235, 36);
        tfParola.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfParola);

        tfConfirmare = new JPasswordField();
        tfConfirmare.setEchoChar('•');
        tfConfirmare.setSize(new Dimension(235, 36));
        tfConfirmare.setBounds(247, 226, 235, 36);
        tfConfirmare.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfConfirmare);

        tfTelefon = new JTextField();
        tfTelefon.setSize(new Dimension(235, 36));
        tfTelefon.setBounds(247, 274, 235, 36);
        tfTelefon.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfTelefon);

        tfAdresa = new JTextField();
        tfAdresa.setSize(new Dimension(235, 36));
        tfAdresa.setBounds(247, 322, 235, 36);
        tfAdresa.setFont(new Font("Calibri", Font.PLAIN,18));
        add(tfAdresa);

        reg = new JButton("REGISTER");
        reg.setSize(new Dimension(159, 67));
        reg.setBounds(500, 284, 159, 67);
        reg.setFont(new Font("Calibri", Font.BOLD, 18));
        reg.setBackground(Color.BLACK);
        reg.setForeground(Color.WHITE);
        reg.setBorderPainted(false);
        reg.setContentAreaFilled(false);
        reg.setFocusPainted(false);
        reg.setOpaque(true);
        reg.setMargin(new Insets(10, 10, 10, 10));
        add(reg);

        back = new JButton("INAPOI");
        back.setSize(new Dimension(159, 67));
        back.setBounds(500, 351, 159, 67);
        back.setFont(new Font("Calibri", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.setOpaque(true);
        back.setMargin(new Insets(10, 10, 10, 10));
        add(back);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                GUIMainPage guiMainPage = new GUIMainPage(connection);
                guiMainPage.setVisible(true);
                guiMainPage.setLocationRelativeTo(null);
                guiMainPage.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });

        arataParola1 = new JCheckBox("Arata parola");
        arataParola1.setForeground(Color.WHITE);
        arataParola1.setBackground(Color.BLACK);
        arataParola1.setOpaque(true);
        arataParola1.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            tfParola.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola1.setBounds(500, 174, 100, 50);

        arataParola2 = new JCheckBox("Arata parola");
        arataParola2.setForeground(Color.WHITE);
        arataParola2.setBackground(Color.BLACK);
        arataParola2.setOpaque(true);
        arataParola2.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            tfConfirmare.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola2.setBounds(500, 226, 100, 50);
        add(arataParola1);
        add(arataParola2);

        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = tfNume.getText();
                String p = tfPrenume.getText();
                String em = tfEmail.getText();
                String pass = tfParola.getText();
                String confpass = tfConfirmare.getText();
                String tel = tfTelefon.getText();
                String adr = tfAdresa.getText();

                if (tfNume.getText().equals("") || tfPrenume.getText().equals("") || tfEmail.getText().equals("") ||
                        tfParola.getText().equals("") || tfTelefon.getText().equals("") || tfAdresa.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Completeaza toate campurile!");
                }else{
                    int count = getNrIntrari(connection);
                    if (verificareEmailValid(em) == false){
                        JOptionPane.showMessageDialog(null, "Email invalid!");
                    }else if (pass.length() < 10){
                        JOptionPane.showMessageDialog(null, "Parola trebuie sa fie de cel putin 10 caractere!");
                    }else if (!pass.equals(confpass)) {
                        JOptionPane.showMessageDialog(null, "Parolele nu coincid!");
                    }else{
                        User c = new User(count + 1, n, p, tel, adr, em, pass);
                        boolean ok = false;
                        Random r = new Random();
                        int limita = 999;
                        int limitajos = 100;
                        int codRandom = r.nextInt(limitajos, limita);
                        String mesaj = String.valueOf(codRandom);
                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                        Message message = Message.creator(new com.twilio.type.PhoneNumber("+40764980720"), "MG40ac2c0e4c75237c2c923986c0928901", mesaj).create();
                        while (ok == false) {
                            String cod = JOptionPane.showInputDialog("Introdu codul primit prin mesaj: ");
                            if (cod.equals(mesaj)) {
                                ok = true;
                                String sql = "insert into user (id, nume, prenume, telefon, adresa, email, parola)" + " values(?, ?, ?, ?, ?, ?, ?)";
                                try {
                                    PreparedStatement addStmt = connection.prepareStatement(sql);

                                    addStmt.setInt(1, count + 1);
                                    addStmt.setString(2, n);
                                    addStmt.setString(3, p);
                                    addStmt.setString(4, tel);
                                    addStmt.setString(5, adr);
                                    addStmt.setString(6, em);
                                    addStmt.setString(7, pass);

                                    addStmt.execute();
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                } finally {
                                    JOptionPane.showMessageDialog(null, "Inregistrare completa.");
                                    dispose();
                                    setVisible(false);
                                    GUIMainPageLogat guiMainPageLogat = new GUIMainPageLogat(connection, c);
                                    guiMainPageLogat.setVisible(true);
                                    guiMainPageLogat.setLocationRelativeTo(null);
                                    guiMainPageLogat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Cod incorect!");
                            }
                        }
                    }
                }
            }
        });
    }
    public int getNrIntrari(Connection connection){
        Statement stmt = null;
        int count;

        try {
            stmt = connection.createStatement();
            String query = "select count(*) from user";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }

    public boolean verificareEmailValid(String s){
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
