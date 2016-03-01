package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Posicoes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PosicaoDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Posicoes> buscarTodasPosicoes() {
        List<Posicoes> posicoes = new ArrayList<Posicoes>();
        Query query = entityManager.createQuery("select t from POSICOES as t ");
        posicoes = query.getResultList();
        return posicoes;
    }

    public Posicoes buscarPosicao(long id) {
        Posicoes posicao = entityManager.find(Posicoes.class, id);
        return posicao;
    }

    public Posicoes criarPosicao(Posicoes posicao) {
        entityManager.getTransaction().begin();
        entityManager.persist(posicao);
        entityManager.getTransaction().commit();
        entityManager.close();
        return posicao;
    }

    public Posicoes atualizarPosicao(Posicoes posicao) {
        entityManager.getTransaction().begin();
        entityManager.merge(posicao);
        entityManager.getTransaction().commit();
        entityManager.close();
        return posicao;
    }

    public void removerPosicao(long id) {
        Posicoes posicao = this.buscarPosicao(id);
        entityManager.getTransaction().begin();
        entityManager.remove(posicao);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
