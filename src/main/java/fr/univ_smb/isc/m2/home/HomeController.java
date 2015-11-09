package fr.univ_smb.isc.m2.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "hello-protected";
    }

    @RequestMapping("/")
    public String home() {
        return "forward:/resources/html/index.html";
    }


}