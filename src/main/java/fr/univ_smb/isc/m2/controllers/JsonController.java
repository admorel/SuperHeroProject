package fr.univ_smb.isc.m2.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JsonController {

    @RequestMapping("/hello-json")
    public @ResponseBody Map<String, String> callSomething() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");

        return map;
    }
}