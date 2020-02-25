package com.timeline.news.controller;

import com.timeline.news.model.jpa.News;
import com.timeline.news.model.jpa.Role;
import com.timeline.news.model.jpa.User;
import com.timeline.news.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/registration")
    public String greeting(Map<String, Object> model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String register (@RequestParam String name, @RequestParam String password, Map<String, Object> model) {
        Optional<User> user = userRepository.getByUsername(name);
        if (user.isPresent()) {
            model.put("message", "Такой пользователь уже существует");
            return "registration";
        } else {
            userRepository.save(new User(name, password, true, EnumSet.of(Role.USER)));
        }
        return "redirect:/login";
    }
}
