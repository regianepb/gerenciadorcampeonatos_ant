package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Paises;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PaisDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

      public List<Paises> buscarTodosPaises() {
        List<Paises> pais = new ArrayList<Paises>();
        Query query = entityManager.createQuery("select t from PAISES as t ");
        pais = query.getResultList();
        return pais;
    }

    public Paises buscarPais(long id) {
        Paises pais = entityManager.find(Paises.class, id);
        return pais;
    }

    public Paises criarPais(Paises pais) {
        entityManager.getTransaction().begin();
        entityManager.persist(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pais;
    }

    public Paises atualizarPais(Paises pais) {
        entityManager.getTransaction().begin();
        entityManager.merge(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pais;
    }

    public void removerPais(long id) {
        Paises pais = this.buscarPais(id);
        entityManager.getTransaction().begin();
        entityManager.remove(pais);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
