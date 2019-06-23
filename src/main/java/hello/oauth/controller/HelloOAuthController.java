package hello.oauth.controller;

import hello.oauth.client.LoginClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloOAuthController {

    @GetMapping("/login")
    public RedirectView login() {
        System.out.println("[EF] in the login route");

        //todo make into env var
        String clientId = "85108066559154cd13f2";
        String clientSecret = "25caa520bbc02fcc076a0845d8f01be96482ba5e";

        String baseUrl = "https://github.com/login/oauth/authorize";
        String redirectUrl = "http://localhost:8080/redirect";

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUrl)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg");

        return new RedirectView(builder.toUriString());

//        LoginClient loginClient = new LoginClient();
//        return loginClient.getIdentity(clientId);
    }

    @GetMapping("/redirect")
    public String callback() {
        return "callback";
    }

    @PostMapping("/session")
    public String session(HttpServletRequest request) {

        //todo make into env var
        String clientId = "85108066559154cd13f2";
        String clientSecret = "25caa520bbc02fcc076a0845d8f01be96482ba5e";

        LoginClient loginClient = new LoginClient();

        //todo authenticity_token is not the correct field
        return loginClient.exchangeToken(request.getParameter("authenticity_token"), clientId, clientSecret);
    }

    @GetMapping("/landing")
    public String landing() {
        return "landing";
    }

}