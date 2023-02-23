import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.List;

public class Programare extends JFrame {
    private JTextArea t;
    private JButton confirma;
    private List<User> useri;
    public static final String ACCOUNT_SID = "AC1779549c53c199d39d31d876422e64aa";
    public static final String AUTH_TOKEN = "34b217e2197726f0a6143a0d6dd13c8b";
    public Programare(Connection connection, User u, Produs p, String[] modificari){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programare");
        setSize(new Dimension(363, 342));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        t = new JTextArea("Selecteaza o data in care esti\ndisponibil pentru o intalnire fizica cu\nun reprezentant.");
        t.setLineWrap(true);
        t.setSize(new Dimension(326, 143));
        t.setBounds(17, 14, 326, 143);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(t);

        confirma = new JButton("CONFIRMARE");
        confirma.setSize(new Dimension(182, 60));
        confirma.setBounds(85, 229, 182, 60);
        confirma.setBackground(Color.BLACK);
        confirma.setForeground(Color.WHITE);
        confirma.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(confirma);


        UtilDateModel model = new UtilDateModel();
        Properties prop = new Properties();
        prop.put("text.today", "Today");
        prop.put("text.month", "Month");
        prop.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        //datePicker.setSize(new Dimension(323, 20));
        datePicker.setFont(new Font("Calibri", Font.PLAIN, 17));
        datePicker.setBounds(15, 150, 323, 30);
        add(datePicker);

        //adauga(connection);
        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date selectedDate = (Date) datePicker.getModel().getValue();
                getValori(connection, u);
                if (u.getExistaProgramare() != 0){
                    JOptionPane.showMessageDialog(null, "Exista deja o programare.\nUn client poate avea doar o programare.");
                }else{
                    dispose();
                    setVisible(false);
                    adaugaProdusCustomized(connection, p, modificari, u);

                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(selectedDate);
                    int an = calendar.get(Calendar.YEAR);
                    int luna = calendar.get(Calendar.MONTH) + 1;
                    int zi = calendar.get(Calendar.DAY_OF_MONTH);

                    u.setZi(zi);
                    u.setLuna(luna);
                    u.setAn(an);
                    u.setExistaProgramare(1);
                    u.setIdProdus(p.getID());

                    updateUser(connection, u);
                    getValori(connection, u);

                    JOptionPane.showMessageDialog(null, "Programarea in data de : " + zi + " " + luna + " " + an + " a fost facuta cu succes");
                    String mesaj = "Programarea in data de : " + zi + " " + luna + " " + an + " a fost facuta cu succes";
                    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                    Message message = Message.creator(new com.twilio.type.PhoneNumber("+40764980720"), "MG40ac2c0e4c75237c2c923986c0928901", mesaj).create();
                }
            }
        });
    }

    public Programare(Connection connection, User u){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programare");
        setSize(new Dimension(363, 342));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        t = new JTextArea("Selecteaza o data in care esti\ndisponibil pentru o intalnire fizica cu\nun reprezentant.");
        t.setLineWrap(true);
        t.setSize(new Dimension(326, 143));
        t.setBounds(17, 14, 326, 143);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(t);

        confirma = new JButton("CONFIRMARE");
        confirma.setSize(new Dimension(182, 60));
        confirma.setBounds(85, 229, 182, 60);
        confirma.setBackground(Color.BLACK);
        confirma.setForeground(Color.WHITE);
        confirma.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(confirma);


        UtilDateModel model = new UtilDateModel();
        Properties prop = new Properties();
        prop.put("text.today", "Today");
        prop.put("text.month", "Month");
        prop.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, prop);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        //datePicker.setSize(new Dimension(323, 20));
        datePicker.setFont(new Font("Calibri", Font.PLAIN, 17));
        datePicker.setBounds(15, 150, 323, 30);
        add(datePicker);

        //adauga(connection);
        confirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                Date selectedDate = (Date) datePicker.getModel().getValue();
                getValori(connection, u);
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(selectedDate);
                int an = calendar.get(Calendar.YEAR);
                int luna = calendar.get(Calendar.MONTH) + 1;
                int zi = calendar.get(Calendar.DAY_OF_MONTH);

                u.setZi(zi);
                u.setLuna(luna);
                u.setAn(an);
                u.setExistaProgramare(1);

                updateUser(connection, u);
                getValori(connection, u);

                JOptionPane.showMessageDialog(null, "Programarea in data de : " + zi + " " + luna + " " + an + " a fost facuta cu succes");
                String mesaj = "Programarea in data de : " + zi + " " + luna + " " + an + " a fost facuta cu succes";
                Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                Message message = Message.creator(new com.twilio.type.PhoneNumber("+40764980720"), "MG40ac2c0e4c75237c2c923986c0928901", mesaj).create();

                dispose();
                setVisible(false);
                GUIViewProgramari guiViewProgramari = new GUIViewProgramari(connection, u);
            }
        });
    }

    public int nrIntrari(Connection connection){
        int count;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            String query = "select count(*) from produs_customized";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return count;
    }
    public void updateUser(Connection connection, User u){
        int existaProgramare = u.getExistaProgramare();
        int zi = u.getZi();
        int luna = u.getLuna();
        int an = u.getAn();
        int idProdus = nrIntrari(connection);

        int idUser = u.getIdUser();

        String stmt;
        stmt = "update user set existaProgramare=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, existaProgramare);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set zi=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, zi);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set luna=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, luna);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set an=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, an);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set idProdus=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, idProdus);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void adaugaProdusCustomized(Connection connection, Produs p, String[] modificari, User u){
        String sql = "insert into produs_customized (idProdusBasic, motor, culoareExt, culoareInt, jante, idUser)" + " values(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement addStmt = connection.prepareStatement(sql);

            addStmt.setInt(1, p.getID());
            addStmt.setString(2, modificari[0]);
            addStmt.setString(3, modificari[1]);
            addStmt.setString(4, modificari[2]);
            addStmt.setString(5, modificari[3]);
            addStmt.setInt(6, u.getIdUser());

            addStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void getValori(Connection connection, User u){
        int i = u.getIdUser();
        try{
            int existaProgramare = 0, zi = 0, luna = 0, an = 0, idProdus = 0;

            PreparedStatement prepaExistaProgramare = connection.prepareStatement("select existaProgramare from user where (id)=(?)");
            prepaExistaProgramare.setInt(1, i);
            ResultSet rsexistaProgramare = prepaExistaProgramare.executeQuery();
            if (rsexistaProgramare.next()) {
                existaProgramare = rsexistaProgramare.getInt("existaProgramare");
            }

            PreparedStatement prepazi = connection.prepareStatement("select zi from user where (id)=(?)");
            prepazi.setInt(1, i);
            ResultSet rszi = prepazi.executeQuery();
            if (rszi.next()) {
                zi = rszi.getInt("zi");
            }

            PreparedStatement prepaluna = connection.prepareStatement("select luna from user where (id)=(?)");
            prepaluna.setInt(1, i);
            ResultSet rsluna = prepaluna.executeQuery();
            if (rsluna.next()) {
                luna = rsluna.getInt("luna");
            }

            PreparedStatement prepaan = connection.prepareStatement("select an from user where (id)=(?)");
            prepaan.setInt(1, i);
            ResultSet rsan = prepaan.executeQuery();
            if (rsan.next()) {
                an = rsan.getInt("an");
            }

            PreparedStatement prepaidProd = connection.prepareStatement("select idProdus from user where (id)=(?)");
            prepaidProd.setInt(1, i);
            ResultSet rsidProd = prepaidProd.executeQuery();
            if (rsidProd.next()) {
                idProdus = rsidProd.getInt("idProdus");
            }

            u.setExistaProgramare(existaProgramare);
            u.setZi(zi);
            u.setLuna(luna);
            u.setAn(an);
            u.setIdProdus(idProdus);

        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void adauga(Connection connection){
        Statement stmt = null;
        useri = new ArrayList<>();
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
                int existaProgramare = 0, zi = 0, luna = 0, an = 0, idProdus = 0;

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

                PreparedStatement prepaExistaProgramare = connection.prepareStatement("select existaProgramare from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rsexistaProgramare = prepaExistaProgramare.executeQuery();
                if (rsadresa.next()) {
                    existaProgramare = rsexistaProgramare.getInt("existaProgramare");
                }

                PreparedStatement prepazi = connection.prepareStatement("select zi from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rszi = prepazi.executeQuery();
                if (rsadresa.next()) {
                    zi = rszi.getInt("zi");
                }

                PreparedStatement prepaluna = connection.prepareStatement("select luna from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rsluna = prepaluna.executeQuery();
                if (rsadresa.next()) {
                    luna = rszi.getInt("luna");
                }

                PreparedStatement prepaan = connection.prepareStatement("select an from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rsan = prepaan.executeQuery();
                if (rsadresa.next()) {
                    an = rsan.getInt("an");
                }

                PreparedStatement prepaidProd = connection.prepareStatement("select idProdus from user where (id)=(?)");
                prepadresa.setInt(1, i);
                ResultSet rsidProd = prepaidProd.executeQuery();
                if (rsadresa.next()) {
                    idProdus = rsidProd.getInt("idProdus");
                }

                User usr = new User(i, nume, prenume, telefon, adresa, email, parola);
                usr.setExistaProgramare(existaProgramare);
                usr.setZi(zi);
                usr.setLuna(luna);
                usr.setAn(an);
                usr.setIdUser(idProdus);
                useri.add(usr);

            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
