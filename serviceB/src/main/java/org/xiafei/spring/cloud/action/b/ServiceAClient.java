package org.xiafei.spring.cloud.action.b;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("serviceA")
public interface ServiceAClient {

    @GetMapping("/name")
    public String getName();
}
