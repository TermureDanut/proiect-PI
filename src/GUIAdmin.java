import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.Scanner;

public class GUIAdmin extends JFrame {
    private JLabel lab1, email, parola;
    private JButton login, back;
    private JTextField tfEmail;
    private JPasswordField pfParola;
    private JCheckBox arataParola1;

    public GUIAdmin(Connection connection) throws FileNotFoundException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Admin");
        setSize(new Dimension(570, 400));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        lab1 = new JLabel("ADMIN");
        lab1.setSize(new Dimension(264, 95));
        lab1.setBounds(46, 14, 264, 95);
        lab1.setFont(new Font("Calibri", Font.BOLD, 30));
        lab1.setBackground(Color.BLACK);
        lab1.setForeground(Color.WHITE);
        add(lab1);

        email = new JLabel("EMAIL ADMIN: ");
        email.setSize(new Dimension(172, 33));
        email.setBounds(46, 134, 172, 33);
        email.setFont(new Font("Calibri", Font.BOLD, 17));
        email.setBackground(Color.BLACK);
        email.setForeground(Color.WHITE);
        add(email);

        parola = new JLabel("PAROLA ADMIN: ");
        parola.setSize(new Dimension(172, 33));
        parola.setBounds(46, 202, 172, 33);
        parola.setFont(new Font("Calibri", Font.BOLD, 17));
        parola.setBackground(Color.BLACK);
        parola.setForeground(Color.WHITE);
        add(parola);

        tfEmail = new JTextField();
        tfEmail.setSize(new Dimension(237, 33));
        tfEmail.setBounds(255, 134, 237, 33);
        tfEmail.setFont(new Font("Calibri", Font.PLAIN,15));
        add(tfEmail);

        pfParola = new JPasswordField();
        pfParola.setEchoChar('•');
        pfParola.setSize(new Dimension(237, 33));
        pfParola.setBounds(255, 202, 237, 33);
        pfParola.setFont(new Font("Calibri", Font.PLAIN,15));
        add(pfParola);

        login = new JButton("LOGIN");
        login.setSize(new Dimension(176, 49));
        login.setBounds(46, 291, 176, 49);
        login.setFont(new Font("Calibri", Font.BOLD, 20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.setFocusPainted(false);
        login.setOpaque(true);
        login.setMargin(new Insets(10, 10, 10, 10));
        add(login);

        back = new JButton("INAPOI");
        back.setSize(new Dimension(176, 49));
        back.setBounds(222, 291, 176, 49);
        back.setFont(new Font("Calibri", Font.BOLD, 20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.setOpaque(true);
        back.setMargin(new Insets(10, 10, 10, 10));
        add(back);

        arataParola1 = new JCheckBox("Arata parola");
        arataParola1.setForeground(Color.WHITE);
        arataParola1.setBackground(Color.BLACK);
        arataParola1.setOpaque(true);
        arataParola1.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            pfParola.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola1.setBounds(255, 235, 100, 50);
        add(arataParola1);

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
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String emAdmin = "", passAdmin = "";
                try {
                    Scanner sc = new Scanner(new File("admin.txt"));
                    while (sc.hasNextLine()) {
                        if (emAdmin.equals("")) {
                            emAdmin = sc.nextLine();
                        } else {
                            passAdmin = sc.nextLine();
                        }
                    }
                    sc.close();
                }catch (FileNotFoundException ex){
                    System.out.println("Nu exista fisier");
                    ex.printStackTrace();
                }

                String parolaIntrodusa = pfParola.getText(), emailIntrodus = tfEmail.getText();

                if (verificareParolaAdmin(passAdmin, parolaIntrodusa) == false){
                    JOptionPane.showMessageDialog(null, "Email sau parola incorecta");
                }else{
                    if (verificareEmailAdmin(emAdmin, emailIntrodus) == false){
                        JOptionPane.showMessageDialog(null, "Email sau parola incorect");
                    }else{
                        setVisible(false);
                        dispose();
                        JOptionPane.showMessageDialog(null, "Logat");
                        GUIAdminModificari newAdminModif = new GUIAdminModificari(connection);
                        dispose();
                    }
                }
            }
        });
    }

    public boolean verificareEmailAdmin(String checkWithE, String toCheckE){
        if (toCheckE.equals(checkWithE)){
            return true;
        }
        return false;
    }

    public boolean verificareParolaAdmin(String checkWithP, String toCheckP){
        if (toCheckP.equals(checkWithP)){
            return true;
        }
        return false;
    }
}
