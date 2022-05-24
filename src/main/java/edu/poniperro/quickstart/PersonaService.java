package edu.poniperro.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Es para inyectar cosas
@ApplicationScoped
public class PersonaService {

    public Set<Persona> getAll() {
        Stream<Persona> personas = Persona.streamAll();
        // .collect() = transformar un stream a un tipo de lista.
        return personas.collect(Collectors.toSet());
    }

    public Optional<Persona> getById(Long idPersona) {
        // mirar repo de Victor
        return Persona.find("id", idPersona).firstResultOptional();
    }

    public void deletePersona(String nombre) {
        Persona sujeto = Persona.find("nombre", nombre).firstResult();
        sujeto.delete();
    }

    public void postPersona(Persona persona) {
        persona.persist();
    }
}