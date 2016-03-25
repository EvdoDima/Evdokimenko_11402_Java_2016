package evdodima.Task15;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by evdodima on 26/03/16.
 * 11-402
 */
@Controller
@RequestMapping("/result")
public class ResultController {
    @RequestMapping(method = RequestMethod.POST)
    public String process(ModelMap model, @RequestParam("string") String s ,@RequestParam("processType") int type){
        int result = 0 ;
        switch (type){
            case 1:
                result = s.length();
                break;
            case 2 :
                result = s.split(" ").length;
                break;
            case 3 :
                result = s.split("[\\.\\?!]").length;

                break;
            case 4:
                result = s.split("\r").length;
                break;
        }
        model.put("result",result);
        return "task_15/result";
    }
}
