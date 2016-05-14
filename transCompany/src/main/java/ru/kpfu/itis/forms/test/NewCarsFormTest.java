package ru.kpfu.itis.forms.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.forms.NewCarsForm;
import ru.kpfu.itis.models.CarsEntity;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 14/05/16.
 * 11-402
 */
public class NewCarsFormTest {
    NewCarsForm newCarsForm;

    @Before
    public void setUp() throws Exception {
        newCarsForm = new NewCarsForm();
        newCarsForm.setModel("model");
        newCarsForm.setRun(1);
        newCarsForm.setYear(2);

    }

    @Test
    public void transformToCarsEntity() throws Exception {


        CarsEntity carsEntity = newCarsForm.transformToCarsEntity();

        Assert.assertEquals(carsEntity.getModel(), "model");
        Assert.assertEquals(carsEntity.getRun(), 1);
        Assert.assertEquals(carsEntity.getYear(), 2);
        Assert.assertEquals(carsEntity.getState(), "free");
    }
}