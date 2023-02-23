import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GUIUpdateProdus extends JFrame {
    private JTextArea afisare;
    private JScrollPane afisareSP;
    private List<Produs> listaProduse;
    private JLabel main, labelID, labelOptiuneNoua;
    private JTextField tfID, tfOptiune, optiuneNoua;
    private JButton butonUpdate, done;
    private JComboBox optiuni;
    public GUIUpdateProdus(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Produs");
        setSize(new Dimension(770, 500));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(234, 227, 210));
        String toPrint = print(connection, listaProduse);
        show(toPrint);

        String[] opt = {"marca", "model", "culoare", "motor", "pret", "consum", "co2", "combustibil", "roti", "interior",
                "categorie", "imagine"};

        main = new JLabel("Sterge produs");
        main.setSize(new Dimension(192, 82));
        main.setBounds(14, 25, 192, 82);
        main.setFont(new Font("Monaco", Font.BOLD, 25));
        main.setBackground(new Color(234, 227, 210));
        main.setForeground(new Color(28, 56, 121));
        add(main);

        labelID = new JLabel("Scrie id-ul produsului: ");
        labelID.setSize(new Dimension(246, 39));
        labelID.setBounds(246, 25, 246, 39);
        labelID.setFont(new Font("Monaco", Font.BOLD, 20));
        labelID.setBackground(new Color(234, 227, 210));
        labelID.setForeground(new Color(28, 56, 121));
        add(labelID);

        tfID = new JTextField();
        tfID.setSize(new Dimension(62, 38));
        tfID.setBounds(487, 25, 62, 38);
        tfID.setFont(new Font("Monaco", Font.PLAIN,15));
        add(tfID);

        labelOptiuneNoua = new JLabel("Scrie modificarea: ");
        labelOptiuneNoua.setSize(new Dimension(178, 38));
        labelOptiuneNoua.setBounds(236, 80, 178, 38);
        labelOptiuneNoua.setFont(new Font("Monaco", Font.BOLD, 20));
        labelOptiuneNoua.setBackground(new Color(234, 227, 210));
        labelOptiuneNoua.setForeground(new Color(28, 56, 121));
        add(labelOptiuneNoua);

        optiuneNoua = new JTextField();
        optiuneNoua.setSize(new Dimension(136, 33));
        optiuneNoua.setBounds(429, 82, 136, 33);
        optiuneNoua.setFont(new Font("Monaco", Font.BOLD, 15));
        add(optiuneNoua);

        butonUpdate = new JButton("UPDATE");
        butonUpdate.setSize(new Dimension(136, 33));
        butonUpdate.setBounds(609, 8, 136, 33);
        butonUpdate.setFont(new Font("Monaco", Font.BOLD, 15));
        butonUpdate.setBackground(new Color(234, 227, 210));
        butonUpdate.setForeground(new Color(28, 56, 121));
        add(butonUpdate);

        done = new JButton("DONE");
        done.setSize(new Dimension(136, 33));
        done.setBounds(609, 46, 136, 33);
        done.setFont(new Font("Monaco", Font.BOLD, 15));
        done.setBackground(new Color(234, 227, 210));
        done.setForeground(new Color(28, 56, 121));
        add(done);

        optiuni = new JComboBox(opt);
        optiuni.setSize(new Dimension(138, 35));
        optiuni.setBounds(607, 86, 138, 35);
        optiuni.setFont(new Font("Monaco", Font.BOLD, 15));
        optiuni.setBackground(new Color(234, 227, 210));
        optiuni.setForeground(new Color(28, 56, 121));
        add(optiuni);

        butonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tfID.getText());

                int deModificat = optiuni.getSelectedIndex();
                String inlocuitor = optiuneNoua.getText();

                String stmt;
                switch (deModificat){
                    case 0:
                        stmt = "update produs set marca=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 1:
                        stmt = "update produs set model=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 2:
                        stmt = "update produs set culoare=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 3:
                        stmt = "update produs set motor=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 4:
                        stmt = "update produs set pret=? where idprodus=?";
                        double aux = Double.parseDouble(inlocuitor);
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setDouble(1, aux);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 5:
                        stmt = "update produs set consum=? where idprodus=?";
                        double aux1 = Double.parseDouble(inlocuitor);
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setDouble(1, aux1);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 6:
                        stmt = "update produs set co2=? where idprodus=?";
                        int aux2 = Integer.parseInt(inlocuitor);
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setInt(1, aux2);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 7:
                        stmt = "update produs set combustibil=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 8:
                        stmt = "update produs set roti=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 9:
                        stmt = "update produs set interior=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 10:
                        stmt = "update produs set categorie=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
                    case 11:
                        stmt = "update produs set imagine=? where idprodus=?";
                        try {
                            PreparedStatement prepStmt = connection.prepareStatement(stmt);
                            prepStmt.setString(1, inlocuitor);
                            prepStmt.setInt(2, id);
                            prepStmt.execute();
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }finally {
                            JOptionPane.showMessageDialog(null, "Produs modificat");
                        }
                        break;
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
