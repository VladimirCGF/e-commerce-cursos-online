package org.acme.controllers;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.dtos.UsuarioDTO;
import org.acme.services.UsuarioService;
import org.acme.services.exceptions.EntityValidationException;

import java.util.List;

@Path(value = "/usuario")
public class UsuarioController {

    @Inject
    UsuarioService service;

    @GET
    public Response findAll() {
        List<UsuarioDTO> list = service.findAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("{id}")
    public Response findById(@PathParam("id") Long id) {
        UsuarioDTO usuarioDTO = service.findById(id);
        return Response.ok(usuarioDTO).build();
    }

    @POST
    public Response create(@Valid UsuarioDTO usuarioDTO) throws EntityValidationException {
        UsuarioDTO usuario = service.create(usuarioDTO);
        return Response.ok(usuario).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id,@Valid UsuarioDTO usuarioDTO) throws EntityValidationException {
        service.update(id, usuarioDTO);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) throws EntityValidationException {
        service.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


}
