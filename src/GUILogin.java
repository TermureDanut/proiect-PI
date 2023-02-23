import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUILogin extends JFrame {
    private JLabel email, parola;
    private JTextField tfEmail;
    private JPasswordField tfParola;
    private JButton login, back;
    private List<User> useri;
    private JCheckBox arataParola1;

    public void adauga(List<User> useri, Connection connection){
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

        for (int i = 1; i <= count; i++){
            try{
                String email = null, parola = null;
                String nume = null, prenume = null, telefon = null, adresa = null;

                PreparedStatement prepEmail = connection.prepareStatement("select email from user where (id)=(?)");
                prepEmail.setInt(1, i);
                ResultSet rsEmail = prepEmail.executeQuery();
                if (rsEmail.next()) {
                    email = rsEmail.getString("email");
                }

                PreparedStatement prepParola = connection.prepareStatement("select parola from user where (id)=(?)");
                prepParola.setInt(1, i);
                ResultSet rsParola = prepParola.executeQuery();
                if (rsParola.next()) {
                    parola = rsParola.getString("parola");
                }

                PreparedStatement prepnume = connection.prepareStatement("select nume from user where (id)=(?)");
                prepnume.setInt(1, i);
                ResultSet rsnume = prepnume.executeQuery();
                if (rsnume.next()) {
                    nume = rsnume.getString("nume");
                }

                PreparedStatement prepprenume = connection.prepareStatement("select prenume from user where (id)=(?)");
                prepprenume.setInt(1, i);
                ResultSet rsprenume = prepprenume.executeQuery();
                if (rsprenume.next()) {
                    prenume = rsprenume.getString("prenume");
                }

                PreparedStatement preptelefon = connection.prepareStatement("select telefon from user where (id)=(?)");
                preptelefon.setInt(1, i);
                ResultSet rstelefon = preptelefon.executeQuery();
                if (rstelefon.next()) {
                    telefon = rstelefon.getString("telefon");
                }

                PreparedStatement prepadresa = connection.prepareStatement("select adresa from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rsadresa = prepadresa.executeQuery();
                if (rsadresa.next()) {
                    adresa = rsadresa.getString("adresa");
                }

                useri.add(new User(i, nume, prenume, telefon, adresa, email, parola));
            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    public GUILogin(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");
        setSize(new Dimension(570, 400));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        email = new JLabel("Email: ");
        email.setSize(new Dimension(155, 36));
        email.setBounds(50, 100, 155, 36);
        email.setFont(new Font("Monaco", Font.BOLD, 15));
        email.setBackground(Color.BLACK);
        email.setForeground(Color.WHITE);
        add(email);

        parola = new JLabel("Parola: ");
        parola.setSize(new Dimension(155, 36));
        parola.setBounds(50, 154, 155, 36);
        parola.setFont(new Font("Monaco", Font.BOLD, 15));
        parola.setBackground(Color.BLACK);
        parola.setForeground(Color.WHITE);
        add(parola);

        tfEmail = new JTextField();
        tfEmail.setSize(new Dimension(235, 36));
        tfEmail.setBounds(247, 100, 235, 36);
        tfEmail.setFont(new Font("Monaco", Font.PLAIN,15));
        add(tfEmail);

        tfParola = new JPasswordField('•');
        tfParola.setSize(new Dimension(235, 36));
        tfParola.setBounds(247, 154, 235, 36);
        tfParola.setFont(new Font("Monaco", Font.PLAIN,15));
        add(tfParola);

        arataParola1 = new JCheckBox("Arata parola");
        arataParola1.setForeground(Color.WHITE);
        arataParola1.setBackground(Color.BLACK);
        arataParola1.setOpaque(true);
        arataParola1.addActionListener(ae -> {
            JCheckBox c = (JCheckBox) ae.getSource();
            tfParola.setEchoChar(c.isSelected() ? '\u0000' : (Character)          UIManager.get("PasswordField.echoChar"));
        });
        arataParola1.setBounds(247, 192, 100, 50);
        add(arataParola1);

        login = new JButton("LOGIN");
        login.setSize(new Dimension(159, 67));
        login.setBounds(50, 250, 159, 67);
        login.setFont(new Font("Monaco", Font.BOLD, 15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.setFocusPainted(false);
        login.setOpaque(true);
        login.setMargin(new Insets(10, 10, 10, 10));
        add(login);

        back = new JButton("INAPOI");
        back.setSize(new Dimension(170, 67));
        back.setBounds(247, 250, 170, 67);
        back.setFont(new Font("Monaco", Font.BOLD, 15));
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

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                User u = new User();
                String email = tfEmail.getText();
                String parola = tfParola.getText();
                useri = new ArrayList<>();
                adauga(useri, connection);

                boolean okEm = false, okPass = false;
                for (User us : useri){
                    if (us.getEmail().equals(email)){
                        if (us.getParola().equals(parola)){
                            okEm = true;
                            okPass = true;
                            u = us;
                        }
                    }
                }


                if (okEm == true && okPass == true) {
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Logat");
                    GUIMainPageLogat newLogat = new GUIMainPageLogat(connection, u);
                    newLogat.setVisible(true);
                    newLogat.setLocationRelativeTo(null);
                    newLogat.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                }else{
                    JOptionPane.showMessageDialog(null, "Email sau parola incorecta");
                }
            }
        });
    }
}
