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

    public List<Times> buscarTodosTimes() {
        List<Times> times = new ArrayList<Times>();
        Query query = entityManager.createQuery("select t from TIMES as t order by ID");
        times = query.getResultList();
        return times;
    }

    public Times buscarTime(long id) {
        Times time = entityManager.find(Times.class, id);
        return time;
    }

    public Times criarTime(Times time) {
        entityManager.getTransaction().begin();
        entityManager.persist(time);
        entityManager.getTransaction().commit();
        entityManager.close();
        return time;
    }

    public Times atualizarTime(Times time) {
        entityManager.getTransaction().begin();
        entityManager.merge(time);
        entityManager.getTransaction().commit();
        entityManager.close();
        return time;
    }

    public void removerTime(long id) {
        Times time = this.buscarTime(id);
        entityManager.getTransaction().begin();
        entityManager.remove(time);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
