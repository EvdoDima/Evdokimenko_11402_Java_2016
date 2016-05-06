package ru.kpfu.itis.controllers;

import ru.kpfu.itis.Helpers.Menu;
import ru.kpfu.itis.Helpers.MenuItem;
import ru.kpfu.itis.Helpers.Page;
import ru.kpfu.itis.Helpers.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;

/**
 * Created by evdodima on 11/04/16.
 * 11-402
 */
@Controller
public class MainController {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "errors/notfound";
    }


    @RequestMapping("/")
    public String mainpage(ModelMap models)  {
        String pagename = "dashboard";
        models.put("currpage", pagename);
        models.put("menuitems", Menu.menuItems);
        return "pages/index";
    }

}
