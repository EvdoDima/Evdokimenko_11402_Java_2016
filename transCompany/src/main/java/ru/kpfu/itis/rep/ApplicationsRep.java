package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.UsersEntity;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
@Repository
public interface ApplicationsRep extends JpaRepository<ApplicationsEntity,Long>{
    ApplicationsEntity findOneByName(String name);

    void deleteByName(Integer id);
}
