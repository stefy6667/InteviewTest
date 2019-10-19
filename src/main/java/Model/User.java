package Model;



import org.simpleframework.xml.*;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Root(name = "x")
@Entity(name = "x")

public class User  implements Serializable {
    @Id
    @GeneratedValue
    @Element
    private Integer Id;
    @Column(length=50)
    @Element
    private String firstName;
    @Column(length=50)
    @Element
    private String lastName;
    @Column(length=30)
    @Element
    private String email;
    @Column(length=15)
    @Element
    private String phoneNumber;
    @Element
    @Column
    private LocalDate date;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
