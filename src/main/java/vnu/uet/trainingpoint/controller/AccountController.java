package vnu.uet.trainingpoint.controller;

import io.swagger.models.Model;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vnu.uet.trainingpoint.config.CustomLoginSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {

    @GetMapping(value = {"/login", "/"})
    public String showLoginPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "account/login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "account/register";
    }
}
