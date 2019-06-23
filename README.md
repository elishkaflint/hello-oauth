### Spring Controller Annotations

@Controller expects a view resolver

@RestController is better for a back end API:

>@RestController is a composed annotation that is itself meta-annotated with @Controller and @ResponseBody indicating a controller whose every method inherits the type-level @ResponseBody annotation and therefore writes directly to the response body vs view resolution and rendering with an HTML template.

In-built oauth2 annotations in Spring look worth exploring https://spring.io/guides/tutorials/spring-boot-oauth2/

### Heroku

git remote add heroku git@heroku.com:project.git
git push heroku master

### Activity log

| Date |Notes|
|:---:|---|
| 28/05/19 | Not much progress, am getting a redirect form Github but it's (a) not going to the callback url I've specified (instead it's going to session) (b) does not include the code parameter I'm expecting (nor the state - csrf?), instead when I inspect I can see an authenticity_token in the form section of the request/response bit as well as my username and password.
| 29/05/19 | Much better today! Instead of using rest template to make the request to the authorisation endpoint, I used a simple redirect view to which I passed in the parameterised url. This redirected me correctly to Github where I reached the correct screen. I'm being redirected back to the right callback url with the code! Tomorrow I need to understand why using RestTemplate did something different than expected. Possibly to do with how redirects work. Also check whether my username and stuff is available in dev tools. 