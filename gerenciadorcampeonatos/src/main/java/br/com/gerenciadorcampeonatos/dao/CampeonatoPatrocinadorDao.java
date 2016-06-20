package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.CampeonatosPatrocinadores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CampeonatoPatrocinadorDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<CampeonatosPatrocinadores> buscarTodosCampeonatosPatrocinadores() {
        List<CampeonatosPatrocinadores> campeonatosPatrocinadores = new ArrayList<CampeonatosPatrocinadores>();
        Query query = entityManager.createQuery("select t from CAMPEONATOS_PATROCINADORES as t ");
        campeonatosPatrocinadores = query.getResultList();
        return campeonatosPatrocinadores;
    }

    public CampeonatosPatrocinadores buscarCampeonatoPatrocinador(long id) {
        CampeonatosPatrocinadores campeonatoPatrocinador = entityManager.find(CampeonatosPatrocinadores.class, id);
        return campeonatoPatrocinador;
    }

    public CampeonatosPatrocinadores criarCampeonatoPatrocinador(CampeonatosPatrocinadores campeonatoPatrocinador) {
        entityManager.getTransaction().begin();
        entityManager.persist(campeonatoPatrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoPatrocinador;
    }

    public CampeonatosPatrocinadores atualizarCampeonatoPatrocinador(CampeonatosPatrocinadores campeonatoPatrocinador) {
        entityManager.getTransaction().begin();
        entityManager.merge(campeonatoPatrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoPatrocinador;
    }

    public void removerCampeonatoPatrocinador(long id) {
        CampeonatosPatrocinadores campeonatoPatrocinador = this.buscarCampeonatoPatrocinador(id);
        entityManager.getTransaction().begin();
        entityManager.remove(campeonatoPatrocinador);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
