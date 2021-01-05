import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
public class DBService {

// SERKAN KOÇOĞLU 17070006004    -- SCHEMA NAME : pngdata
        String url = "jdbc:mysql://localhost:3306/ımgdata?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        String user = "root";
        String password = "123456";

        ArrayList<String> PNGList = new ArrayList();
private ResultSet rs;

    public DBService() throws SQLException {
    }

    private Connection connect() {
            Connection connection;
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                connection = null;
            }
            return connection;
        }

    public String listPath(int index) throws SQLException {
        String path="";
        index++;
        Connection connection = connect();
        PreparedStatement find = connection.prepareStatement("select path from ımgdata.detail where id ="+ index  );
        rs = find.executeQuery();

        while (rs.next()) {
            path = rs.getString("Path");
            System.out.println(path);
        }
        return path;
    }

    public void getInfo( DefaultTableModel model, DefaultListModel modelList) throws SQLException {
        Connection connection = connect();
      //  Object  columns[] = {"Image Id","Image Name","Image Path"};
        ResultSetMetaData rsmd;

        PreparedStatement find = connection.prepareStatement("select * from ımgdata.detail");
        rs = find.executeQuery();
        rsmd = rs.getMetaData();
        int ColCount = rsmd.getColumnCount();
        Object[] objects = new Object[ColCount];

        int counter =0;
        while (rs.next()) {
            counter++;
            for (int i = 1; i <= ColCount; i++) {
                objects[i - 1] = rs.getObject(i);
            }
            model.addRow(objects);
      //      model.setColumnIdentifiers(columns);

            String name = rs.getString("Name");
            String path = rs.getString("Path");
            if(counter>1 ) {
                modelList.addElement(path + "--->" + name);
            }
        }
    }

   /* public String IMGPATH(DefaultTableModel model, DefaultListModel modelList,int index) throws SQLException {
        String path="";
        Connection connection = connect();
        ResultSetMetaData rsmd;
        PreparedStatement find = connection.prepareStatement("select * from ımgdata.detail");
        rs = find.executeQuery();
        rsmd = rs.getMetaData();
        int ColCount = rsmd.getColumnCount();
        while (rs.next()) {
            Object[] objects = new Object[ColCount];
                objects[index+2] = rs.getObject(index+2);
            model.addRow(objects);
            path = rs.getString("Path");
    }
        return path;
}*/
}
