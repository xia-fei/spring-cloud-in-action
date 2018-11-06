package org.xiafei.spring.cloud.action;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController implements ApplicationContextAware {
    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    public String message(){
        return message;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.printf(applicationContext.toString());
    }
}
