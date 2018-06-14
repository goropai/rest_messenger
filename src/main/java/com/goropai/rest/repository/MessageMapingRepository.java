package com.goropai.rest.repository;

import com.goropai.rest.entity.MessageMapping;
import com.goropai.rest.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MessageMapingRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<MessageMapping> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public MessageMapping getById(Long id) {
        logger.info("Get message mapping by id: " + id);
        return entityManager.find(MessageMapping.class, id);
    }

    public List<MessageMapping> getByFromUser(User from) {
        logger.info("Get message mapping by user_FROM: " + from);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        Root<MessageMapping> element = criteria.from(MessageMapping.class);
        criteria.select(element).where(criteriaBuilder.equal(element.get("from_id"), from));
        return entityManager.createQuery(criteria).getResultList();
    }
}
