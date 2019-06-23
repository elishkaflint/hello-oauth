package hello.oauth.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LoginClient {

    private String baseUrl = "https://github.com/login/oauth/authorize";
    private String accessTokenUrl = "https://github.com/login/oauth/access_token";
    private String redirectUrl = "http://localhost:8080/redirect";

    public String getIdentity(String clientId) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUrl)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        System.out.println("[EF] Making call to " + builder.toUriString());

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();
    }

    public String exchangeToken(String authenticityToken, String clientId, String clientSecret) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(accessTokenUrl)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", authenticityToken)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        System.out.println("[EF] Making call to " + builder.toUriString());

        return restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, String.class).getBody();
    }

}
