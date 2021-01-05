import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
// SERKAN KOÇOĞLU 17070006004  -- SCHEMA NAME : pngdata
public class Table  {
    private JPanel Panel;
    public JTable Table;
    private JList list;
    IMG I = new IMG();
    DBService DB= new DBService();
    public Table() throws SQLException {

        LoadList();
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    ImageIcon ı;
                    try {
                        ı = new ImageIcon(DB.listPath(list.getSelectedIndex()));
                        I.getImageLabel().setIcon(new ImageIcon(String.valueOf(ı)));
                        I.getFrame().setContentPane(I.getIMGpanel());
                        I.getFrame().setVisible(true);
                        I.getFrame().setSize(1000, 900);
                        I.getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public final void LoadList() throws SQLException {
        DBService DB= new DBService();
        //frameInit();
        String  columns[] = {"","",""};
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
       model.setColumnIdentifiers(columns);

        DefaultListModel modelList = new DefaultListModel();
        list.setModel(modelList);

        DB.getInfo(model,modelList);
    }
    public JPanel getPanel() {
        return Panel;
    }

    public JList getList() {
        return list;
    }

    public static void main(String[] args) throws SQLException {
        JFrame frame = new JFrame();
            frame.setContentPane(new Table().getPanel());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

    }
}
