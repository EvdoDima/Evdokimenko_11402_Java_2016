package ru.kpfu.itis.service;

import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.CarsEntity;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.OrdersEntity;

import java.util.List;

/**
 * Created by evdodima on 11/05/16.
 * 11-402
 */
public interface OrdersService {

    void saveNewOrder(ApplicationsEntity app, CarsEntity car, DriversEntity driver);

    List<OrdersEntity> getAll();

    List<OrdersEntity> findAllByDriver(DriversEntity driver);

    OrdersEntity findOne(Integer id);

    void saveNewOrder(OrdersEntity ordersEntity);

    List<OrdersEntity> findAll();
}
