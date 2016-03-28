package com.paladin.services;

import com.paladin.daos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by meghandow on 3/24/16.
 */
@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = null;//userDao.findByEmail(username);

        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return null; //assembler.buildUserFromEntity(user);

    }
}
