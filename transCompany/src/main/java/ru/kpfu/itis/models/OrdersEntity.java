package ru.kpfu.itis.models;

import javax.persistence.*;

/**
 * Created by evdodima on 16/04/16.
 * 11-402
 */
@Entity
@Table(name = "orders", schema = "public", catalog = "transcompany")
public class OrdersEntity {
    private long id;
    private String description;
    private int cost;
    private String status;
    private CustomersEntity customer;
    private DriversEntity driver;
    private CarsEntity car;

    @ManyToOne(targetEntity = CarsEntity.class)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public CarsEntity getCar() {
        return car;
    }

    public void setCar(CarsEntity car) {
        this.car = car;
    }


    @ManyToOne(targetEntity = CustomersEntity.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public CustomersEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomersEntity costomer) {
        this.customer = costomer;
    }

    @ManyToOne(targetEntity = DriversEntity.class)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    public DriversEntity getDriver() {
        return driver;
    }

    public void setDriver(DriversEntity driver) {
        this.driver = driver;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @SequenceGenerator(name = "orders_id_seq", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "cost")
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        if (driver != null ? !driver.equals(that.driver) : that.driver != null) return false;
        return car != null ? car.equals(that.car) : that.car == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (driver != null ? driver.hashCode() : 0);
        result = 31 * result + (car != null ? car.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "{/tr " +"/nOrder" +
                "id" +"{/td " +id+" }" +
                " : description = " +"{/td "+ description +" }"+
                ", cost = " +"{/td "+ cost+" }" +
                ", status = " +"{/td "+ status + " }"+
                ", customertel = " +"{/td "+ customer.getTelNumber()+" }" +
                ", drivertel = " +"{/td "+ driver.getTelNumber() +" }"+ ", car = "+"{/td "+car.getModel()+" }"+" }";
    }
}


