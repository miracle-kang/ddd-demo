package com.miraclekang.clouddemo.access.port.adapter.restful;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/access")
@Api(description = "Access service")
public class AccessController {

    @GetMapping("/")
    public String home() {
        return "Access";
    }
}
