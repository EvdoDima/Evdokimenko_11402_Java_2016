package controllers;

import Helpers.ResourceNotFoundException;
import models.Menu;
import models.MenuItem;
import models.Page;
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

   private static HashMap<String, Page> pages = new HashMap<>();

    static {
        for (MenuItem item: Menu.menuItems){
            pages.put(item.getName(),new Page(item.getName()));
        }

    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException() {
        return "errors/notfound";
    }


    @RequestMapping("/{name}")
    public String mainpage(ModelMap models, @PathVariable("name") String pagename)  {
        if (!pages.containsKey(pagename)) throw new ResourceNotFoundException();
        models.put("currpage", pagename);
        models.put("menuitems", Menu.menuItems);
        return "pages/index";
    }

}
