package sample.models;

import javax.persistence.*;

/**
 * Created by evdodima on 16/04/16.
 * 11-402
 */
@Entity
@Table(name = "cars", schema = "public", catalog = "transcompany")
public class CarsEntity {
    private long id;
    private String model;
    private int year;
    private int run;
    private String state;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Column(name = "run")
    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarsEntity that = (CarsEntity) o;

        if (id != that.id) return false;
        if (year != that.year) return false;
        if (run != that.run) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + run;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
