package ru.kpfu.itis.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.UsersEntity;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 *
 */

public interface UserService {
    Page<UsersEntity> getAllUsers(PageRequest pageRequest);

    UsersEntity getUserById(long id);

    UsersEntity getUserByLogin(String login);


    @Transactional
    long saveNewUser(RegistrationForm form);

    @Transactional
    long saveNewUser(DriverRegister form);

}
