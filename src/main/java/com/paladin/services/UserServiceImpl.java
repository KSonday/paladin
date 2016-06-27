package com.paladin.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paladin.daos.EnterpriseRepository;
import com.paladin.daos.NonprofitRepository;
import com.paladin.daos.RoleRepository;
import com.paladin.daos.UserProfileRepository;
import com.paladin.daos.UserRepository;
import com.paladin.models.Enterprise;
import com.paladin.models.Nonprofit;
import com.paladin.models.Privilege;
import com.paladin.models.Role;
import com.paladin.models.User;
import com.paladin.util.PasswordCrypto;

/**
 * Created by meghandow on 3/24/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserProfileRepository userProfileRepository;
    
    @Autowired
    EnterpriseRepository enterpriseRepository;
    
    @Autowired
    NonprofitRepository nonprofitRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordCrypto pwCrypto;
    
    
    @Override
    public User findByEmail(String email) {
    	return userRepository.findByEmail(email);
    }
    
    @Override
    public void save(User user){
    	if (user.getUserProfile() != null) {
    	userProfileRepository.save(user.getUserProfile());
    	}
    	if (user.getOrganization() != null) {
            String orgSubclass = user.getOrganization().getClass().getName();
            if (orgSubclass.equals("com.paladin.models.Enterprise")) {
            	enterpriseRepository.save((Enterprise) user.getOrganization());
            }
            if (orgSubclass.equals("com.paladin.models.Nonprofit")) {
            	Nonprofit nonprofit = (Nonprofit) user.getOrganization();
            	nonprofitRepository.save(nonprofit);
            }
    	}
        userRepository.save(user);
    }

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	public Iterable<User> findAllUsers() {
		Iterator<User> users = userRepository.findAll().iterator();
		while (users.hasNext()){
			System.out.println(users.next().getEmail());
		}
		return userRepository.findAll();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}
    
	@Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByEmail(email);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
              " ", " ", true, true, true, true, 
              getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        }
 
        return new org.springframework.security.core.userdetails.User(
          user.getEmail(), user.getPassword(), user.isEnabled(), true, true, 
          true, getAuthorities(user.getRoles()));
    }
 
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }
 
    private List<String> getPrivileges(Collection<Role> roles) {
        List<String> privileges = new ArrayList<String>();
        List<Privilege> collection = new ArrayList<Privilege>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }
 
    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
    
    @Override
    public void setPassword(User user, String unEncryptedPassword) {
    	user.setPassword(pwCrypto.encode(unEncryptedPassword));
    	save(user);
    }

    
}
