package hello.oauth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class LoginClient {

    private String baseUrl = "https://github.com/login/oauth/authorize";
    private String redirectUrl = "https://hello-oauth.herokuapp.com/login/callback";

    @Autowired
    RestTemplate restTemplate;

    public String getIdentity(String clientId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<>(headers);
            return restTemplate.exchange(urlBuilder(clientId), HttpMethod.GET, entity, String.class).getBody();
        } catch (Exception e) {
            System.out.println("[EF] Exception caught: " + e.getMessage());
            return "error";
        }
    }

    private String urlBuilder(String clientId) {
        StringBuilder stringBuilder = new StringBuilder()
                .append(baseUrl)
                .append("?")
                .append("client_Id=")
                .append(clientId)
                .append("state=")
                .append("rxaxnxdxoxmxsxtxrxixnxg")
                .append("redirect_uri=")
                .append(redirectUrl);
        return stringBuilder.toString();
    }

}
