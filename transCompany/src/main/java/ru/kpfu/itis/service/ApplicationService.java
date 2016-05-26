package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.forms.NewApplicationForm;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.UsersEntity;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
public interface ApplicationService {

    List<ApplicationsEntity> getAll();

    ApplicationsEntity getApplicationByName(String name);



    long saveNewApplication(NewApplicationForm form, UsersEntity usersEntity);

    long countAll();

    ApplicationsEntity getOneById(Integer id);

    void deleteOneById(Integer id);

    void saveNewApplication(ApplicationsEntity applicationsEntity);

    //void deleteOneById(Integer id);
}
