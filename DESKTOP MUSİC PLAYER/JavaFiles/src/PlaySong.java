import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

public class PlaySong extends Container {

    private JPanel playPanel;

    private JLabel addToPlaylistLabel;
    private JLabel music;
    private JLabel play_pause;
    private JLabel lowerSound;
    private JLabel IncreaseSound;
    private JLabel removeFromPlaylist;
    private JLabel back;
    private JLabel exit;
    private JLabel vol;

    DbService db = new DbService();
    boolean Play;

    public PlaySong(String para, JFrame otherFrame) throws LineUnavailableException {
        Utility u = new Utility();
        play_pause.setEnabled(false);

        otherFrame.setContentPane(getPlayPanel());
        otherFrame.setVisible(true);
        otherFrame.setTitle(" P L A Y E R   " + "🎶");
        otherFrame.pack();

        music.setText(para);
        Play = false;

        play_pause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (Play) {
                    try {
                        u.Pause();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    }
                    play_pause.setEnabled(false);
                    Play = false;

                } else {

                    try {
                        u.Play(para);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    }
                    play_pause.setEnabled(true);
                    Play = true;
                }
            }
        });
        lowerSound.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                lowerSound.requestFocus();
                u.VolumeDown();
                vol.setText("%"+u.getVolume());
                lowerSound.setVisible(true);
            }
        });
        IncreaseSound.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                IncreaseSound.setEnabled(false);
                u.VolumeUp();
                vol.setText("%"+u.getVolume());
                IncreaseSound.setEnabled(true);
            }
        });
        addToPlaylistLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    db.addtoPlayList(para);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        removeFromPlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    db.RemovefromPlayList(para);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                otherFrame.setContentPane(new Menu(otherFrame).getMenuPanel());
                otherFrame.setVisible(true);
                otherFrame.pack();
            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });
    }
    public JPanel getPlayPanel() {
        return playPanel;
    }
}