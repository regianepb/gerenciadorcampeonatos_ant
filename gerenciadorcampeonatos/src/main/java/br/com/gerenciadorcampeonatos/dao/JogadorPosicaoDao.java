package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.JogadoresPosicoes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JogadorPosicaoDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<JogadoresPosicoes> buscarTodosJogadoresPosicoes() {
        List<JogadoresPosicoes> jogadoresPosicoes = new ArrayList<JogadoresPosicoes>();
        Query query = entityManager.createQuery("select t from JOGADORES_POSICAO as t ");
        jogadoresPosicoes = query.getResultList();
        return jogadoresPosicoes;
    }

    public JogadoresPosicoes buscarJogadorPosicao(long id) {
        JogadoresPosicoes jogadorPosicao = entityManager.find(JogadoresPosicoes.class, id);
        return jogadorPosicao;
    }

    public JogadoresPosicoes criarJogadorPosicao(JogadoresPosicoes jogadorPosicao) {
        entityManager.getTransaction().begin();
        entityManager.persist(jogadorPosicao);
        entityManager.getTransaction().commit();
        entityManager.close();
        return jogadorPosicao;
    }

    public JogadoresPosicoes atualizarJogadorPosicao(JogadoresPosicoes jogadorPosicao) {
        entityManager.getTransaction().begin();
        entityManager.merge(jogadorPosicao);
        entityManager.getTransaction().commit();
        entityManager.close();
        return jogadorPosicao;
    }

    public void removerJogadorPosicao(long id) {
        JogadoresPosicoes jogadorPosicao = this.buscarJogadorPosicao(id);
        entityManager.getTransaction().begin();
        entityManager.remove(jogadorPosicao);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
