package com.paladin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by meghandow on 2/27/16.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "lawyers", method=RequestMethod.GET)
    public String lawyer() {
        return "lawyer_info";
    }

    @RequestMapping(value = "enterprises", method=RequestMethod.GET)
    public String enterprises() {
        return "enterprise_info";
    }

    @RequestMapping(value = "nonprofits", method=RequestMethod.GET)
    public String nonprofits() {
        return "enterprise_info";
    }
}
