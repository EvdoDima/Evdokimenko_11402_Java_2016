package ru.kpfu.itis.service;

import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UsersEntity;

import java.util.List;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
public interface DriversService {
    List<DriversEntity> getAll();

    @Transactional
    long saveNewDriver(DriverRegister form, UsersEntity user);
}
