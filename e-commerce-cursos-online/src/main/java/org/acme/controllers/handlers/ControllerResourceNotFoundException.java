package org.acme.controllers.handlers;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.acme.dtos.MessageError;
import org.acme.services.exceptions.ResourceNotFoundException;

import java.time.Instant;

@Provider
public class ControllerResourceNotFoundException implements ExceptionMapper<ResourceNotFoundException> {
    @Context
    UriInfo uriInfo;

    public Response toResponse(ResourceNotFoundException e) {
        MessageError messageError = new MessageError();
        messageError.setMessage(e.getMessage());
        messageError.setStatus(Response.Status.NOT_FOUND.getStatusCode());
        messageError.setTimestamp(Instant.now());
        messageError.setPath(uriInfo.getPath());
        return Response.status(Response.Status.NOT_FOUND).entity(messageError).build();
    }

}
