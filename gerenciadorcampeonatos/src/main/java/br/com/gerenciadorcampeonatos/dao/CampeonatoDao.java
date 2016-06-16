
package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Campeonatos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CampeonatoDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Campeonatos> buscarTodosCampeonatos() {
        List<Campeonatos> campeonatoes = new ArrayList<Campeonatos>();
        Query query = entityManager.createQuery("select t from CAMPEONATOS as t ");
        campeonatoes = query.getResultList();
        return campeonatoes;
    }

    public Campeonatos buscarCampeonato(long id) {
        Campeonatos campeonato = entityManager.find(Campeonatos.class, id);
        return campeonato;
    }

    public Campeonatos criarCampeonato(Campeonatos campeonato) {
        entityManager.getTransaction().begin();
        entityManager.persist(campeonato);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonato;
    }

    public Campeonatos atualizarCampeonato(Campeonatos campeonato) {
        entityManager.getTransaction().begin();
        entityManager.merge(campeonato);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonato;
    }

    public void removerCampeonato(long id) {
        Campeonatos campeonato = this.buscarCampeonato(id);
        entityManager.getTransaction().begin();
        entityManager.remove(campeonato);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
