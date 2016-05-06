package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.UsersEntity;

import java.util.List;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */
@Repository
public interface UserRep extends JpaRepository<UsersEntity, Long> {

    List<UsersEntity> findAll();

    UsersEntity findOneById(long id);

    UsersEntity findOneByLogin(String login);

    void deleteById(Integer id);
}
