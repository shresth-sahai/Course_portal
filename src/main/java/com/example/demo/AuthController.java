package com.example.demo;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/")
    public String home(){
        return "index";
    }
    public String registerForm(Model model){
        model.addAttribute("user",new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(User user){
        user.setRole("STUDENT");
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/dashboard")
    public String dashboard(Authentication auth){
        if(auth.getAuthorities().toString().contains("ADMIN"))
            return  "redirect:/admin/dashboard";
        return  "redirect:/student/dashboard";
    }

}
