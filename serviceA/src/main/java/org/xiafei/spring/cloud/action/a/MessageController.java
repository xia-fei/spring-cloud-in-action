package org.xiafei.spring.cloud.action.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController  {
    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    public String message(){
        return name ;
    }

}
