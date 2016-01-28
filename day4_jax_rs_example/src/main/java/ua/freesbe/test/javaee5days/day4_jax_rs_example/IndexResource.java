package ua.freesbe.test.javaee5days.day4_jax_rs_example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Bohdan on 1/28/2016.
 */
@Path("/")
public class IndexResource {

    @GET
    @Produces("text/plain")
    public String getHelloWorld() {
        return "Hello World!";
    }

    @GET
    @Path("/{name}")
    @Produces("text/plain")
    public String sayHelloTo(@PathParam("name") String msg) {
        return "Hello " + msg + "!";
    }
}
