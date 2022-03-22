package com.heekng.security.controller;

import com.heekng.security.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/hello")
    public String home(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("name", user.getUsername());
        return "/hello";
    }
}
