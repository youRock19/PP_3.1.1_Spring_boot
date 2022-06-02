package com.yuriiryabkov.controller;



import com.yuriiryabkov.model.User;
import com.yuriiryabkov.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.read());
        return "users";
    }
    
    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    
    @PostMapping
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "edit";
    }
      
     @PostMapping("{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }   
    
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
