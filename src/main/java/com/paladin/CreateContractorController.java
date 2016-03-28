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
@RequestMapping("/contractor")
public class CreateContractorController {

    @RequestMapping(method= RequestMethod.GET)
    public String createNewContractor(Model model) {
        model.addAttribute("contractorForm", new Contractor());
        model.addAttribute("skills", Skill.values());
        model.addAttribute(("industries"), Industry.values());
        return "new_contractor";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String submit(@ModelAttribute Contractor contractor, Model model) {
        model.addAttribute("contractor", contractor);
        return "registration_success";
    }
}
