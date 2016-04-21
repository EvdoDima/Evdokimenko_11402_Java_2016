package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by evdodima on 14/04/16.
 * 11-402
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String loginpage(){
        return "this is login page";
    }
}
