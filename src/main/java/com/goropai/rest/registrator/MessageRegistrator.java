package com.goropai.rest.registrator;

import com.goropai.rest.entity.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class MessageRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public void create(Message item) {
        logger.info("Created message: " + item);
        entityManager.merge(item);
    }

    public void update(Message item) {
        logger.info("Updated message: " + item);
        entityManager.merge(item);
    }

    public void delete(Message item) {
        logger.info("Deleted message: " + item);
        entityManager.remove(item);
    }
}
