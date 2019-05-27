package hello.oauth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

public class LoginClient {

    private String baseUrl = "https://github.com/login/oauth/authorize";
    private String redirectUrl = "http://localhost:8080/login/callback";

    public void getIdentity(String clientId) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("client_id", clientId)
                .queryParam("state", "rxaxnxdxoxmxsxtxrxixnxg")
                .queryParam("redirect_uri", redirectUrl);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
    }

}
