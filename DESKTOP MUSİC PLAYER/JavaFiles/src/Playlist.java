import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Playlist {
    private JList list1;
    private JPanel DisPanel;
    private JLabel back;
    private JButton backButton;
    DbService db = new DbService();

    public Playlist(JFrame frame) throws SQLException {
        loadList();

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setContentPane(new Menu(frame).getMenuPanel());
                frame.setVisible(true);
                frame.pack();
            }
        });
    }

    private void loadList() throws SQLException {
        DefaultListModel modelList = new DefaultListModel();
        list1.setModel(modelList);  //list 1 is a model list anymore
        db.DisPlaylist(modelList);
    }

    public JPanel getDisPanel() {
        return DisPanel;
    }
}
