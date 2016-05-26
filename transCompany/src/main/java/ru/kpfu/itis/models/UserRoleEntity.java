package ru.kpfu.itis.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.kpfu.itis.models.enums.UserRole;

import javax.persistence.*;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */
@Entity
@Table(name = "user_role" ,  schema = "public", catalog = "transcompany")
public class UserRoleEntity {
    private long id;
    private UsersEntity user;
    private UserRole role;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "role", nullable = false)
    public UserRole getUser_role() {
        return role;
    }

    public void setUser_role(UserRole role) {
        this.role = role;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_seq")
    @SequenceGenerator(name = "user_role_id_seq", sequenceName = "user_role_id_seq", allocationSize = 1)
    @Column(name = "id")
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
