package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Times;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TimeDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Times> buscarTimes() {
        List<Times> times = new ArrayList<Times>();
        Query query = entityManager.createQuery("select t from TIMES as t ");
        times = query.getResultList();
        return times;
    }
    
    public Times criaTime(Times time) {
        entityManager.getTransaction().begin();
        entityManager.persist(time);
        entityManager.getTransaction().commit();
        entityManager.close();
        return time;
    }    
}
