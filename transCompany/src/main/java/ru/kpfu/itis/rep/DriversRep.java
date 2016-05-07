package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.UserRoleEntity;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
@Repository
public interface DriversRep extends JpaRepository<DriversEntity, Long> {
}
