import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GUIRaport extends JFrame {
    private JTextArea tArea;
    private JTextArea textField;
    private JButton trimite;
    public GUIRaport(Connection connection){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Raporteaza o problema");
        setSize(new Dimension(765, 400));
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        String tAreaText = "Aceasta fereastra este creata special pentru clienti pentru cazul in care vad o \nproblema sa o raporteze iar problema va fi rezolvata ulterior";
        tArea = new JTextArea(tAreaText);
        tArea.setSize(new Dimension(683, 74));
        tArea.setBounds(21, 8, 683, 74);
        tArea.setBackground(Color.BLACK);
        tArea.setForeground(Color.WHITE);
        tArea.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(tArea);

        textField = new JTextArea();
        textField.setLineWrap(true);
        textField.setSize(new Dimension(705, 215));
        textField.setBounds(21, 95, 705, 215);
        textField.setFont(new Font("Calibri", Font.PLAIN, 20));
        add(textField);

        trimite = new JButton("TRIMITE");
        trimite.setSize(new Dimension(149, 47));
        trimite.setBounds(21, 315, 149, 47);
        trimite.setBackground(Color.BLACK);
        trimite.setForeground(Color.WHITE);
        trimite.setFont(new Font("Calibri", Font.BOLD, 17));
        trimite.setBorderPainted(false);
        trimite.setContentAreaFilled(false);
        trimite.setFocusPainted(false);
        trimite.setOpaque(true);
        trimite.setMargin(new Insets(10, 10, 10, 10));
        add(trimite);

        trimite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText() != "") {
                    String text = textField.getText();
                    String sql = "INSERT INTO `carshopdb`.`raporturi` (`raport`) VALUES (' " + text + "');";
                    try {
                        PreparedStatement addStmt = connection.prepareStatement(sql);
                        addStmt.execute();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } finally {
                        textField.setText("");
                        JOptionPane.showMessageDialog(null, "Sesizarea a fost trimisa.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Trebuie sa scrii o sesizare.");
                }
            }
        });
    }
}
