package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.itis.service.ApplicationService;
import ru.kpfu.itis.service.CustomersService;
import ru.kpfu.itis.service.DriversService;

import java.util.HashMap;

/**
 * Created by evdodima on 11/04/16.
 * 11-402
 */
@Controller
public class MainController {

    @Autowired
    CustomersService customersService;

    @Autowired
    DriversService driversService;

    @Autowired
    ApplicationService applicationService;




    @RequestMapping("/")
    public String mainpage(ModelMap models)  {
        String pagename = "dashboard";
        models.put("currpage", pagename);
        models.put("customerscount",customersService.countAll());
        models.put("driverscount",driversService.countAll());
        models.put("orderscount", 5);
        models.put("applicationscount",applicationService.countAll());



        return "pages/index";
    }

}
