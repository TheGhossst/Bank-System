package Bank.Model;

public class User {
    public String email, password, username, firstname, lastname, accno, gender, phoneno, houseno, city, zipcode,
            country,
            occupation, dob, nationality, birthplace, iban, bic, balance;

    public User(String email, String password, String username, String firstname, String lastname, String accno,
            String gender, String phoneno, String houseno, String city, String zipcode, String country,
            String occupation, String dob, String nationality, String birthplace, String iban, String bic,
            String balance) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accno = accno;
        this.gender = gender;
        this.phoneno = phoneno;
        this.houseno = houseno;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
        this.occupation = occupation;
        this.dob = dob;
        this.nationality = nationality;
        this.birthplace = birthplace;
        this.bic = bic;
        this.iban = iban;
        this.balance = balance;
    }
}
