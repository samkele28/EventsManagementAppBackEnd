package eventsystem.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Samkele on 8/28/2016.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String Index(){
        return "This is the Home Page";
    }
}
