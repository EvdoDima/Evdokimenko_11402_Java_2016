package sample.models;

import javax.persistence.*;

/**
 * Created by evdodima on 18/04/16.
 * 11-402
 */
@Entity
@Table(name = "users", schema = "public", catalog = "transCompany")
public class UsersEntity {
    private long id;
    private UserRoleEntity role;
    private String login;
    private String password;
    private DriversEntity driver;



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
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    public UserRoleEntity getRole() {
        return role;
    }


    public void setRole(UserRoleEntity role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (driver != null ? !driver.equals(that.driver) : that.driver != null) return false;
        return customer != null ? customer.equals(that.customer) : that.customer == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "customer=" + customer +
                ", id=" + id +
                ", role=" + role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", driver=" + driver +
                '}';
    }
}
