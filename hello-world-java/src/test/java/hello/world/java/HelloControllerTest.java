package hello.world.java;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class HelloControllerTest {

    @Test
    public void testIndex() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        RxHttpClient client = server.getApplicationContext().createBean(RxHttpClient.class, server.getURL());

        assertEquals(HttpStatus.OK, client.toBlocking().exchange("/hello/John").status());
        server.stop();
    }
}
