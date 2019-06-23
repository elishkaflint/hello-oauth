package hello.oauth.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LoginClient {

    private String authUrl = "https://github.com/login/oauth";
    private String redirectUrl = "http://localhost:8080/redirect";

    public RedirectView getTemporaryCode(String clientId) {

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(authUrl + "/authorize")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUrl)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg");

        return new RedirectView(builder.toUriString());
    }

    public String getAccessToken(String code, String clientId, String clientSecret) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(authUrl + "/access_token")
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", code)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        System.out.println("[EF] Making call to " + builder.toUriString());

        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class).getBody();
    }

}
