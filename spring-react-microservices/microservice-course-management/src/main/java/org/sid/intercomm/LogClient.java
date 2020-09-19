package org.sid.intercomm;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("log-service")
@Component
public interface LogClient {

    @RequestMapping(method = RequestMethod.GET, value = "/service/popular", consumes = "application/json")
    List<Long> getPopularCourses();
}
