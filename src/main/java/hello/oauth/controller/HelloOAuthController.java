package hello.oauth.controller;

import hello.oauth.client.LoginClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloOAuthController {

    @GetMapping("/login")
    public String login() {
        String clientId = "85108066559154cd13f2";
        String clientSecret = "25caa520bbc02fcc076a0845d8f01be96482ba5e";
        LoginClient loginClient = new LoginClient();
        String response = loginClient.getIdentity(clientId);
        return response;
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