package org.example.crm_project.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password,@RequestParam String email                                                                                ) {

    }
}
