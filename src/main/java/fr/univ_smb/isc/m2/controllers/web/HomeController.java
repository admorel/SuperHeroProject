package fr.univ_smb.isc.m2.controllers.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {


    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    public String home() {
        return "forward:/resources/html/index.html";
    }


    @RequestMapping(value = "/home", produces = "text/plain;charset=UTF-8")
    public String homeJsp() {
        return "anonymous-home";
    }


    @RequestMapping(value = "/admin", produces = "text/plain;charset=UTF-8")
    public ModelAndView admin(Principal principal) {
        return new ModelAndView("admin-home", "user", principal.getName());
    }


    @RequestMapping(value = "/logout", method = GET, produces = "text/plain;charset=UTF-8")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
