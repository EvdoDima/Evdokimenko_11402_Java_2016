package sample.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by evdodima on 16/04/16.
 * 11-402
 */


public class DriversEntity {
    private long id;
    private String firstName;
    private String lastName;
    private String telNumber;
    private int drivingExp;
    private double salaryRate;

    private UsersEntity user;




    private List<OrdersEntity> orders;

    @JsonIgnore
    public List<OrdersEntity> getOrders() {
        return orders;
    }

    @JsonIgnore

    public UsersEntity getUser(){return user;}
    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public void setOrders(List<OrdersEntity> orders) {
        this.orders = orders;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getDrivingExp() {
        return drivingExp;
    }

    public void setDrivingExp(int drivingExp) {
        this.drivingExp = drivingExp;
    }




    public double getSalaryRate() {
        return salaryRate;
    }

    public void setSalaryRate(double salaryRate) {
        this.salaryRate = salaryRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversEntity that = (DriversEntity) o;

        if (id != that.id) return false;
        if (drivingExp != that.drivingExp) return false;
        if (Double.compare(that.salaryRate, salaryRate) != 0) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (telNumber != null ? !telNumber.equals(that.telNumber) : that.telNumber != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return orders != null ? orders.equals(that.orders) : that.orders == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        result = 31 * result + drivingExp;
        temp = Double.doubleToLongBits(salaryRate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }
}
