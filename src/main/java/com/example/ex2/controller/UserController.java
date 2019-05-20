package com.example.ex2.controller;

import com.example.ex2.domain.Role;
import com.example.ex2.domain.User;
import com.example.ex2.repos.UserRepo;
import com.example.ex2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('MOD1')")
public class UserController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @GetMapping("/add")
    public String userAddForm(Model model){
        model.addAttribute("roles", Role.values());
        return "userAdd";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping
    public String userEditRole(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        if(username.equals("admin")){
            return "redirect:/user";
        }

//        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values()).
                map(Role::name).
                collect(Collectors.toSet());
        user.getRoles().clear();

        for (String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping("/adduser")
    public String addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String password2,
            @RequestParam Map<String, String> form
    ){
        User newuser = new User();
        if(username.equals("admin")){
            return "redirect:/user";
        }

        newuser.setUsername(username);
        if (password.equals(password2)){
            newuser.setPassword(password);
        }

        Set<String> roles = Arrays.stream(Role.values()).
                map(Role::name).
                collect(Collectors.toSet());
//        newuser.getRoles().clear();

        Set<Role> newroles = new LinkedHashSet<>();

        for (String key : form.keySet()){
            if (roles.contains(key)){
                newroles.add(Role.valueOf(key));
//                newuser.getRoles().add(Role.valueOf(key));
            }
        }
        newuser.setRoles(newroles);

        userService.addUser(newuser);
//        userRepo.save(user);
        return "redirect:/user";
    }

}
