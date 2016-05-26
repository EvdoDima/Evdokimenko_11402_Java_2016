package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.rep.CustomerRep;
import ru.kpfu.itis.rep.DriversRep;
import ru.kpfu.itis.rep.UserRep;
import ru.kpfu.itis.rep.UserRoleRep;
import ru.kpfu.itis.security.AuthProviderImpl;
import ru.kpfu.itis.service.UserService;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRep userRep;

    @Autowired
    private UserRoleRep userRoleRep;

    @Autowired
    private CustomerRep customerRep;

    @Autowired
    private DriversRep driversRep;

    @Override
    public Page<UsersEntity> getAllUsers(PageRequest pageRequest) {
        return userRep.findAll(pageRequest);
    }

    @Override
    public UsersEntity getUserById(long id) {
        return userRep.findOneById(id);
    }

    @Override
    public UsersEntity getUserByLogin(String login) {
        return userRep.findOneByLogin(login);
    }

    @Override
    @Transactional
    public long saveNewUser(RegistrationForm form) {

        UsersEntity userModel = form.transformToUserModel();
        userRep.save(userModel);

        UserRoleEntity userProfileModel = form.transformToUserRoleEntity(userModel);
        userRoleRep.save(userProfileModel);

        customerRep.save(form.transformToCustomerEntity(userModel));


        return userModel.getId();
    }

    @Override
    @Transactional
    public long saveNewUser(DriverRegister form){

        UsersEntity userModel = form.transformToUserModel();
        userRep.save(userModel);

        UserRoleEntity userProfileModel = form.transformToUserRoleEntity(userModel);
        userRoleRep.save(userProfileModel);


        driversRep.save(form.transformToDriversEntity(userModel));


        return userModel.getId();
    }

    @Override
    @Transactional
    public void saveNewUser(UsersEntity usersEntity) {
        usersEntity.getDriver().setUser(usersEntity);
        usersEntity.getRole().setUser(usersEntity);
        userRep.save(usersEntity);
    }


}
