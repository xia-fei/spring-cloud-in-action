package org.xiafei.spring.cloud.action.b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ServiceAClient serviceAClient;

    @RequestMapping("/test")
    public String message() {
        return "hi," + serviceAClient.getName();
    }


}
