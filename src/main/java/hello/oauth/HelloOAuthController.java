package hello.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloOAuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/landing")
    public String landing() {
        return "landing";
    }

}