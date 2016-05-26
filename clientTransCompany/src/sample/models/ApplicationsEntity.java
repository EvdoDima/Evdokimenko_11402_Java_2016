package sample.models;

import javax.persistence.*;

/**
 * Created by evdodima on 16/04/16.
 * 11-402
 */
public class ApplicationsEntity {
    private long id;
    private int summ;
    private String description;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private CustomersEntity customer;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public CustomersEntity getCustomer(){
        return customer;
    }

    public void setCustomer(CustomersEntity customer) {
        this.customer = customer;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationsEntity that = (ApplicationsEntity) o;

        if (id != that.id) return false;
        if (summ != that.summ) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return customer != null ? customer.equals(that.customer) : that.customer == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + summ;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }
}
