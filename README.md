### Spring Controller Annotations

#### @Controller

@Controller expects a view resolver

@RestController is better for a back end API:

>@RestController is a composed annotation that is itself meta-annotated with @Controller and @ResponseBody indicating a controller whose every method inherits the type-level @ResponseBody annotation and therefore writes directly to the response body vs view resolution and rendering with an HTML template.

#### @Value

In application.properties:
```
client.id=abcdef
```

In eg. the controller:
```
@Value("${client.id})
private String clientId;
```

#### @Autowired

Create a class and annotate with @Component => means it's now a bean which is available for injection into other classes when the application runs.
To inject it into other classes, declare the variable with @Autowired notation:

```java
@RestController
public class HelloOAuthController {

    @Autowired
    LoginClient loginClient;

    @GetMapping("/login")
    public RedirectView login() {
        return loginClient.getTemporaryCode(clientId);
    }
}
```

### Heroku

```
git remote add heroku git@heroku.com:project.git

git push heroku master
```

### Activity log

| Date |Notes|
|:---:|---|
| 28/05/19 | Not much progress, am getting a redirect form Github but it's (a) not going to the callback url I've specified (instead it's going to session) (b) does not include the code parameter I'm expecting (nor the state - csrf?), instead when I inspect I can see an authenticity_token in the form section of the request/response bit as well as my username and password.
| 29/05/19 | Much better today! Instead of using rest template to make the request to the authorisation endpoint, I used a simple redirect view to which I passed in the parameterised url. This redirected me correctly to Github where I reached the correct screen. I'm being redirected back to the right callback url with the code! Tomorrow I need to understand why using RestTemplate did something different than expected. Possibly to do with how redirects work. Also check whether my username and stuff is available in dev tools.
| 23/06/19 | Have received an access token and used it to retrieve my own github avatar via a curl from the command line. Client id and secret are now stored as environment variables. Next to do: complete oauth flow (full user journey, get the routes right), store client id and secret in vault, generate random string via CSRF. 

In-built oauth2 annotations in Spring look worth exploring https://spring.io/guides/tutorials/spring-boot-oauth2/
