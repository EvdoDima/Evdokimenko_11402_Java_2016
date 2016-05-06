package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.UserRoleEntity;
import ru.kpfu.itis.models.UsersEntity;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
@Repository
public interface UserRoleRep extends JpaRepository<UserRoleEntity, Long> {

}
