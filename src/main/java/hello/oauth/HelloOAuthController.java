package hello.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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