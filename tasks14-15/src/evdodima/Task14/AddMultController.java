package evdodima.Task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;



/**
 * Created by evdodima on 26/03/16.
 * 11-402
 */
@Controller
public class AddMultController {

    @RequestMapping(value={"/add/{val1}/{val2}","/mult/{val1}/{val2}"},method = RequestMethod.GET)
    public String add(ModelMap model, @PathVariable("val1") int arg1, @PathVariable("val2") int arg2,
                      HttpServletRequest request){

        String s = request.getRequestURI();
        String[] separatedURI = s.split("/");
        int result=0;
        switch(separatedURI[1]){
            case "add":
                result= arg1+arg2;
                model.put("oper","+");
                break;
            case "mult":
                result= arg1*arg2;
                model.put("oper","*");
                break;
        }
        model.put("arg1",arg1);
        model.put("arg2",arg2);
        model.put("result",result);
        return "task_14/addMult";
    }
}
