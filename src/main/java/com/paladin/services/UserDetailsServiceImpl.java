package com.paladin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paladin.models.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UserService userService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), 
                 user.getState().equals("Active"), true, true, true, null); //granted authorities in last pos
    }
 
     
//    private List<GrantedAuthority> getGrantedAuthorities(User user){
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//         
//        for(UserProfile userProfile : user.getUserProfiles()){
//            System.out.println("UserProfile : "+userProfile);
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
//        }
//        System.out.print("authorities :"+authorities);
//        return authorities;
//    }

}
