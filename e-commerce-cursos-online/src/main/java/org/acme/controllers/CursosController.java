package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.CursosDTO;
import org.acme.services.CursosService;
import org.acme.services.exceptions.EntityValidationException;

import javax.swing.*;
import java.util.List;

@Path(value = "/cursos")
public class CursosController {

    @Inject
    CursosService service;

    @GET
    public Response findAll() {
        List<CursosDTO> list = service.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response findById(Long id) {
        CursosDTO cursosDTO = service.findById(id);
        return Response.ok(cursosDTO).build();
    }

    @POST
    public Response create(CursosDTO cursosDTO) throws EntityValidationException {
        CursosDTO dto = service.create(cursosDTO);
        return Response.ok(dto).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, CursosDTO cursosDTO) throws EntityValidationException {
        service.update(id, cursosDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws EntityValidationException {
        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
