package com.example.ex2.controller;

import com.example.ex2.domain.Role;
import com.example.ex2.domain.User;
import com.example.ex2.repos.UserRepo;
import com.example.ex2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('MOD1')")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAllAsc());
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
    @GetMapping("/delete/{user}")
    public String userDelete(@PathVariable User user,
                             @AuthenticationPrincipal User curuser){
        if(!userService.isNameAdmin(curuser)) {
            if (userService.isNameAdmin(user)) {
                return "redirect:/user";
            }
            if (user.equals(curuser)) {
                return "redirect:/user";
            }
            if (user.isAdmin() && !curuser.isAdmin()) {
                return "redirect:/user";
            }
            if (curuser.isMod() && user.isMod() || user.isAdmin()) {
                return "redirect:/user";
            }
        }

        userService.deleteUser(user);

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
        userService.addUser(newuser, username, password, password2, form);
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('MOD1')")
    @PostMapping("/save")
    public String userSave(
            @AuthenticationPrincipal User curuser,
            @RequestParam String password,
            @RequestParam String password2,
            @RequestParam Map<String, String> form,
            @RequestParam("Id") User user
    ) {

        if(!userService.isNameAdmin(curuser)){
            if(userService.isNameAdmin(user) && !userService.isNameAdmin(curuser)){
                return "redirect:/user";
            }
            if(curuser.isAdmin() && user.isAdmin()){
                return "redirect:/user";
            }
            if(curuser.isMod() && user.isMod() || user.isAdmin()){
                return "redirect:/user";
            }
        }

        userService.saveUser(user, password, password2, form);
        return "redirect:/user";
    }

}
