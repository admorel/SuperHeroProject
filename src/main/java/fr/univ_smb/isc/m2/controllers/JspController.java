package fr.univ_smb.isc.m2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/hello-jsp")
    public String home() {
        return "hello";
    }

}
