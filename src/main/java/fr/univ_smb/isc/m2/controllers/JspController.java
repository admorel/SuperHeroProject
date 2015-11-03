package fr.univ_smb.isc.m2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

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
