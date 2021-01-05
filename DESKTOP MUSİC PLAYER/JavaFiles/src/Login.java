import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends javax.swing.JFrame {
    DbService db = new DbService();
    boolean succesful;
    private JTextField textField1;
    private JPanel loginPanel;
    private JTextField textField2;
    private JLabel register;
    private JLabel login;
    private JLabel exit;

    public Login() {
        JFrame frame = new JFrame();
        frame.setContentPane(getLoginPanel());
        frame.setTitle(" L O G I N  ✮" );

        frame.setVisible(true);
        frame.pack();

        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
                Register r = new Register();
            }
        });

        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                succesful = db.Login(textField1, textField2);
                if (succesful) {
                    frame.setTitle( " S E C O T I F Y  "+"🎼" );
                    frame.setContentPane(new Menu(frame).getMenuPanel());
                    frame.setVisible(true);
                    frame.pack();
                } else {
                    JOptionPane.showMessageDialog(loginPanel, "Username and Password did not match,try again or register ! ");
                }
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

    public JPanel getLoginPanel() {
        return loginPanel;
    }
}