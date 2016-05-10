package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.forms.NewCarsForm;
import ru.kpfu.itis.models.CarsEntity;
import ru.kpfu.itis.rep.CarsRep;
import ru.kpfu.itis.service.CarsService;

import java.util.List;

/**
 * Created by evdodima on 09/05/16.
 * 11-402
 */
@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsRep carsRep;

    @Override
    public List<CarsEntity> getAll() {
        return carsRep.findAll();
    }

    @Override
    public void saveNewCar(NewCarsForm form) {
        carsRep.save(form.transformToCarsEntity());
    }
}
