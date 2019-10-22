package Model;






import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity(name = "x")

public class User  implements Serializable {
    @Id
    @GeneratedValue

    private Integer Id;
    @Column(length=50)

    private String firstName;
    @Column(length=50)

    private String lastName;
    @Column(length=30)

    private String email;
    @Column(length=15)

    private String phoneNumber;

    @Column
    private LocalDateTime date;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "x{" +
                "id=" + Id +
                ", FirstName='" + firstName +",LastName="+lastName+",Email="+email+",PhoneNumber="+phoneNumber+",Date="+date+ '\'' +
                '}';
    }
}
