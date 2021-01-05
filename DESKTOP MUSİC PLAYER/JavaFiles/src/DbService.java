import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DbService {
    static String CurrentCustomerName = "";

    String url = "jdbc:mysql://localhost:3306/sekotify?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    String user = "root";
    String password = "123456";
    ArrayList<String> TypeList = new ArrayList();

    public Connection connect() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            connection = null;
        }
        return connection;
    }

    public void Register(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4) {
        JFrame f = new JFrame();
        try {
            Connection connection = connect();
            String query = "insert into sekotify.customer (username,password,name,surname) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);

            if (!textField1.getText().equals("") && !textField2.getText().equals("") && !textField3.getText().equals("") && !textField4.getText().equals("")) {
                statement.setString(1, textField1.getText());
                statement.setString(2, textField2.getText());
                statement.setString(3, textField3.getText());
                statement.setString(4, textField4.getText());
                statement.execute();
                JOptionPane.showMessageDialog(f, "Registered Succesfully");
            } else {
                JOptionPane.showMessageDialog(f, "Fill all fields !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean Login(JTextField textField1, JTextField textField2) {
        String username = textField1.getText();
        String password = textField2.getText();
        Connection connection = connect();
        try {
            String query = "select userName,password from sekotify.customer where userName='" + username + "' and password='" + password + "'  ";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                setCurrentCustomerName(username);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getListForTypeCombo() throws SQLException {
        Connection connection = connect();
        Statement st = connection.createStatement();
        String type = "";

            String query = "select distinct songType from sekotify.song ;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                type = rs.getString(1);
                TypeList.add( type);
        }
    }

    public void Display(DefaultListModel modelList) throws SQLException {
        Connection connection = connect();
        PreparedStatement find = connection.prepareStatement("select songName from song"); // songType artist de ekle
        ResultSet rs = find.executeQuery();

        while (rs.next()) {
            String name = rs.getString("songName");
            name.split(".");

            modelList.addElement("" + name);
        }
    }

    public void DeletefromDB(String value) throws SQLException {
        Connection connection = connect();
        Statement st2 = connection.createStatement();
        String query = "DELETE FROM sekotify.song WHERE songName = '" + value + "';";
        st2.executeUpdate(query);
    }

    public void AddSongDB(String textField1Text, String textField2Text, String textField3Text) throws SQLException {
        Connection connection = connect();
        Statement st = connection.createStatement();
        String query = "INSERT INTO `sekotify`.`song` (`songName`, `songType`, `artist`) VALUES ("+ "'" + textField3Text + ".wav'" + "," + "'" + textField1Text + "'" + "," + "'" + textField2Text + "'" + ");";
        st.execute(query);
    }

    public void addtoPlayList(String sarkiadi) throws SQLException {
        String CurrUserName = getCurrentCustomerName();
        Connection connection = connect();
        Statement st = connection.createStatement();
        String query = "INSERT INTO `sekotify`.`playlist` (`username`, `songName`) VALUES (" + "'" + CurrUserName + "'" + "," + "'" + sarkiadi + "'" + ");";
        st.execute(query);
    }

    public void RemovefromPlayList(String sarkiadi) throws SQLException {
        String CurrUserName = getCurrentCustomerName();
        Connection connection = connect();
        Statement st2 = connection.createStatement();
        String query = "DELETE FROM sekotify.playlist WHERE songName = '" + sarkiadi + "' " + "and username = " + "'" + CurrUserName + "';";
        st2.executeUpdate(query);
    }

    public void DisPlaylist(DefaultListModel modelList) throws SQLException {
        String CurrUserName = getCurrentCustomerName();
        System.out.println(CurrUserName);
        Connection connection = connect();
        PreparedStatement find = connection.prepareStatement("select distinct songName from playlist where username = " + "'" + CurrUserName + "';");
        ResultSet rs = find.executeQuery();

        while (rs.next()) {
            String name = rs.getString("songName");
            name.split(".");

            modelList.addElement("" + name);
        }
    }
    public String getCurrentCustomerName() {
        return CurrentCustomerName;
    }
    public void setCurrentCustomerName(String currentCustomerName) {
        CurrentCustomerName = currentCustomerName;
    }
}