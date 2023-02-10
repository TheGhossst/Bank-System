package Bank;

import javax.swing.*;

import Bank.Model.User;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class Info {
    JFrame f;
    JTextField tf2, tf3;
    JPasswordField p1, p2;

    Info(User user) {
        init(user);
    }

    Connection connection = null;

    void init(User user) {

        f = new JFrame();
        f.setTitle("Information");
        f.getContentPane().setBackground(Color.black);
        f.setResizable(false);
        f.setBounds(100, 100, 820, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(null);

        JLabel l1 = new JLabel("Bank");
        l1.setFont(new Font("sans serif", Font.BOLD, 16));
        l1.setForeground(Color.white);
        l1.setBounds(10, 10, 145, 40);
        f.getContentPane().add(l1);

        JLabel l2 = new JLabel("Information");
        l2.setFont(new Font("sans serif", Font.BOLD, 15));
        l2.setForeground(Color.white);
        l2.setBounds(10, 50, 90, 25);
        f.getContentPane().add(l2);

        JButton b1 = new JButton("Withdraw");
        // b1.setFont(new Font("sans serif", Font.BOLD, 10));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Withdraw w = new Withdraw(user);
                w.f.setVisible(true);
                // t.main(null);
            }
        });
        b1.setBounds(10, 130, 90, 25);
        f.getContentPane().add(b1);

        JButton b3 = new JButton("Deposit");
        // b3.setFont(new Font("sans serif", Font.BOLD, 10));
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                Deposit d = new Deposit(user);
                d.f.setVisible(true);
            }
        });
        b3.setBounds(10, 160, 90, 25);
        f.getContentPane().add(b3);

        JButton b4 = new JButton("Delete");
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DBConnector d = new DBConnector();
                d.deleteAccount(user);
                JOptionPane.showMessageDialog(f, "Account deleted");
                f.dispose();
                Login l = new Login();
                l.f.setVisible(true);
            }
        });
        b4.setBounds(10, 190, 90, 25);
        f.getContentPane().add(b4);

        JLabel firstname = new JLabel(user.firstname);
        firstname.setFont(new Font("sans serif", Font.BOLD, 15));
        firstname.setForeground(Color.white);
        firstname.setBounds(268, 20, 240, 15);
        f.getContentPane().add(firstname);

        JLabel lastname = new JLabel(user.lastname);
        lastname.setFont(new Font("sans serif", Font.BOLD, 15));
        lastname.setForeground(Color.white);
        lastname.setBounds(520, 20, 240, 15);
        f.getContentPane().add(lastname);

        JPanel p = new JPanel();
        p.setBounds(120, 55, 650, 340);
        f.getContentPane().add(p);
        p.setBackground(Color.decode("#171313"));
        p.setLayout(null);

        JLabel acc = new JLabel("Account No:");
        acc.setForeground(Color.white);
        acc.setFont(new Font("sans serif", Font.BOLD, 15));
        acc.setBounds(10, 25, 100, 15);
        p.add(acc);

        JLabel acc1 = new JLabel(user.accno);
        acc1.setForeground(Color.white);
        acc1.setFont(new Font("sans serif", Font.PLAIN, 13));
        acc1.setBounds(120, 25, 70, 15);
        p.add(acc1);

        JLabel email = new JLabel("Email ID:");
        email.setForeground(Color.white);
        email.setFont(new Font("sans serif", Font.BOLD, 15));
        email.setBounds(10, 50, 70, 15);
        p.add(email);

        JLabel email1 = new JLabel(user.email);
        email1.setForeground(Color.white);
        email1.setFont(new Font("sans serif", Font.PLAIN, 13));
        email1.setBounds(120, 50, 140, 15);
        p.add(email1);

        JLabel phone = new JLabel("Phone No:");
        phone.setForeground(Color.white);
        phone.setFont(new Font("sans serif", Font.BOLD, 15));
        phone.setBounds(10, 100, 90, 15);
        p.add(phone);

        JLabel phone1 = new JLabel(user.phoneno);
        phone1.setForeground(Color.white);
        phone1.setFont(new Font("sans serif", Font.PLAIN, 13));
        phone1.setBounds(120, 100, 70, 15);
        p.add(phone1);

        JLabel gender = new JLabel("Gender:");
        gender.setForeground(Color.white);
        gender.setFont(new Font("sans serif", Font.BOLD, 15));
        gender.setBounds(10, 75, 70, 15);
        p.add(gender);

        JLabel gender1 = new JLabel(user.gender);
        gender1.setForeground(Color.white);
        gender1.setFont(new Font("sans serif", Font.PLAIN, 13));
        gender1.setBounds(120, 75, 90, 15);
        p.add(gender1);

        JLabel address = new JLabel("Address:");
        address.setForeground(Color.white);
        address.setFont(new Font("sans serif", Font.BOLD, 18));
        address.setBounds(40, 125, 90, 16);
        p.add(address);

        JLabel houseno = new JLabel("House No:");
        houseno.setForeground(Color.white);
        houseno.setFont(new Font("sans serif", Font.BOLD, 15));
        houseno.setBounds(10, 150, 90, 15);
        p.add(houseno);

        JLabel houseno1 = new JLabel(user.houseno);
        houseno1.setForeground(Color.white);
        houseno1.setFont(new Font("sans serif", Font.PLAIN, 13));
        houseno1.setBounds(120, 150, 80, 15);
        p.add(houseno1);

        JLabel city = new JLabel("City:");
        city.setForeground(Color.white);
        city.setFont(new Font("sans serif", Font.BOLD, 15));
        city.setBounds(10, 170, 90, 15);
        p.add(city);

        JLabel city1 = new JLabel(user.city);
        city1.setForeground(Color.white);
        city1.setFont(new Font("sans serif", Font.PLAIN, 13));
        city1.setBounds(120, 170, 70, 15);
        p.add(city1);

        JLabel zipcode = new JLabel("Zip Code:");
        zipcode.setForeground(Color.white);
        zipcode.setFont(new Font("sans serif", Font.BOLD, 15));
        zipcode.setBounds(10, 190, 90, 15);
        p.add(zipcode);

        JLabel zipcode1 = new JLabel(user.zipcode);
        zipcode1.setForeground(Color.white);
        zipcode1.setFont(new Font("sans serif", Font.PLAIN, 13));
        zipcode1.setBounds(120, 190, 80, 15);
        p.add(zipcode1);

        JLabel country = new JLabel("Country:");
        country.setForeground(Color.white);
        country.setFont(new Font("sans serif", Font.BOLD, 15));
        country.setBounds(10, 215, 90, 15);
        p.add(country);

        JLabel country1 = new JLabel(user.country);
        country1.setForeground(Color.white);
        country1.setFont(new Font("sans serif", Font.PLAIN, 13));
        country1.setBounds(120, 215, 80, 15);
        p.add(country1);

        JLabel occ = new JLabel("Occupation:");
        occ.setForeground(Color.white);
        occ.setFont(new Font("sans serif", Font.BOLD, 15));
        occ.setBounds(10, 275, 100, 15);
        p.add(occ);

        JLabel occ1 = new JLabel(user.occupation);
        occ1.setForeground(Color.white);
        occ1.setFont(new Font("sans serif", Font.PLAIN, 13));
        occ1.setBounds(120, 275, 120, 15);
        p.add(occ1);

        JLabel dob = new JLabel("DOB:");
        dob.setForeground(Color.white);
        dob.setFont(new Font("sans serif", Font.BOLD, 15));
        dob.setBounds(350, 25, 100, 15);
        p.add(dob);

        JLabel dob1 = new JLabel(user.dob);
        dob1.setForeground(Color.white);
        dob1.setFont(new Font("sans serif", Font.PLAIN, 13));
        dob1.setBounds(480, 25, 100, 15);
        p.add(dob1);

        JLabel nationality = new JLabel("Nationality:");
        nationality.setForeground(Color.white);
        nationality.setFont(new Font("sans serif", Font.BOLD, 15));
        nationality.setBounds(350, 50, 100, 18);
        p.add(nationality);

        JLabel nationality1 = new JLabel(user.nationality);
        nationality1.setForeground(Color.white);
        nationality1.setFont(new Font("sans serif", Font.PLAIN, 13));
        nationality1.setBounds(480, 50, 120, 15);
        p.add(nationality1);

        JLabel birthplace = new JLabel("Birth Place:");
        birthplace.setForeground(Color.white);
        birthplace.setFont(new Font("sans serif", Font.BOLD, 15));
        birthplace.setBounds(350, 85, 120, 15);
        p.add(birthplace);

        JLabel birthplace1 = new JLabel(user.birthplace);
        birthplace1.setForeground(Color.white);
        birthplace1.setFont(new Font("sans serif", Font.PLAIN, 13));
        birthplace1.setBounds(480, 85, 120, 15);
        p.add(birthplace1);

        JLabel bic = new JLabel("BIC:");
        bic.setForeground(Color.white);
        bic.setFont(new Font("sans serif", Font.BOLD, 15));
        bic.setBounds(350, 260, 90, 15);
        p.add(bic);

        JLabel bic1 = new JLabel(user.bic);
        bic1.setForeground(Color.white);
        bic1.setFont(new Font("sans serif", Font.PLAIN, 13));
        bic1.setBounds(480, 260, 90, 15);
        p.add(bic1);

        JLabel iban = new JLabel("IBAN:");
        iban.setForeground(Color.white);
        iban.setFont(new Font("sans serif", Font.BOLD, 15));
        iban.setBounds(420, 160, 90, 15);
        p.add(iban);

        JLabel iban1 = new JLabel(user.iban);
        iban1.setForeground(Color.white);
        iban1.setFont(new Font("sans serif", Font.PLAIN, 13));
        iban1.setBounds(350, 200, 190, 15);
        p.add(iban1);

        JLabel bal = new JLabel("BALANCE:");
        bal.setForeground(Color.white);
        bal.setFont(new Font("sans serif", Font.BOLD, 15));
        bal.setBounds(230, 420, 230, 15);
        f.getContentPane().add(bal);

        JLabel bal1 = new JLabel(user.balance);
        bal1.setForeground(Color.white);
        bal1.setFont(new Font("sans serif", Font.PLAIN, 13));
        bal1.setBounds(320, 420, 230, 15);
        f.getContentPane().add(bal1);
    }
}
