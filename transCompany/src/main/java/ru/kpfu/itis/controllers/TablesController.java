package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.forms.NewApplicationForm;
import ru.kpfu.itis.forms.NewCarsForm;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.service.ApplicationService;
import ru.kpfu.itis.service.CarsService;
import ru.kpfu.itis.service.CustomersService;
import ru.kpfu.itis.service.DriversService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */
@Controller
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    ApplicationService applicationsService;

    @Autowired
    DriversService driversService;

    @Autowired
    CustomersService customersService;

    @Autowired
    CarsService carsService;


    @RequestMapping(value = "/applications", method = RequestMethod.GET)
    public String getApplications(ModelMap model , @RequestParam(value = "error", required = false) String error) {
        String[] tableheader = {"Id","Name", "Description","Summ"};
        model.put("tableheader",tableheader);
        model.put("cars",carsService.getCarsByState("free"));

        List<String[]> tablebody =new ArrayList<>();
        for (ApplicationsEntity app: applicationsService.getAll()){
            tablebody.add(new String[]{String.valueOf(app.getId()),app.getName(),app.getDescription(),String.valueOf(app.getSumm())});
        }
        model.put("tablebody",tablebody);
        model.put("tablename","applications");


        return "pages/tables";
    }



    @RequestMapping(value = "/applications/new", method = RequestMethod.GET)
    public String getNewApplication(ModelMap model , @RequestParam(value = "error", required = false) String error) {
        model.addAttribute("regform", new NewApplicationForm());
        if("1".equals(error))
        model.put("error",error);


        return "tables/newapplication";
    }


    @RequestMapping(value = "/applications/new", method = RequestMethod.POST)
    public String setNewApplication(ModelMap models, @ModelAttribute("regform") @Valid NewApplicationForm form, BindingResult result) {

        if (applicationsService.getApplicationByName(form.getName()) != null) {
            result.addError(new FieldError("regform", "login", "name is already used"));
        }

        if (result.hasErrors()) {
            return "redirect:/tables/applications/new?error=1";
        }

        UsersEntity user = (UsersEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            applicationsService.saveNewApplication(form, user);
        }
        catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            //            logger.info("User registration DataIntegrityViolationException", e);
            //            result.reject("ru.esmukov.companyinternalsoftwaremanager.controller.UserController.IntegrityViolation.message");
            return "pages/tables";
        }

        return "redirect:/tables/applications";
    }

    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public String getDrivers(ModelMap model) {
        String[] tableheader = {"Id","Name","Last name", "Telnumber","Driving exp", "Salary rate"};
        model.put("tableheader",tableheader);

        List<String[]> tablebody =new ArrayList<>();

        for (DriversEntity app: driversService.getAll()){
            tablebody.add(new String[]{String.valueOf(app.getId()),app.getFirstName(),app.getLastName(),String.valueOf(app.getTelNumber())
            ,String.valueOf(app.getDrivingExp()),String.valueOf(app.getSalaryRate())});
        }
        model.put("tablebody",tablebody);
        model.put("tablename","applications");


        return "pages/tables";
    }


    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String getCustomers(ModelMap model) {
        String[] tableheader = {"Id","Name","Last name", "Telnumber"};
        model.put("tableheader",tableheader);

        List<String[]> tablebody =new ArrayList<>();

        for (CustomersEntity app: customersService.getAll()){
            tablebody.add(new String[]{String.valueOf(app.getId()),app.getName(),app.getLastname(),String.valueOf(app.getTelNumber())
                    });
        }
        model.put("tablebody",tablebody);
        model.put("tablename","applications");


        return "pages/tables";
    }


    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCars(ModelMap model) {
        String[] tableheader = {"Id","Model","Year", "run", "State"};
        model.put("tableheader",tableheader);

        List<String[]> tablebody =new ArrayList<>();

        for (CarsEntity app: carsService.getAll()){
            tablebody.add(new String[]{String.valueOf(app.getId()),app.getModel(),
                    String.valueOf(app.getYear()),String.valueOf(app.getRun()),app.getState()
            });
        }
        model.put("tablebody",tablebody);
        model.put("tablename","cars");


        return "pages/tables";
    }

    @RequestMapping(value = "/cars/new", method = RequestMethod.GET)
    public String getNewCar(ModelMap model ) {
        model.addAttribute("regform", new NewCarsForm());

        return "/tables/addcar";
    }


    @RequestMapping(value = "/cars/new", method = RequestMethod.POST)
    public String setNewCar(ModelMap models, @ModelAttribute("regform") @Valid NewCarsForm form, BindingResult result) {


        if (result.hasErrors()) {
            return "redirect:/tables/cars/new";
        }

        try {
            carsService.saveNewCar(form);
        }
        catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            //            logger.info("User registration DataIntegrityViolationException", e);
            // ru.rpfu.itis.esmukov
            return "pages/tables";
        }

        return "redirect:/tables/cars";
    }






}
