package Bank;

import java.awt.Color;
import javax.swing.*;

import Bank.Model.User;

import java.awt.event.*;
import java.awt.Font;

public class Deposit {
    JFrame f;
    DBConnector d = new DBConnector();

    Deposit(User user) {
        init(user);
    }

    void init(User user) {

        f = new JFrame("Deposit");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 100, 576, 438);
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
        f.getContentPane().setLayout(null);

        JLabel deposit = new JLabel("Deposit");
        deposit.setFont(new Font("sans serif", Font.BOLD, 20));
        deposit.setBounds(f.getWidth() / 2 - 40, 21, 160, 30);
        deposit.setForeground(Color.white);
        f.getContentPane().add(deposit);

        JLabel amount = new JLabel("Amount:");
        amount.setBounds(120, 90, 160, 30);
        amount.setFont(new Font("sans serif", Font.BOLD, 18));
        amount.setForeground(Color.white);
        f.add(amount);

        JTextField tf = new JTextField();
        tf.setBounds(260, 95, 160, 20);
        tf.setBorder(null);
        f.add(tf);

        JLabel balance = new JLabel("Balance:");
        balance.setBounds(160, 160, 90, 30);
        balance.setFont(new Font("sans serif", Font.BOLD, 20));
        balance.setForeground(Color.white);
        f.add(balance);

        JLabel balanceamount = new JLabel(user.balance);
        balanceamount.setBounds(260, 160, 170, 30);
        balanceamount.setFont(new Font("sans serif", Font.BOLD, 18));
        balanceamount.setForeground(Color.white);
        f.add(balanceamount);

        JButton b = new JButton("Deposit");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dep = Integer.parseInt(tf.getText());
                int bal = Integer.parseInt(user.balance);
                bal += dep;
                user.balance = String.valueOf(bal);
                balanceamount.setText(user.balance);
                d.updateBalance(user);
                // System.out.println(dep);
            }
        });
        b.setBounds(220, 300, 90, 30);
        f.add(b);

        JButton b1 = new JButton("Back");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.closeConnection();
                f.dispose();
                Info i = new Info(user);
                i.f.setVisible(true);
            }
        });
        b1.setBounds(6, 370, 80, 30);
        f.getContentPane().add(b1);
    }

}
