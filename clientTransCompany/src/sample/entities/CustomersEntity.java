package sample.entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by evdodima on 16/04/16.
 * 11-402
 */
@Entity
@Table(name = "customers", schema = "public", catalog = "transcompany")
public class CustomersEntity {
    private long id;
    private StringProperty name;
    private String lastname;
    private String telNumber;
    private List<OrdersEntity> orders;


    @Column(name = "lastname", nullable = false)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private UsersEntity user;
    private List<ApplicationsEntity> applications;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @OneToMany(targetEntity = OrdersEntity.class, mappedBy = "customer")
    public List<OrdersEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customers_id_seq")
    @SequenceGenerator(name = "customers_id_seq", sequenceName = "customers_id_seq", allocationSize = 1)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public StringProperty getName() {
        return name;
    }

    public void setName(String name) {
        this.name =new SimpleStringProperty( name);
    }

    @Column(name = "tel_number")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }


    @OneToMany(mappedBy = "customer")
    public List<ApplicationsEntity> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationsEntity> applications) {
        this.applications = applications;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (telNumber != null ? !telNumber.equals(that.telNumber) : that.telNumber != null) return false;
        if (orders != null ? !orders.equals(that.orders) : that.orders != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return applications != null ? applications.equals(that.applications) : that.applications == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (applications != null ? applications.hashCode() : 0);
        return result;
    }
}
