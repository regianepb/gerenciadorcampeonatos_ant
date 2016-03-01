package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Bairros;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BairroDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Bairros> buscarTodosBairros() {
        List<Bairros> bairros = new ArrayList<Bairros>();
        Query query = entityManager.createQuery("select t from BAIRROS as t ");
        bairros = query.getResultList();
        return bairros;
    }

    public Bairros buscarBairro(long id) {
        Bairros bairro = entityManager.find(Bairros.class, id);
        return bairro;
    }

    public Bairros criarBairro(Bairros bairro) {
        entityManager.getTransaction().begin();
        entityManager.persist(bairro);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bairro;
    }

    public Bairros atualizarBairro(Bairros bairro) {
        entityManager.getTransaction().begin();
        entityManager.merge(bairro);
        entityManager.getTransaction().commit();
        entityManager.close();
        return bairro;
    }

    public void removerBairro(long id) {
        Bairros bairro = this.buscarBairro(id);
        entityManager.getTransaction().begin();
        entityManager.remove(bairro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
