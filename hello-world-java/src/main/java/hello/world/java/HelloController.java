package hello.world.java;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller("/hello")
public class HelloController {

    @Get(uri="/{name}")
    public Greeting index(String name) {
    	Greeting g = new Greeting();
    	g.setMessage("Hello " + name);
        return g;
    }
}