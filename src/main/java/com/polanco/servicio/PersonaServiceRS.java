/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.polanco.servicio;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import com.polanco.data.PersonaDao;
import com.polanco.domain.Persona;
import java.util.List;
/**
 *
 * @author POLANCO
 */
@Stateless
@Path("/personas")
public class PersonaServiceRS {
    
    @Inject
    private PersonaDao personaDao;

    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas(){
        List<Persona> personas = personaDao.encontrarTodasPersonas();
        System.out.println("Personas encontradas: "+ personas);
        return personas;
    }

    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Persona encontrarPersona(@PathParam("id")int id){
        Persona persona =personaDao.encontrarPersona(new Persona(id));
        System.out.println("Persona encontrada: "+persona);
        return persona;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona){
        
        personaDao.insertarPersona(persona);
        System.out.println("Persona agregada: "+persona);
        return persona;
    }

    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        if(persona != null){
            personaDao.actualizarPersona(personaModificada);
            System.out.println("Persona actualizada: "+ personaModificada);
            return Response.ok().entity(personaModificada).build();
        }
        else{
        return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id){
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("persona eliminar con el id: "+id);
        return Response.ok().build();
    }
}
