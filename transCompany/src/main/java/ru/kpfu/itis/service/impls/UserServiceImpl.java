package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.rep.UserRep;
import ru.kpfu.itis.rep.UserRoleRep;
import ru.kpfu.itis.service.UserService;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRep userRepository;

    @Autowired
    private UserRoleRep userRoleRep;

    @Override
    public Page<UsersEntity> getAllUsers(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    @Override
    public UsersEntity getUserById(long id) {
        return userRepository.findOneById(id);
    }

    @Override
    public UsersEntity getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    @Transactional
    public long saveNewUser(RegistrationForm form) {
        UsersEntity userModel = form.transformToUserModel();
        userRepository.save(userModel);

        UserRoleEntity userProfileModel = form.transformToUserRoleEntity(userModel);
        userRoleRep.save(userProfileModel);

        return userModel.getId();
    }


}
