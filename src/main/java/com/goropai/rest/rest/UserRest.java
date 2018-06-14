package com.goropai.rest.rest;

import com.goropai.rest.entity.User;
import com.goropai.rest.registrator.UserRegistrator;
import com.goropai.rest.repository.UserRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
@Path("/user")
public class UserRest {
    @Inject
    private Logger logger;

    @Inject
    private UserRepository repository;

    @Inject
    private UserRegistrator registrator;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAll() {
        logger.info("Get all users");
        return repository.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getById(@PathParam("id") Long id) {
        return repository.getById(id);
    }
}
