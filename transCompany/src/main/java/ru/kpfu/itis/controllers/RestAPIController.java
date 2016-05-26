package ru.kpfu.itis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.models.enums.UserRole;
import ru.kpfu.itis.service.ApplicationService;
import ru.kpfu.itis.service.CarsService;
import ru.kpfu.itis.service.OrdersService;
import ru.kpfu.itis.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * @author Rinat Khanov
 *         11-402
 *         000
 */


@RestController
@RequestMapping("/rest/api")
public class RestAPIController {

    @Autowired
    UserService userService;

    @Autowired
    ApplicationService applicationService;


    @Autowired
    OrdersService ordersService;

    @Autowired
    CarsService carsService;



    @RequestMapping("/orders")
    public List<OrdersEntity> getProducts() {
        UsersEntity user = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        return user.getRole().getUser_role() == UserRole.ROLE_DRIVER ?
                ordersService.findAllByDriver(user.getDriver()) : ordersService.getAll();
    }

    @RequestMapping("/applications")
    public List<ApplicationsEntity> getApplications() {
        return applicationService.getAll();
    }

    @RequestMapping(value = "/applications/new" , method = RequestMethod.POST)
    public void postNewApplication(@RequestBody String appIdJson){
        ApplicationsEntity applicationsEntity= new ApplicationsEntity();
        try {
            applicationsEntity = new ObjectMapper().readValue(appIdJson,ApplicationsEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsersEntity user = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        applicationsEntity.setCustomer(user.getCustomer());
        applicationService.saveNewApplication(applicationsEntity);
    }




    @RequestMapping(value = "/applications" , method = RequestMethod.POST)
    public void postApplication(@RequestBody String appIdJson){
        Integer id=0;
        try {
            id = new ObjectMapper().readValue(appIdJson,Integer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ApplicationsEntity app = applicationService.getOneById(id);
        CarsEntity car = carsService.getCarsByState("free").get(0);
        UsersEntity user = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        ordersService.saveNewOrder(app, car,
                user.getDriver());
        applicationService.deleteOneById(id);
        car.setState("Busy");
        carsService.saveNewCar(car);
    }


    @RequestMapping("/role")
    public UserRole getRole() {
        UsersEntity user = userService.getUserByLogin(
                ((UserDetails) SecurityContextHolder.getContext().
                        getAuthentication().getPrincipal()).getUsername());

        return user.getRole().getUser_role();
    }

    @RequestMapping("/cars")
    public List<CarsEntity> getCars() {
        return carsService.getAll();
    }

    @RequestMapping(value = "/cars/new" , method = RequestMethod.POST)
    public void postNewCar(@RequestBody String appIdJson){
        CarsEntity carsEntity= new CarsEntity();
        try {
            carsEntity = new ObjectMapper().readValue(appIdJson,CarsEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        carsService.saveNewCar(carsEntity);
    }

    @RequestMapping("/cars/available")
    public List<CarsEntity> getAvailableCars() {
        return carsService.getCarsByState("free");
    }

    @RequestMapping(value = "/users/new" , method = RequestMethod.POST)
    public void postNewUser(@RequestBody String appIdJson){
        UsersEntity usersEntity= new UsersEntity();
        try {
            usersEntity = new ObjectMapper().readValue(appIdJson,UsersEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userService.saveNewUser(usersEntity);
    }





}