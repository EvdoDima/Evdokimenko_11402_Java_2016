package sample.models;



import sample.models.enums.UserRole;

import javax.persistence.*;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */

public class UserRoleEntity {
    private long id;
    private UsersEntity user;
    private UserRole role;


    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }


    public UserRole getUser_role() {
        return role;
    }

    public void setUser_role(UserRole role) {
        this.role = role;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRoleEntity that = (UserRoleEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
