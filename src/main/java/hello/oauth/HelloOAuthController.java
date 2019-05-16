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

    @GetMapping("/login/callback")
    public String callback() {
        return "callback";
    }

    @GetMapping("/landing")
    public String landing() {
        return "landing";
    }

}