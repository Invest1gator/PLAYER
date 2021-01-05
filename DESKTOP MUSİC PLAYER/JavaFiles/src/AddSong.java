import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class AddSong {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel AddSongPanel;
    private JLabel add;
    private JLabel back;


    public AddSong(JFrame frame) {
        DbService db = new DbService();
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    db.AddSongDB(getTextField1Text(), getTextField2Text(), getTextField3Text());
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

    public String getTextField1Text() {
        return textField1.getText();
    }

    public String getTextField2Text() {
        return textField2.getText();
    }

    public String getTextField3Text() {
        return textField3.getText();
    }

    public JPanel getAddSongPanel() {
        return AddSongPanel;
    }
}
