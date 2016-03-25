package evdodima.Task14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by evdodima on 26/03/16.
 * 11-402
 */
@Controller
@RequestMapping("/date")
public class DateController {


    @RequestMapping(method = RequestMethod.GET)
    public String date(ModelMap model){
        model.put("date", new java.util.Date());

        return "task_14/date";


    }

}
