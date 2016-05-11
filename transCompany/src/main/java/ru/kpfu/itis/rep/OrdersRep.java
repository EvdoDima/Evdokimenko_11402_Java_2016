package ru.kpfu.itis.rep;

import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by evdodima on 11/05/16.
 * 11-402
 */
@Repository
public interface OrdersRep extends JpaRepository<OrdersEntity,Long>{
    List<OrdersEntity> findAllByDriverId(long id);
}
