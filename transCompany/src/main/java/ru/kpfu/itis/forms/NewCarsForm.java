package ru.kpfu.itis.forms;

import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.CarsEntity;
import ru.kpfu.itis.models.UsersEntity;

/**
 * Created by evdodima on 09/05/16.
 * 11-402
 */
public class NewCarsForm {
     private String model;
    private int year;
    private int run;
    private String state;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CarsEntity transformToCarsEntity() {
        CarsEntity carsEntity = new CarsEntity();
        carsEntity.setModel(getModel());
        carsEntity.setYear(getYear());
        carsEntity.setRun(getRun());
        carsEntity.setState("Free");

        return carsEntity;
    }
    
}
