import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Display {
    private JPanel DisplayPanel;
    private JList list;
    private JLabel del;
    private JLabel back;

    DbService db = new DbService();
    String value;

    public Display(JFrame frame) throws SQLException {
        loadList();
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 1) {
                    value = (String) list.getSelectedValue();
                }
            }
        });

        del.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    db.DeletefromDB(value);
                    loadList();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setContentPane(new Menu( frame).getMenuPanel());
                frame.setVisible(true);
                frame.pack();
            }
        });
    }

    private void loadList() throws SQLException {
        DefaultListModel modelList = new DefaultListModel();
        list.setModel(modelList);
        db.Display(modelList);
    }

    public JPanel getDisplayPanel() {
        return DisplayPanel;
    }
}