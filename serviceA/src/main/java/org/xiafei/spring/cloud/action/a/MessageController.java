package org.xiafei.spring.cloud.action.a;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Value("${name}")
    private String name;
    @Value("${server.port}")
    private int port;

    @RequestMapping("/name")
    public String message() {
        return "我是"+name +"我的端口"+ port;
    }

}
