package com.xmair.common.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restapi")
public class RestAPIController {

    @RequestMapping(value = "/index")
    public String index(int number){
        System.out.println(20 / number);
        return "get index page successfully.";
    }
}
