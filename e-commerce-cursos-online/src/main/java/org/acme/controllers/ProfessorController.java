package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.ProfessorDTO;
import org.acme.services.ProfessorService;

import java.util.List;

@Path(value = "/professor")
public class ProfessorController {

    @Inject
    ProfessorService service;

    @GET
    public Response findAll() {
        List<ProfessorDTO> list = service.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        ProfessorDTO professorDTO = service.findById(id);
        return Response.ok(professorDTO).build();
    }

    @POST
    public Response create(ProfessorDTO professorDTO) {
        ProfessorDTO professor = service.create(professorDTO);
        return Response.ok(professor).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ProfessorDTO professorDTO) {
        service.update(id, professorDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
