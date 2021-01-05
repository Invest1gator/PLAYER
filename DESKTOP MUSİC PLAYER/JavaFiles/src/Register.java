import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {
    private JPanel RegisterPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel home;
    private JLabel register;
    private JLabel cancel;

    DbService db = new DbService();

    public Register() {
        JFrame frame = new JFrame();
        frame.setContentPane(getRegisterPanel());
        frame.setVisible(true);
        frame.setTitle(" R E G I S T E R ");
        frame.pack();

        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();

                Login l =new Login();
            }
        });
        register.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                db.Register(textField1, textField2, textField3, textField4);
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.dispose();
            }
        });
    }
    public JPanel getRegisterPanel() {
        return RegisterPanel;
    }
}
