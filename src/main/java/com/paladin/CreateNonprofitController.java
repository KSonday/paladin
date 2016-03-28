package com.paladin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by meghandow on 2/28/16.
 */
@Controller
@RequestMapping("/nonprofit")
public class CreateNonprofitController {

    @RequestMapping(method= RequestMethod.GET)
    public String createNewNonprofit(Model model) {
        model.addAttribute("nonProfitForm", new Nonprofit());
        return "new_nonprofit";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String submit(@ModelAttribute Nonprofit nonprofit, Model model) {
        model.addAttribute("nonprofit", nonprofit);
        return "registration_success";
    }
}
