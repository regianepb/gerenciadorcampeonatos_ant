package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Modalidades;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ModalidadeDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Modalidades> buscarTodasModalidades() {
        List<Modalidades> modalidades = new ArrayList<Modalidades>();
        Query query = entityManager.createQuery("select t from MODALIDADES as t ");
        modalidades = query.getResultList();
        return modalidades;
    }

    public Modalidades buscarModalidade(long id) {
        Modalidades modalidade = entityManager.find(Modalidades.class, id);
        return modalidade;
    }

    public Modalidades criarModalidade(Modalidades modalidade) {
        entityManager.getTransaction().begin();
        entityManager.persist(modalidade);
        entityManager.getTransaction().commit();
        entityManager.close();
        return modalidade;
    }

    public Modalidades atualizarModalidade(Modalidades modalidade) {
        entityManager.getTransaction().begin();
        entityManager.merge(modalidade);
        entityManager.getTransaction().commit();
        entityManager.close();
        return modalidade;
    }

    public void removerModalidade(long id) {
        Modalidades modalidade = this.buscarModalidade(id);
        entityManager.getTransaction().begin();
        entityManager.remove(modalidade);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
