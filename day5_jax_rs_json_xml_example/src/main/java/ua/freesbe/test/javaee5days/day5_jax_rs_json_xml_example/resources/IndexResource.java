package ua.freesbe.test.javaee5days.day5_jax_rs_json_xml_example.resources;

import ua.freesbe.test.javaee5days.day5_jax_rs_json_xml_example.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getPatientAsJSON() {
        return getBook();
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public Book getPatientAsXML() {
        return getBook();
    }

    private Book getBook() {
        Book book = new Book();
        book.setAuthor("Jack London");
        book.setTitle("Martin Eden");
        book.setISBN("978-1594562600");
        return book;
    }

}
