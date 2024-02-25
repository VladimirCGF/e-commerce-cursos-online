package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.AlunoDTO;
import org.acme.services.AlunoService;
import org.acme.services.exceptions.EntityValidationException;

import java.util.List;

@Path(value = "/aluno")
public class AlunoController {

    @Inject
    AlunoService alunoService;

    @GET
    public Response findAll() {
        List<AlunoDTO> result = alunoService.findAll();
        return Response.ok(result).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        AlunoDTO aluno = alunoService.findById(id);
        return Response.ok(aluno).build();
    }

    @POST
    public Response create(@Valid AlunoDTO alunoDTO) throws EntityValidationException {
        AlunoDTO aluno = alunoService.create(alunoDTO);
        return Response.ok(aluno).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @Valid AlunoDTO alunoDTO) {
        alunoService.update(id, alunoDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws EntityValidationException {
        alunoService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
