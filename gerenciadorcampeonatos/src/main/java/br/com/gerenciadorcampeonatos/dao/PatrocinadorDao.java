package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Patrocinadores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PatrocinadorDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Patrocinadores> buscarTodosPatrocinadores() {
        List<Patrocinadores> patrocinadores = new ArrayList<Patrocinadores>();
        Query query = entityManager.createQuery("select t from PATROCINADORES as t ");
        patrocinadores = query.getResultList();
        return patrocinadores;
    }

    public Patrocinadores buscarPatrocinador(long id) {
        Patrocinadores patrocinador = entityManager.find(Patrocinadores.class, id);
        return patrocinador;
    }

    public Patrocinadores criarPatrocinador(Patrocinadores patrocinador) {
        entityManager.getTransaction().begin();
        entityManager.persist(patrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return patrocinador;
    }

    public Patrocinadores atualizarPatrocinador(Patrocinadores patrocinador) {
        entityManager.getTransaction().begin();
        entityManager.merge(patrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return patrocinador;
    }

    public void removerPatrocinador(long id) {
        Patrocinadores patrocinador = this.buscarPatrocinador(id);
        entityManager.getTransaction().begin();
        entityManager.remove(patrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
