package sample.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

/**
 * Created by evdodima on 18/04/16.
 * 11-402
 */
@Entity
@Table(name = "users", schema = "public", catalog = "transCompany")
public class UsersEntity {
    private long id;
    private StringProperty login;
    private String password;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    private DriversEntity driver;

    @OneToOne( mappedBy = "user", cascade = CascadeType.ALL)
    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {

        this.customer = customer;

    }


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public DriversEntity getDriver() {
        return driver;
    }

    public void setDriver(DriversEntity driver) {
        this.driver = driver;
    }

    private CustomersEntity customer;


    @Column(name = "login", nullable = false)
    public StringProperty getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = new SimpleStringProperty( login);
    }


    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
