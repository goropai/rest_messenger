package com.goropai.rest.rest;

import com.goropai.rest.entity.Message;
import com.goropai.rest.registrator.MessageRegistrator;
import com.goropai.rest.repository.MessageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/message")
public class MessageRest {
    @Inject
    private Logger logger;

    @Inject
    private MessageRepository repository;

    @Inject
    private MessageRegistrator registrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getListOfAll() {
        logger.info("Get all messages");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getById(@PathParam("id") Long id) {
        return repository.getById(id);
    }
}
