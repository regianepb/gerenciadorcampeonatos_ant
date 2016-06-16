
package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Jogadores;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class JogadorDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Jogadores> buscarTodosJogadores() {
        List<Jogadores> jogadores = new ArrayList<Jogadores>();
        Query query = entityManager.createQuery("select t from JOGADORES as t ");
        jogadores = query.getResultList();
        return jogadores;
    }

    public Jogadores buscarJogador(long id) {
        Jogadores jogador = entityManager.find(Jogadores.class, id);
        return jogador;
    }

    public Jogadores criarJogador(Jogadores jogador) {
        entityManager.getTransaction().begin();
        entityManager.persist(jogador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return jogador;
    }

    public Jogadores atualizarJogador(Jogadores jogador) {
        entityManager.getTransaction().begin();
        entityManager.merge(jogador);
        entityManager.getTransaction().commit();
        entityManager.close();
        return jogador;
    }

    public void removerJogador(long id) {
        Jogadores jogador = this.buscarJogador(id);
        entityManager.getTransaction().begin();
        entityManager.remove(jogador);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
