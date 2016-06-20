package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.CampeonatosJogadores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CampeonatoJogadorDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<CampeonatosJogadores> buscarTodosCampeonatosJogadores() {
        List<CampeonatosJogadores> campeonatosJogadores = new ArrayList<CampeonatosJogadores>();
        Query query = entityManager.createQuery("select t from CAMPEONATOS_JOGADORES as t ");
        campeonatosJogadores = query.getResultList();
        return campeonatosJogadores;
    }

    public CampeonatosJogadores buscarCampeonatoJogador(long id) {
        CampeonatosJogadores campeonatoJogador = entityManager.find(CampeonatosJogadores.class, id);
        return campeonatoJogador;
    }

    public CampeonatosJogadores criarCampeonatoJogador(CampeonatosJogadores campeonatoJogador) {
        entityManager.getTransaction().begin();
        entityManager.persist(campeonatoJogador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoJogador;
    }

    public CampeonatosJogadores atualizarCampeonatoJogador(CampeonatosJogadores campeonatoJogador) {
        entityManager.getTransaction().begin();
        entityManager.merge(campeonatoJogador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoJogador;
    }

    public void removerCampeonatoJogador(long id) {
        CampeonatosJogadores campeonatoJogador = this.buscarCampeonatoJogador(id);
        entityManager.getTransaction().begin();
        entityManager.remove(campeonatoJogador);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
