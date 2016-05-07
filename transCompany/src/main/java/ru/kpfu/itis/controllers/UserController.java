package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.forms.DriverRegister;
import ru.kpfu.itis.forms.RegistrationForm;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.security.AuthProviderImpl;
import ru.kpfu.itis.service.CustomersService;
import ru.kpfu.itis.service.UserService;

import javax.validation.Valid;

/**
 * Created by evdodima on 07/05/16.
 * 11-402
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CustomersService customersService;

    @Autowired
    AuthProviderImpl authProvider;


    @RequestMapping(value = "/accessdenied/", method = RequestMethod.GET)
    public String getAccessDenied(Model model) {
        return "redirect:/";
    }

    @RequestMapping(value = "/register/customer", method = RequestMethod.GET)
    public String regpage(Model model) {
        model.addAttribute("regform", new RegistrationForm());
        return "pages/registration";
    }

    @RequestMapping(value = "/register/customer", method = RequestMethod.POST)
    public String getClientRegistration(@ModelAttribute("regform") @Valid RegistrationForm form, BindingResult result) {

        if (userService.getUserByLogin(form.getLogin()) != null) {
            result.addError(new FieldError("regform", "login", "login is already used"));
        }

        if (result.hasErrors()) {
            return "pages/registration";
        }

        try {
            UsersEntity userModel = userService.getUserById(userService.saveNewUser(form));
            //   customersService.saveNewCustomer(form, userModel);

            Authentication auth = authProvider.authenticate(userModel);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        catch (DataIntegrityViolationException e) {
            //            logger.info("User registration DataIntegrityViolationException", e);
            //            result.reject("ru.esmukov.companyinternalsoftwaremanager.controller.UserController.IntegrityViolation.message");
            return "pages/registration";
        }




        return "redirect:/";
    }

    @RequestMapping(value = "/register/driver", method = RequestMethod.GET)
    public String regdriverpage(Model model) {
        model.addAttribute("regform", new DriverRegister());
        return "pages/registerdriver";
    }

    @RequestMapping(value = "/register/driver", method = RequestMethod.POST)
    public String getDriverRegistration(@ModelAttribute("regform") @Valid DriverRegister form, BindingResult result) {

        if (userService.getUserByLogin(form.getLogin()) != null) {
            result.addError(new FieldError("regform", "login", "login is already used"));
        }

        if (result.hasErrors()) {
            return "pages/registerdriver";
        }

        try {
            userService.saveNewUser(form);
        }
        catch (DataIntegrityViolationException e) {
            //            logger.info("User registration DataIntegrityViolationException", e);
            //            result.reject("ru.esmukov.companyinternalsoftwaremanager.controller.UserController.IntegrityViolation.message");
            return "pages/registerdriver";
        }

        return "redirect:/tables/drivers";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getSignin(Model model, @RequestParam(value = "error", required = false) String error) {
        if ("true".equals(error)) {
            model.addAttribute("error", error);
        }
        return "pages/login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile(Model model) {
        return "pages/profile";
    }


}
