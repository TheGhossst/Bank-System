package Bank;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import Bank.Model.User;

public class Login {
    JFrame f;
    JTextField tf;
    JPasswordField p;
    String email;
    DBConnector db = new DBConnector();

    Login() {
        init();
    }

    public static void main(String[] args) {
        Login w = new Login();
        w.f.setVisible(true);

    }

    void init() {

        f = new JFrame();
        f.setBounds(100, 100, 450, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
        f.getContentPane().setLayout(null);

        JLabel l = new JLabel("Stonks Savings & Loan");
        l.setForeground(Color.white);
        l.setFont(new Font("sans serif", Font.BOLD, 18));
        l.setBounds(130, 10, 250, 30);
        f.getContentPane().add(l);

        JLabel l1 = new JLabel("Email ID:");
        l1.setForeground(Color.white);
        l1.setFont(new Font("sans serif", Font.BOLD, 13));
        l1.setBounds(70, 70, 90, 20);
        f.getContentPane().add(l1);

        tf = new JTextField();
        tf.setBounds(170, 75, 170, 20);
        f.getContentPane().add(tf);
        tf.setColumns(5);

        p = new JPasswordField();
        p.setBounds(170, 120, 170, 20);
        f.getContentPane().add(p);

        JLabel l2 = new JLabel("Password:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("sans serif", Font.BOLD, 13));
        l2.setBounds(63, 114, 89, 14);
        f.getContentPane().add(l2);

        JButton b = new JButton("Login!");
        b.setFont(new Font("sans serif", Font.BOLD, 13));
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                email = tf.getText();
                String password = String.valueOf(p.getPassword());
                User user = db.getUser(email, password);
                if (user == null) {
                    JOptionPane.showMessageDialog(f, "Account doesnt not exist");
                } else {
                    db.closeConnection();
                    f.dispose();
                    Info i = new Info(user);
                    i.f.setVisible(true);
                }

            }
        });
        b.setBounds(180, 180, 90, 30);
        f.getContentPane().add(b);
    }
}
