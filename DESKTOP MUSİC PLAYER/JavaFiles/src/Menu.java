import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Menu extends Container {

    private JPanel menuPanel;
    private JLabel select;
    private JLabel showAll;
    private JLabel addSong;
    private JLabel displayPlaylist;

    public Menu(JFrame frame) {

        select.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    frame.setContentPane(new SelectMusic(frame).getSelectMusicPanel());
                    frame.setTitle(" SELECT MUSİC  🎷");
                    frame.setVisible(true);
                    frame.pack();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        showAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    frame.setContentPane(new Display(frame).getDisplayPanel());
                    frame.setTitle(" Song List "+ " 🎷");
                    frame.pack();
                    frame.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        addSong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.setContentPane(new AddSong(frame).getAddSongPanel());
                frame.setTitle(" Add Song ✔");
                frame.pack();
                frame.setVisible(true);
            }
        });
        displayPlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    frame.setContentPane(new Playlist(frame).getDisPanel());
                    frame.setTitle(" My  Playlist  ♪");
                    frame.setVisible(true);
                    frame.pack();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public JPanel getMenuPanel() {
        return menuPanel;
    }


}
