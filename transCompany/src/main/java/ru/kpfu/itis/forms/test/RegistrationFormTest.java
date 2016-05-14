package ru.kpfu.itis.forms.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.security.AuthProviderImpl;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 14/05/16.
 * 11-402
 */
public class RegistrationFormTest {
    RegistrationForm registrationForm;

    @Before
    public void setUp() throws Exception {
        registrationForm = new RegistrationForm();
        registrationForm.setName("name");
        registrationForm.setLogin("login");
        registrationForm.setPassword("password");
        registrationForm.setRepassword("repassword");
        registrationForm.setTelnumber("tel");
        registrationForm.setLastname("lastname");


    }

    @Test
    public void transformToUserModel() throws Exception {
        UsersEntity usersEntity = registrationForm.transformToUserModel();

        Assert.assertEquals(usersEntity.getLogin(),"login");
//        Assert.assertEquals(usersEntity.getPassword(), AuthProviderImpl.getEncoder().encode("password"));
    }

    @Test
    public void transformToUserRoleEntity() throws Exception {
        UsersEntity usersEntity = new UsersEntity();
        UserRoleEntity userRoleEntity = registrationForm.transformToUserRoleEntity(usersEntity);

        Assert.assertEquals(usersEntity,userRoleEntity.getUser());
        Assert.assertEquals(UserRole.ROLE_CUSTOMER,userRoleEntity.getUser_role());

    }

    @Test
    public void transformToCustomerEntity() throws Exception {

        UsersEntity usersEntity = new UsersEntity();
        CustomersEntity customersEntity = registrationForm.transformToCustomerEntity(usersEntity);

        Assert.assertEquals(usersEntity,customersEntity.getUser());
        Assert.assertEquals("name",customersEntity.getName());
        Assert.assertEquals("lastname",customersEntity.getLastname());
        Assert.assertEquals("tel",customersEntity.getTelNumber());
    }
}