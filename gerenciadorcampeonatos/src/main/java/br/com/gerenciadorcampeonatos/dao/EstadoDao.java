package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Estados;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EstadoDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Estados> buscarTodosEstados() {
        List<Estados> estados = new ArrayList<Estados>();
        Query query = entityManager.createQuery("select t from ESTADOS as t ");
        estados = query.getResultList();
        return estados;
    }

    public Estados buscarEstado(long id) {
        Estados estado = entityManager.find(Estados.class, id);
        return estado;
    }

    public Estados criarEstado(Estados estado) {
        entityManager.getTransaction().begin();
        entityManager.persist(estado);
        entityManager.getTransaction().commit();
        entityManager.close();
        return estado;
    }

    public Estados atualizarEstado(Estados estado) {
        entityManager.getTransaction().begin();
        entityManager.merge(estado);
        entityManager.getTransaction().commit();
        entityManager.close();
        return estado;
    }

    public void removerEstado(long id) {
        Estados estado = this.buscarEstado(id);
        entityManager.getTransaction().begin();
        entityManager.remove(estado);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
