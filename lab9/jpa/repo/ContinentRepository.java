package org.example.jpa.repo;

import jakarta.persistence.EntityManager;
import org.example.jpa.entities.Continent;
import org.example.jpa.util.LoggerUtil;

import java.util.List;
import java.util.logging.Logger;

public class ContinentRepository {
    private EntityManager em;
    private static final Logger logger = LoggerUtil.getLogger(ContinentRepository.class.getName());

    public ContinentRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Continent continent) {
        long start = System.currentTimeMillis();
        try {
            em.getTransaction().begin();

            List<Continent> existing = findByName(continent.getName());
            if (existing.isEmpty()) {
                em.persist(continent);
                logger.info("created new continent: " + continent.getName());
            } else {
                continent.setId(existing.get(0).getId());
                em.merge(continent);
                logger.info("updated existing continent: " + continent.getName());
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.severe("failed to create or update continent: " + e.getMessage());
        } finally {
            logger.fine("create() execution time: " + (System.currentTimeMillis() - start) + "ms");
        }
    }

    public Continent findById(Integer id) {
        Continent continent = em.find(Continent.class, id);
        if (continent != null) {
            logger.info("found continent by ID " + id + ": " + continent.getName());
        } else {
            logger.warning("no continent found with ID " + id);
        }
        return continent;
    }

    public List<Continent> findByName(String name) {
        List<Continent> result = em.createNamedQuery("Continent.findByName", Continent.class)
                .setParameter("name", name)
                .getResultList();
        logger.info("searched for continents by name: " + name + ", found: " + result.size());
        return result;
    }
}
