package ru.kpfu.itis.forms;

import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.models.CustomersEntity;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.security.AuthProviderImpl;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
public class RegistrationForm {

    @NotEmpty(message = "Field can not be empty!")
    @Pattern(message = "Wrong login format", regexp = "^[a-zA-Z0-9_-]{3,16}")
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NotEmpty(message = "Field can not be empty!")
    @Size(max = 30, message = "Maximum name length is 30 characters!")
    private String name;

    @NotEmpty(message = "Field can not be empty!")
    @Size(max = 30, message = "Maximum lastname length is 30 characters!")
    private String lastname;


    @Pattern(message = "wrong tel num", regexp = "[0-9]{11}")
    private String telnumber;

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    @Size(min = 6, message = "Password is minimum 6 characters")
    private String password;

    @Size(min = 6, max = 24, message = "Password length is not valid")
    private String repassword;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public UsersEntity transformToUserModel() {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(getLogin());
        usersEntity.setPassword(AuthProviderImpl.getEncoder().encode(getPassword()));


        return usersEntity;
    }

    public UserRoleEntity transformToUserRoleEntity(UsersEntity userModel) {
        UserRoleEntity userProfile = new UserRoleEntity();
        userProfile.setUser_role(UserRole.ROLE_CUSTOMER);
        userProfile.setUser(userModel);
        return userProfile;
    }

   public CustomersEntity transformToCustomerEntity(UsersEntity userModel){
       CustomersEntity customersEntity = new CustomersEntity();
       customersEntity.setUser(userModel);
       customersEntity.setName(getName());
       customersEntity.setLastname(getLastname());
       customersEntity.setTelNumber(getTelnumber());

       return customersEntity;
   }
}
