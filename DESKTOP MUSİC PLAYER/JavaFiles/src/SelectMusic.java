import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SelectMusic {

    private JPanel SelectMusicPanel;
    private JComboBox MusicType;
    private JComboBox chooseArtist;
    private JComboBox Song;
    ArrayList<String> ArtistList = new ArrayList();
    ArrayList<String> SongList = new ArrayList();
    DbService db = new DbService();

    public SelectMusic(JFrame otherFrame) throws SQLException {

        db.getListForTypeCombo(); //TypeList filled
        MusicType.setModel(new DefaultComboBoxModel<>(db.TypeList.toArray(new String[db.TypeList.size()]))); // MusicType combo filled

        MusicType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    MusicTypebyCombo();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                chooseArtist.setModel(new DefaultComboBoxModel<>(ArtistList.toArray(new String[ArtistList.size()]))); //Artist combo filled
            }
        });
        chooseArtist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ArtistbyCombo();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Song.setModel(new DefaultComboBoxModel<>(SongList.toArray(new String[SongList.size()]))); // Song combo filled
            }
        });
        Song.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String songNameFromCombo = (String) Song.getSelectedItem();

                try {
                    new PlaySong(songNameFromCombo, otherFrame);
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void MusicTypebyCombo() throws SQLException {
        String namecombo = (String) MusicType.getSelectedItem();
        Connection connection = db.connect();
        Statement st = connection.createStatement();

        String Query = "select distinct artist from sekotify.song where songType = '" + namecombo + "';";
        ResultSet rs = st.executeQuery(Query);

        String type = "";
        while (rs.next()) {
            type = rs.getString(1);
            ArtistList.add(type);
        }
    }

    public void ArtistbyCombo() throws SQLException {  // Provides songName
        String namecombo = (String) chooseArtist.getSelectedItem();
        String Query = "select songName from sekotify.song where artist = " + "'" + namecombo + "'" + ";";
        Connection connection = db.connect();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(Query);
        String songName = "";
        while (rs.next()) {
            songName = rs.getString(1);
            SongList.add(songName);
        }
    }

    public JPanel getSelectMusicPanel() {
        return SelectMusicPanel;
    }
}