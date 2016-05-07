package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.UsersEntity;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
public interface CustomersService {

    public List<CustomersEntity> getAll();


    @Transactional
    long saveNewCustomer(RegistrationForm form, UsersEntity user);
}
