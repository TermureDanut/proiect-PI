import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GUIViewProgramari extends JFrame {
    private JTextArea titlu;
    private JButton anuleaza, modifica;

    public GUIViewProgramari(Connection connection, User u){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Programari");
        setSize(new Dimension(400, 200));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        getValori(connection, u);

        titlu = new JTextArea("Modifica sau anuleaza o programare. Ai o programare in data de :\n" + u.getZi() + " " + u.getLuna() + " " + u.getAn());
        titlu.setSize(new Dimension(363, 64));
        titlu.setBounds(14, 14, 363, 64);
        titlu.setBackground(Color.BLACK);
        titlu.setForeground(Color.WHITE);
        titlu.setFont(new Font("Calibri", Font.PLAIN, 17));
        titlu.setLineWrap(true);
        add(titlu);

        anuleaza = new JButton("ANULEAZA");
        anuleaza.setSize(new Dimension(160, 66));
        anuleaza.setBounds(14, 92, 160, 66);
        anuleaza.setBackground(Color.BLACK);
        anuleaza.setForeground(Color.WHITE);
        anuleaza.setFont(new Font("Calibri", Font.PLAIN, 15));
        add(anuleaza);

        modifica = new JButton("MODIFICA");
        modifica.setSize(new Dimension(160, 66));
        modifica.setBounds(217, 92, 160, 66);
        modifica.setBackground(Color.BLACK);
        modifica.setForeground(Color.WHITE);
        modifica.setFont(new Font("Calibri", Font.PLAIN, 15));
        add(modifica);

        anuleaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Programarea a fost anulata.");
                updateUser(connection, u);
            }
        });

        modifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setVisible(false);
                Programare programare = new Programare(connection, u);
            }
        });
    }

    public void updateUser(Connection connection, User u){
        int idUser = u.getIdUser();

        String stmt;
        stmt = "update user set existaProgramare=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, 0);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set zi=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, 0);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set luna=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, 0);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set an=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, 0);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        stmt = "update user set idProdus=? where id=?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(stmt);
            prepStmt.setInt(1, 0);
            prepStmt.setInt(2, idUser);
            prepStmt.execute();
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
}
