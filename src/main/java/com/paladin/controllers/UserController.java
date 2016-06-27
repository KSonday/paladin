package com.paladin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paladin.models.User;
import com.paladin.services.MailService;
import com.paladin.services.UserService;

/**
 * Created by meghandow on 3/24/16.
 */
@RestController
public class UserController {

    
//    @RequestMapping(value = "/api/users/all", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//    	System.out.println("got into controller");
//        List<User> users = Lists.newArrayList(userService.findAllUsers());
//    	System.out.println("found "+users.size()+" users");
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
 
 
    //-------------------Retrieve Single User--------------------------------------------------------
     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
     

    
     
    //------------------- Update a User --------------------------------------------------------
     
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        System.out.println("Updating User " + id);
//         
//        User currentUser = userService.findById(id);
//         
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
// 
////        currentUser.setName(user.get());
////        currentUser.setAge(user.getAge());
////        currentUser.setSalary(user.getSalary());
//         
//        userService.save(currentUser);
//        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
//    }
// 
}
