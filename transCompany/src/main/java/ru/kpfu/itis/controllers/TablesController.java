package ru.kpfu.itis.controllers;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.Helpers.Menu;
import ru.kpfu.itis.Helpers.Page;
import ru.kpfu.itis.Helpers.ResourceNotFoundException;
import ru.kpfu.itis.models.UsersEntity;
import ru.kpfu.itis.service.UserService;
import ru.kpfu.itis.service.impls.UserServiceImpl;

/**
 * Created by evdodima on 05/05/16.
 * 11-402
 */
@Controller
public class TablesController {

    @Autowired
    UserService userService;

    @RequestMapping("/tables")
    public String tablespage(ModelMap models)  {
        UsersEntity user = userService.getUserById(1);
        models.put("user", user);
        String pagename = "tables";
        models.put("currpage", pagename);
        models.put("menuitems", Menu.menuItems);
        return "pages/tables";
    }
}
