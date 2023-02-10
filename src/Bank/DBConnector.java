package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bank.Model.User;

public class DBConnector {
    static Connection connection = null;
    static Statement statement = null;
    ResultSet rs = null;

    public DBConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:userdata.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:userdata.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            statement.executeUpdate(
                    "create table accounts (id integer primary key autoincrement, email string , password string , username string , firstname string , lastname string , accno string , gender string , phoneno string , houseno string , city string , zipcode string , country string , occupation string , dob string , nationality string , birthplace string , iban string , bic string,balance string)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUser(String email, String password) {
        String query = "select * from accounts where email='" + email + "' and password ='" + password
                + "'";
        try {
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                return new User(rs.getString("email"), rs.getString("password"), rs.getString("username"),
                        rs.getString("firstname"), rs.getString("lastname"), rs.getString("accno"),
                        rs.getString("gender"), rs.getString("phoneno"), rs.getString("houseno"), rs.getString("city"),
                        rs.getString("zipcode"), rs.getString("country"), rs.getString("occupation"),
                        rs.getString("dob"), rs.getString("nationality"), rs.getString("birthplace"),
                        rs.getString("iban"), rs.getString("bic"), rs.getString("balance"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
     * public void setUser(String email, String password, String username) {
     * String query =
     * "insert into accounts(email,password,username,firstname,lastname,accno,gender,phoneno,houseno,city,zipcode,country,occupation,dob,nationality,birthplace,iban,bic,balance) values('"
     * + email + "'','" + password + "','" + username
     * +
     * "','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null','null')";
     * try {
     * statement.executeUpdate(query);
     * } catch (SQLException e) {
     * e.printStackTrace();
     * }
     * }
     */

    public void updateBalance(User user) {
        String query = "UPDATE accounts SET balance='" + user.balance + "'  WHERE email='" + user.email + "';";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(User user) {
        String query = "DELETE from accounts where email='" + user.email + "';";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}