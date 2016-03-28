package com.paladin;

import com.paladin.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by meghandow on 3/24/16.
 */
@Controller
public class AuthenticationController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/join", method=RequestMethod.GET)
    public String home() {
        return "join";
    }


    @RequestMapping(value = "/join", method= RequestMethod.POST)
    public void join(@RequestParam("username") String userName, @RequestParam("password") String password) {
        System.out.println(userName);
        Student student = new Student("jane", 3);
        userDAO.save(student);


    }
}
