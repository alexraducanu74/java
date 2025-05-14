package org.example.jpa;

import jakarta.persistence.EntityManager;
import org.example.jpa.repo.ContinentRepository;
import org.example.jpa.entities.Continent;
import org.example.jpa.util.JPAUtil;

import java.util.List;

public class JPAMain {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        ContinentRepository continentRepo = new ContinentRepository(em);
        Continent continent = new Continent();
        continent.setName("Europe1");
        continentRepo.create(continent);

        List<Continent> results = continentRepo.findByName("Europe1");
        results.forEach(c -> System.out.println("Found: " + c.getName()));

        em.close();
        JPAUtil.close();
    }

}
