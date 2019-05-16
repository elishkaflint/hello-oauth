package hello.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloOAuthController {

    @GetMapping("/login_old")
    public String loginForm(Model model) {
        model.addAttribute("loginClient", new LoginClient());
        return "login";
    }

    @PostMapping("/login_old")
    public String loginSubmit(@ModelAttribute LoginClient loginClient) {
        return "result";
    }

}