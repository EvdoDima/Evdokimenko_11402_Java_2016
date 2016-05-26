package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.forms.NewApplicationForm;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.rep.ApplicationsRep;
import ru.kpfu.itis.service.ApplicationService;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationsRep applicationsRep;

    @Override
    public List<ApplicationsEntity> getAll() {
        return applicationsRep.findAll();
    }

    @Override
    public ApplicationsEntity getApplicationByName(String name) {
        return applicationsRep.findOneByName(name);
    }

    @Override
    public long saveNewApplication(NewApplicationForm form, UsersEntity usersEntity) {
        applicationsRep.save(form.transformToApplicationEntity(usersEntity));
        return 0;
    }

    @Override
    public long countAll() {
       return applicationsRep.count();
    }

    @Override
    public ApplicationsEntity getOneById(Integer id) {
      return   applicationsRep.findOne(Long.valueOf(id));
    }

    @Override
    public void deleteOneById(Integer id) {
        applicationsRep.delete(applicationsRep.getOne(Long.valueOf(id)));
    }

    @Override
    public void saveNewApplication(ApplicationsEntity applicationsEntity) {
        applicationsRep.save(applicationsEntity);
    }
}
