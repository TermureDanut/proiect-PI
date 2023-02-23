import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIStergeProdus extends JFrame {
    private JTextArea afisare;
    private JScrollPane afisareSP;
    private List<Produs> listaProduse;
    private JLabel main, labelID;
    private JTextField tfID;
    private JButton butonDelete, done;
    public GUIStergeProdus(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sterge Produs");
        setSize(new Dimension(770, 500));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(234, 227, 210));

        String toPrint = print(connection, listaProduse);
        show(toPrint);

        main = new JLabel("Sterge produs");
        main.setSize(new Dimension(192, 82));
        main.setBounds(14, 25, 192, 82);
        main.setFont(new Font("Monaco", Font.BOLD, 25));
        main.setBackground(new Color(234, 227, 210));
        main.setForeground(new Color(28, 56, 121));
        add(main);

        labelID = new JLabel("Scrie id-ul produsului: ");
        labelID.setSize(new Dimension(246, 39));
        labelID.setBounds(236, 25, 246, 39);
        labelID.setFont(new Font("Monaco", Font.BOLD, 20));
        labelID.setBackground(new Color(234, 227, 210));
        labelID.setForeground(new Color(28, 56, 121));
        add(labelID);

        tfID = new JTextField();
        tfID.setSize(new Dimension(62, 38));
        tfID.setBounds(497, 25, 62, 38);
        tfID.setFont(new Font("Monaco", Font.PLAIN,15));
        add(tfID);

        butonDelete = new JButton("STERGE");
        butonDelete.setSize(new Dimension(136, 33));
        butonDelete.setBounds(609, 22, 136, 33);
        butonDelete.setFont(new Font("Monaco", Font.BOLD, 15));
        butonDelete.setBackground(new Color(234, 227, 210));
        butonDelete.setForeground(new Color(28, 56, 121));
        add(butonDelete);

        done = new JButton("DONE");
        done.setSize(new Dimension(136, 33));
        done.setBounds(609, 64, 136, 33);
        done.setFont(new Font("Monaco", Font.BOLD, 15));
        done.setBackground(new Color(234, 227, 210));
        done.setForeground(new Color(28, 56, 121));
        add(done);

        butonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfID.getText());
                String stmt = "delete from produs where (idProdus)=(?)";
                try {
                    PreparedStatement prepStmt = connection.prepareStatement(stmt);
                    prepStmt.setInt(1, id);
                    prepStmt.execute();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }finally {
                    JOptionPane.showMessageDialog(null, "Produs sters");
                }

                remove(afisare);
                remove(afisareSP);
                String toShow = print(connection, listaProduse);
                show(toShow);
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
    }

    public void show(String s){
        afisare = new JTextArea(s);
        afisare.setFont(new Font("Monaco", Font.PLAIN, 15));
        afisare.setSize(new Dimension(732, 310));
        afisare.setBounds(15, 120, 732, 310);
        afisare.setBackground(new Color(249, 245, 235));
        afisare.setOpaque(true);
        add(afisare);

        afisareSP = new JScrollPane(afisare);
        afisareSP.setSize(new Dimension(732, 310));
        afisareSP.setBounds(15, 120, 732, 310);
        afisareSP.setBackground(new Color(249, 245, 235));
        afisareSP.setOpaque(true);
        afisareSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(afisareSP);
    }

    public String print(Connection connection, List<Produs> listaProduse){
        Statement stmt = null;
        int count;

        try {
            stmt = connection.createStatement();
            String query = "select count(*) from produs";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        Produs temp;
        listaProduse = new ArrayList<>();
        String toPrint = "";

        for (int i = 1; i <= count; i++){
            try{
                int idprodus = i;
                String marca = null, model = null, culoare = null, motor = null;
                double pret = 0, consum = 0;
                int co2 = 0;
                String combustibil = null, roti = null, interior = null, categorie = null, imagine = null;

                PreparedStatement prepMarca = connection.prepareStatement("select marca from produs where (idprodus)=(?)");
                prepMarca.setInt(1, i);
                ResultSet rsMarca = prepMarca.executeQuery();
                if (rsMarca.next()) {
                    marca = rsMarca.getString("marca");
                }

                PreparedStatement prepModel = connection.prepareStatement("select model from produs where (idprodus)=(?)");
                prepModel.setInt(1, i);
                ResultSet rsModel = prepModel.executeQuery();
                if (rsModel.next()) {
                    model = rsModel.getString("model");
                }

                PreparedStatement prepCuloare = connection.prepareStatement("select culoare from produs where (idprodus)=(?)");
                prepCuloare.setInt(1, i);
                ResultSet rsCuloare = prepCuloare.executeQuery();
                if (rsCuloare.next()) {
                    culoare = rsCuloare.getString("culoare");
                }

                PreparedStatement prepMotor = connection.prepareStatement("select motor from produs where (idprodus)=(?)");
                prepMotor.setInt(1, i);
                ResultSet rsMotor = prepMotor.executeQuery();
                if (rsMotor.next()) {
                    motor = rsMotor.getString("motor");
                }

                PreparedStatement prepPret = connection.prepareStatement("select pret from produs where (idprodus)=(?)");
                prepPret.setInt(1, i);
                ResultSet rsPret = prepPret.executeQuery();
                if (rsPret.next()) {
                    pret = rsPret.getDouble("pret");
                }

                PreparedStatement prepConsum = connection.prepareStatement("select consum from produs where (idprodus)=(?)");
                prepConsum.setInt(1, i);
                ResultSet rsConsum = prepConsum.executeQuery();
                if (rsConsum.next()) {
                    consum = rsConsum.getDouble("consum");
                }

                PreparedStatement prepCo2 = connection.prepareStatement("select co2 from produs where (idprodus)=(?)");
                prepCo2.setInt(1, i);
                ResultSet rsCo2 = prepCo2.executeQuery();
                if (rsCo2.next()) {
                    co2 = rsCo2.getInt("co2");
                }

                PreparedStatement prepComb = connection.prepareStatement("select combustibil from produs where (idprodus)=(?)");
                prepComb.setInt(1, i);
                ResultSet rsComb = prepComb.executeQuery();
                if (rsComb.next()) {
                    combustibil = rsComb.getString("combustibil");
                }

                PreparedStatement prepRoti = connection.prepareStatement("select roti from produs where (idprodus)=(?)");
                prepRoti.setInt(1, i);
                ResultSet rsRoti = prepRoti.executeQuery();
                if (rsRoti.next()) {
                    roti = rsRoti.getString("roti");
                }

                PreparedStatement prepInterior = connection.prepareStatement("select interior from produs where (idprodus)=(?)");
                prepInterior.setInt(1, i);
                ResultSet rsInterior = prepInterior.executeQuery();
                if (rsInterior.next()) {
                    interior = rsInterior.getString("interior");
                }

                PreparedStatement prepCat = connection.prepareStatement("select categorie from produs where (idprodus)=(?)");
                prepCat.setInt(1, i);
                ResultSet rsCat = prepCat.executeQuery();
                if (rsCat.next()) {
                    categorie = rsCat.getString("categorie");
                }

                PreparedStatement prepImagine = connection.prepareStatement("select imagine from produs where (idprodus)=(?)");
                prepImagine.setInt(1, i);
                ResultSet rsImagine = prepImagine.executeQuery();
                if (rsImagine.next()) {
                    imagine = rsImagine.getString("imagine");
                }

            }catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        for (Produs p : listaProduse){
            toPrint = toPrint + p.toString() + '\n';
        }
        return toPrint;
    }
}
