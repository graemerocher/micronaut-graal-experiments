package hello.world.function;

import io.micronaut.function.FunctionBean;
import io.micronaut.context.annotation.*;
import java.util.function.*;

@Factory
public class Functions {

    @FunctionBean("hello-world")
    public Function<String, String> hello() {
        return (name) -> "Hello " + name;
    }
}
