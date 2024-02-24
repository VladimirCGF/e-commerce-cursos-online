package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.MatriculaDTO;
import org.acme.services.MatriculaService;

import java.util.List;

@Path(value = "/matricula")
public class MatriculaController {
    @Inject
    MatriculaService matriculaService;

    @GET
    public Response findAll() {
        List<MatriculaDTO> result = matriculaService.findAll();
        return Response.ok(result).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        MatriculaDTO matriculaDTO = matriculaService.findById(id);
        return Response.ok(matriculaDTO).build();
    }

    @POST
    public Response create(MatriculaDTO matriculaDTO) {
        MatriculaDTO matricula = matriculaService.create(matriculaDTO);
        return Response.ok(matricula).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, MatriculaDTO matriculaDTO) {
        matriculaService.update(id, matriculaDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        matriculaService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
