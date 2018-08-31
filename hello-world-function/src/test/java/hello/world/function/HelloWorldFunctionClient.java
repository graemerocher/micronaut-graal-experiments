package hello.world.function;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.MediaType;
import io.reactivex.Single;
import io.micronaut.http.annotation.*;

import javax.inject.Named;

@FunctionClient
public interface HelloWorldFunctionClient {

    @Named("hello-world")
    Single<String> hello(@Body String name);
}
