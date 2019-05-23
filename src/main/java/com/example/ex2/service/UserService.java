package com.example.ex2.service;

import com.example.ex2.domain.Role;
import com.example.ex2.domain.User;
import com.example.ex2.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public List<User> findAllAsc() {
        return userRepo.findAllByOrderByUsernameAsc();
    }

    public void deleteUser(User user){
        userRepo.delete(user);
    }

    public boolean isNameAdmin(User user){
        if(user.getUsername().equals("admin")){
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(User user, String username, String password, String password2, Map<String, String> form) {

        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setUsername(username);

        if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password2)){
            if(password.equals(password2)){
                user.setPassword(passwordEncoder.encode(password));
            }
        }

        user.setActive(true);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        Set<Role> newroles = new LinkedHashSet<>();

        for (String key : form.keySet()){
            if (roles.contains(key)){
                newroles.add(Role.valueOf(key));
            }
        }
        user.setRoles(newroles);

//        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return true;
    }

    public void saveUser(User user, String password, String password2, Map<String, String> form) {
//        user.setUsername(username);
//        user.setId(Long.parseLong(id));


        if (!user.isAdmin()){
            Set<String> roles = Arrays.stream(Role.values())
                    .map(Role::name)
                    .collect(Collectors.toSet());

            user.getRoles().clear();

            for (String key : form.keySet()) {
                if (roles.contains(key)) {
                    user.getRoles().add(Role.valueOf(key));
                }
            }
        }

        if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(password2)){
            if(password.equals(password2)){
                user.setPassword(passwordEncoder.encode(password));
            }
        }

        userRepo.save(user);
    }

}
