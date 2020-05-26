package com.miraclekang.clouddemo.identity.port.adapter.restful;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/identity/")
public class IdentityController {

    @GetMapping("/")
    public String home() {
        return "identity";
    }
}
