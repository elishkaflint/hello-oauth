### Spring Controller Annotations

@Controller expects a view resolver

@RestController is better for a back end API:

>@RestController is a composed annotation that is itself meta-annotated with @Controller and @ResponseBody indicating a controller whose every method inherits the type-level @ResponseBody annotation and therefore writes directly to the response body vs view resolution and rendering with an HTML template.

###Heroku

git remote add heroku git@heroku.com:project.git
git push heroku master
