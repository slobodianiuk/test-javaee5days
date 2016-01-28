package ua.freesbe.test.javaee5days.day4_jax_rs_example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by Bohdan on 1/28/2016.
 */
@Path("/admin/")
public class AdminResource {

    @GET
    @Path("/{operation}")
    @Produces("text/plain")
    public String doOperation(@PathParam("operation") String op) {
        return doAsAdmin() + " you are doing " + op;
    }

    private String doAsAdmin() {
        return "As ADMIN";
    }
}
