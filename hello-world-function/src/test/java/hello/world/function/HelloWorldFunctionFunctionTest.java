package hello.world.function;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldFunctionFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        HelloWorldFunctionClient client = server.getApplicationContext().getBean(HelloWorldFunctionClient.class);

        assertEquals(client.hello("Fred").blockingGet(), "Hello Fred");
        server.stop();
    }
}
