import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class IMG  {
    private JButton ExitButton;
    private JPanel IMGpanel;
    private JLabel ImageLabel;
    private JButton backButton;
   private JFrame frame = new JFrame();

    public IMG() throws SQLException {

       /* Table t = new Table();
        DBService DB= new DBService();
        //setLayout(new FlowLayout());
        ImageIcon ı;
        // DB.listPath(t.getList().getSelectedIndex())
        ı = new ImageIcon(DB.listPath(t.getList().getSelectedIndex()));
        getImageLabel().setIcon(new ImageIcon(String.valueOf(ı)));
        getFrame().setContentPane(getIMGpanel());
        getFrame().setVisible(true);
        getFrame().setSize(1000, 900);
        getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/


        //  frameImg.setContentPane(new IMG().getIMGpanel());
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
               }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
getFrame().dispose();
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
    public JPanel getIMGpanel() {
        return IMGpanel;
    }
    public JLabel getImageLabel() {
        return ImageLabel;
    }
    public void main(String args[]) throws SQLException {
      JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new IMG().getIMGpanel());
        frame.pack();
        frame.setVisible(true);
    }
}