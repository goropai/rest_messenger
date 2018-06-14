package com.goropai.rest.repository;

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
public class UserRepository {
    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public List<User> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public User getById(Long id) {
        logger.info("Get user by id: " + id);
        return entityManager.find(User.class, id);
    }

    public User getByNickName(String nickName) {
        logger.info("Get user by nick_name: " + nickName);
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        Root<User> element = criteria.from(User.class);
        criteria.select(element).where(criteriaBuilder.equal(element.get(nickName), nickName));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
