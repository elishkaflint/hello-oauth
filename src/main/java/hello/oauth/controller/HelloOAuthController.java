package hello.oauth.controller;

import hello.oauth.client.LoginClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import sun.rmi.runtime.Log;

@RestController
public class HelloOAuthController {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @Autowired
    LoginClient loginClient;

    @GetMapping("/login")
    public RedirectView login() {
        System.out.println("[EF] in the login route");
        return loginClient.getTemporaryCode(clientId);
    }

    @GetMapping("/redirect")
    public String callback(@RequestParam String code) {
        System.out.println("[EF] in the redirect route");
        return loginClient.getAccessToken(code, clientId, clientSecret);
    }

}