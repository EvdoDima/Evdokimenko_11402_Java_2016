package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.rep.CustomerRep;
import ru.kpfu.itis.service.CustomersService;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
    CustomerRep customerRep;

    @Override
    public List<CustomersEntity> getAll() {
        return customerRep.findAll();
    }


    @Override
    @Transactional
    public long saveNewCustomer(RegistrationForm form, UsersEntity user) {

        CustomersEntity customersEntity = form.transformToCustomerEntity(user);
        customerRep.save(customersEntity);

        return customersEntity.getId();
    }

    @Override
    public long countAll() {
        return customerRep.count();
    }
}
