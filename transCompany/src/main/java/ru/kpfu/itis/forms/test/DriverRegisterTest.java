package ru.kpfu.itis.forms.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.postgresql.Driver;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;

import static org.junit.Assert.*;

/**
 * Created by evdodima on 14/05/16.
 * 11-402
 */
public class DriverRegisterTest {
    DriverRegister driverRegister;

    @Before
    public void setUp() throws Exception {

        driverRegister = new DriverRegister();
        driverRegister.setName("name");
        driverRegister.setDrivingexp(1);
        driverRegister.setSalaryrate(0.5);
        driverRegister.setLastname("lastname");
        driverRegister.setLogin("login");
        driverRegister.setPassword("password");
        driverRegister.setRepassword("repassword");
        driverRegister.setTelnumber("telnumber");


    }

    @Test
    public void transformToDriversEntity() throws Exception {

        UsersEntity usersEntity = new UsersEntity();

        DriversEntity driversEntity = driverRegister.transformToDriversEntity(usersEntity);

        Assert.assertEquals(driversEntity.getUser(), usersEntity);

        Assert.assertEquals(driversEntity.getDrivingExp(), 1);
        Assert.assertEquals(driversEntity.getFirstName(), "name");
        Assert.assertEquals(driversEntity.getLastName(), "lastname");
        Assert.assertEquals(driversEntity.getTelNumber(), "telnumber");
        Assert.assertEquals(driversEntity.getFirstName(), "name");


    }

    @Test
    public void transformToUserRoleEntity() throws Exception {
        UsersEntity usersEntity = new UsersEntity();

        DriverRegister driverRegister = new DriverRegister();
        UserRoleEntity userRoleEntity = driverRegister.transformToUserRoleEntity(usersEntity);


        Assert.assertEquals(userRoleEntity.getUser_role(), UserRole.ROLE_DRIVER);
        Assert.assertEquals(userRoleEntity.getUser(), usersEntity);

    }
}