package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.models.CarsEntity;
import ru.kpfu.itis.models.CustomersEntity;

/**
 * Created by evdodima on 09/05/16.
 * 11-402
 */
public interface CarsRep  extends JpaRepository<CarsEntity, Long> {

}
