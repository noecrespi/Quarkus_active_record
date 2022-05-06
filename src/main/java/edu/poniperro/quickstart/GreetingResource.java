package edu.poniperro.quickstart;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

@Path("/")
public class GreetingResource {

   // @Inject
   // Service blabla
    // panache

    @GET
    @Path("saludo/{nombrePersona}")
    // Dice que formato va a devolver
    @Produces(MediaType.TEXT_PLAIN)
    public String saludo(@PathParam("nombrePersona") String nombre){
        return "Hola " + nombre ;
    }

   @POST
    @Path("persona")
   // Recible la aplicación
    @Consumes(MediaType.APPLICATION_JSON)
   // Devuelve
   @Produces(MediaType.TEXT_PLAIN)
    public String persona(Persona persona){
        persona.persist();
        return "Ha funcionao";
   }

   // ================================================


}