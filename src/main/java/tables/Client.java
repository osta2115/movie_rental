package tables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name", length = 32)
    private String firstName;

    @Column(name = "last_name", length = 32)
    private String lastName;

    @Column(name = "phone_number", length = 9)
    private String phoneNumber;

    @Column(name = "email", length = 64)
    private String email;

    @Column(name = "postal_code", length = 6)
    private String postalCode;

    @Column(name = "address", length = 64)
    private String address;

    @Column(name = "login", length = 64)
    private String login;

    @Column(name = "admin")
    private Integer adminStatus;

    @Column(name = "password", length = 64)
    private String password;

    //private List<Rent> rents;

    boolean isPhoneNumberCorrect(String phoneNumber) {
        return phoneNumber.matches("[0-9]{9}");
    }

    boolean isEmailCorrect(String email) {
        return email.matches("[a-zA-Z0-9._]+\\@[a-zA-Z]+(\\.[a-zA-Z]+)*");
    }

    boolean isLoginCorrect(String login) {
        return login.isEmpty();
    }

    boolean isPasswordCorrect(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\[*.!@$%^&\\(\\)\\{\\}\\[\\]:;<>,.?/~_+-=|\\]).{8,64}");
    }

    boolean idPostalCodeCorrect(String postalCode) {
        return postalCode.matches("[0-9]{2}-{1}[0-9]{3}");
    }

}
