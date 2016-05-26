package ru.kpfu.itis.service.impls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.ApplicationsEntity;
import ru.kpfu.itis.models.CarsEntity;
import ru.kpfu.itis.models.DriversEntity;
import ru.kpfu.itis.models.OrdersEntity;
import ru.kpfu.itis.rep.OrdersRep;
import ru.kpfu.itis.service.OrdersService;

import java.util.List;

/**
 * Created by evdodima on 11/05/16.
 * 11-402
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRep ordersRep;

    @Override
    public void saveNewOrder(ApplicationsEntity app, CarsEntity car, DriversEntity driver) {
        OrdersEntity order = new OrdersEntity();
        order.setCar(car);
        order.setCustomer(app.getCustomer());
        order.setDriver(driver);
        order.setCost(app.getSumm());
        order.setDescription(app.getDescription());
        order.setStatus("Processing");


        ordersRep.save(order);


    }

    @Override
    @Transactional
    public List<OrdersEntity> getAll() {
        return ordersRep.findAll();
    }

    @Override
    @Transactional
    public List<OrdersEntity> findAllByDriver(DriversEntity driver) {
        return ordersRep.findAllByDriverId(driver.getId());
    }

    @Override
    public OrdersEntity findOne(Integer id) {
        System.out.println(Long.valueOf(id));
        return ordersRep.findOne(Long.valueOf(id));
    }

    @Override
    public void saveNewOrder(OrdersEntity ordersEntity) {

        ordersRep.save(ordersEntity);
    }

    @Override
    public List<OrdersEntity> findAll() {
        return ordersRep.findAll();
    }
}
