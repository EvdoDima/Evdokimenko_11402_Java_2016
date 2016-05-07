package ru.kpfu.itis.rep;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.CustomersEntity;

import java.util.List;

/**
 * Created by evdodima on 06/05/16.
 * 11-402
 */
@Repository
public interface CustomerRep extends JpaRepository<CustomersEntity, Long> {

    List<CustomersEntity> findAll();






}
