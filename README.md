### Spring Controller Annotations

@Controller expects a view resolver

@RestController is better for a back end API:

>@RestController is a composed annotation that is itself meta-annotated with @Controller and @ResponseBody indicating a controller whose every method inherits the type-level @ResponseBody annotation and therefore writes directly to the response body vs view resolution and rendering with an HTML template.

### Heroku

git remote add heroku git@heroku.com:project.git
git push heroku master

### Activity log

| Date |Notes|
|:---:|---|
| 28/05/19 | Not much progress, am getting a redirect form Github but it's (a) not going to the callback url I've specified (b) does not include the code parameter I'm expecting (nor the state - csrf?), instead when I inspect I can see an authenticity_token in the form section of the request/response bit as well as my username and password.