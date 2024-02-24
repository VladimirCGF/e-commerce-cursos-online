package org.acme.controllers.handlers;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dtos.MessageError;
import org.acme.services.exceptions.EntityValidationException;

import java.time.Instant;

@Provider
public class ControllerEntityValidationException implements ExceptionMapper<EntityValidationException> {

    @Context
    UriInfo uriInfo;

    @Override
    public Response toResponse(EntityValidationException e) {
        MessageError messageError = new MessageError();
        messageError.setMessage(e.getMessage());
        messageError.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
        messageError.setTimestamp(Instant.now());
        messageError.setPath(uriInfo.getPath());
        return Response.status(Response.Status.BAD_REQUEST).entity(messageError).build();
    }
}
