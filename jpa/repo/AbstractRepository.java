package org.example.jpa.repo;

import jakarta.persistence.EntityManager;

public abstract class AbstractRepository<T, ID> {
    protected EntityManager em;
    private Class<T> entityClass;

    public AbstractRepository(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.entityClass = clazz;
    }

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public T findById(ID id) {
        return em.find(entityClass, id);
    }
}
