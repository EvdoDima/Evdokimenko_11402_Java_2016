package evdodima.Task14;

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
@RequestMapping(path = "/search/{type}")
public class SearchController {
    @RequestMapping(method = RequestMethod.GET)
    public String search(ModelMap model, @RequestParam("type") String adress){

        switch (adress) {
            case "baidu.com":
                model.put("action_url", "https://www.baidu.com/s");
                model.put("searchParamName", "wd");
                break;

            case "bing.com":
                model.put("action_url", "http://www.bing.com/search");
                model.put("searchParamName", "q");

                break;

            case "search.yahoo.com":
                model.put("action_url", "https://search.yahoo.com/search");
                model.put("searchParamName", "p");

                break;

            case "search.aol.com":
                model.put("action_url", "http://search.aol.com/aol/search");
                model.put("searchParamName", "q");
                break;
        }

        return "task_14/search";

    }
}
