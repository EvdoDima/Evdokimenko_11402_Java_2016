package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.rep.CustomerRep;
import ru.kpfu.itis.rep.DriversRep;
import ru.kpfu.itis.service.DriversService;

import java.util.List;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
@Service
public class DriversServiceImpl implements DriversService {
    @Autowired
    DriversRep driversRep;

    @Override
    public List<DriversEntity> getAll() {
        return driversRep.findAll();
    }


    @Override
    @Transactional
    public long saveNewDriver(DriverRegister form, UsersEntity user) {

        DriversEntity driversEntity = form.transformToDriversEntity(user);
        driversRep.save(driversEntity);

        return driversEntity.getId();
    }

    @Override
    public long countAll() {
        return driversRep.count();
    }
}
