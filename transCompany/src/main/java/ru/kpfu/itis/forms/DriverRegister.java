package ru.kpfu.itis.forms;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.security.AuthProviderImpl;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
public class DriverRegister extends RegistrationForm {

    private int drivingexp;

    @Range(max = 1, message = "(0;1)")
    private double salaryrate;

    public int getDrivingexp() {
        return drivingexp;
    }

    public void setDrivingexp(int drivingexp) {
        this.drivingexp = drivingexp;
    }

    public double getSalaryrate() {
        return salaryrate;
    }

    public void setSalaryrate(double salaryrate) {
        this.salaryrate = salaryrate;
    }



    public DriversEntity transformToDriversEntity(UsersEntity userModel) {
        DriversEntity driversEntity = new DriversEntity();
        driversEntity.setUser(userModel);
        driversEntity.setFirstName(getName());
        driversEntity.setLastName(getLastname());
        driversEntity.setTelNumber(getTelnumber());
        driversEntity.setDrivingExp(getDrivingexp());
        driversEntity.setSalaryRate(getSalaryrate());

        return driversEntity;
    }

    @Override
    public UserRoleEntity transformToUserRoleEntity(UsersEntity userModel) {
        UserRoleEntity userProfile = new UserRoleEntity();
        userProfile.setUser_role(UserRole.ROLE_DRIVER);
        userProfile.setUser(userModel);
        return userProfile;
    }

}
