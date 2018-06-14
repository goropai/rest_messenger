package com.goropai.rest.registrator;

import com.goropai.rest.entity.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class UserRegistrator {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(User item) {
        logger.info("Created user: " + item);
        entityManager.merge(item);
    }

    public void update(User item) {
        logger.info("Updated user: " + item);
        entityManager.merge(item);
    }

    public void delete(User item) {
        logger.info("Deleted user: " + item);
        entityManager.remove(item);
    }
}
