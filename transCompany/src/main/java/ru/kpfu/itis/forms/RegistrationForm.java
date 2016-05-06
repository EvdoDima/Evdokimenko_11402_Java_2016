package ru.kpfu.itis.forms;

import org.hibernate.validator.constraints.NotEmpty;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.security.AuthProviderImpl;

import javax.management.relation.Role;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
public class RegistrationForm {

    @Pattern(message = "^[a-zA-Z0-9_-]{3,16}", regexp = "^[a-zA-Z0-9_-]{3,16}")
    private String login;

    @Size(min = 6, message = "lenght >= 8")
    private String password;

    @Size(min = 6, max = 24, message = "!equals")
    private String repassword;


    @Enumerated(EnumType.ORDINAL)
    private UserRole userrole;

    public UserRole getUserrole() {
        return userrole;
    }

    public void setUserrole(UserRole userrole) {
        this.userrole = userrole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

        UsersEntity user = new UsersEntity();
        user.setLogin(getLogin());
        user.setPassword(AuthProviderImpl.getEncoder().encode(getPassword()));

        return user;
    }

    public UserRoleEntity transformToUserRoleEntity(UsersEntity userModel) {
        UserRoleEntity userRole = new UserRoleEntity();

        userRole.setUser(userModel);
        userRole.setUser_role(getUserrole());

        return userRole;
    }
}
