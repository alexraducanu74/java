package org.example.jpa.repo;

import jakarta.persistence.EntityManager;
import org.example.jpa.entities.Country;
import org.example.jpa.util.LoggerUtil;

import java.util.List;
import java.util.logging.Logger;

public class CountryRepository extends AbstractRepository<Country, Integer> {

    public CountryRepository(EntityManager em) {
        super(em, Country.class);
    }

    public List<Country> findByName(String name) {
        return em.createNamedQuery("Country.findByName", Country.class)
                .setParameter("name", "%" + name + "%")  //LIKE
                .getResultList();
    }
    Logger logger = LoggerUtil.getLogger(CountryRepository.class.getName());

    public void create(Country country) {
        long start = System.currentTimeMillis();
        try {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
            logger.info("created country: " + country.getName());
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.severe("err: " + e.getMessage());
        } finally {
            logger.fine("execution time: " + (System.currentTimeMillis() - start) + "ms");
        }
    }

}
