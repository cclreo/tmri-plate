package com.tmri.RemoteService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "tmri-plate-service-user",fallback = UserServiceHystrix.class)
public interface UserService {

    @RequestMapping(value = "/user/{userId}")
    public String getById(@PathVariable(value = "userId") long UserId);

}
