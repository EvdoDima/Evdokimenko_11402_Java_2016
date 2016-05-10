package ru.kpfu.itis.service;

import ru.kpfu.itis.forms.NewCarsForm;
import ru.kpfu.itis.models.CarsEntity;

import java.util.List;

/**
 * Created by evdodima on 09/05/16.
 * 11-402
 */
public interface CarsService {



    List<CarsEntity> getAll();

    void saveNewCar(NewCarsForm form);

    List<CarsEntity> getCarsByState(String state);
}
