package edu.poniperro.quickstart;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;

@Path("/persona")
public class PersonaResource {

    // "import" del service
    @Inject
    PersonaService service;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Persona> getAllPerson(){
        return this.service.getAll();
    }

//    @GET
//    // {...} = eso significa que la ruta es dinámica
//    @Path("/{id}")
//    // lo que va a devolve
//    @Produces(MediaType.APPLICATION_JSON)
//    public Optional<Persona> getById(@PathParam("id") Long idPersona){
//        return this.service.getById(idPersona);
//    }


      @GET
    // {...} = eso significa que la ruta es dinámica
      @Path("/{id}")
      // lo que va a devolve
      @Produces(MediaType.APPLICATION_JSON)
      public Response getById(@PathParam("id") Long idPersona){
        Optional<Persona> persona = service.getById(idPersona);

        return persona.isPresent()
        ? Response.status(Response.Status.OK).entity(persona.get()).build()
        : Response.status(Response.Status.NOT_FOUND).build();
     }


    @DELETE
    @Path("/{nombre}")
    // Usar cuando se tiene que modificar una base de datos
    @Transactional
    // Lo que te van a pasar
    @Consumes(MediaType.TEXT_PLAIN)
    public Set<Persona> deletePersona(@PathParam("nombre") String nombre){
        this.service.deletePersona(nombre);
        return this.service.getAll();
    }

    @POST
    // si no haces un Path coge la ruta de la url base
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Set<Persona> postPersona(Persona persona){
        this.service.postPersona(persona);
        return this.service.getAll();
    }

}
