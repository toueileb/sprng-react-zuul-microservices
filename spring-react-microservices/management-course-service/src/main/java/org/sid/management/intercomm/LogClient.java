package org.sid.management.intercomm;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("log-service")
@Component
@RibbonClient
public interface LogClient {

    @RequestMapping(method = RequestMethod.GET, value = "/service/popular", consumes = "application/json")
    List<Long> getPopularCourses();
}
