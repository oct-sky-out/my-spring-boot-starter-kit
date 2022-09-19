package com.nhnacademy.projectbulk.home.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 홈페이지 컨트롤라
 *
 * @author 김민수
 * @since 1.0
 */
@Controller
public class HomeController {

    @GetMapping
    public String showHomePage(Authentication authentication) {
        return "home/index";
    }
}
