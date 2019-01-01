package com.raymond.resource2.feign;

import com.raymond.resource2.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Raymond Kwong on 12/31/2018.
 */
@FeignClient(name="resource")
public interface ResourceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/resource/sample/getRandomUser")
    UserDto getRandomUser();
}
