package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Despesas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DespesaDao {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Despesas> buscarTodasDespesas() {
        List<Despesas> despesas = new ArrayList<Despesas>();
        Query query = entityManager.createQuery("select t from DESPESAS as t ");
        despesas = query.getResultList();
        return despesas;
    }

    public Despesas buscarDespesa(long id) {
        Despesas despesa = entityManager.find(Despesas.class, id);
        return despesa;
    }

    public Despesas criarDespesa(Despesas despesa) {
        entityManager.getTransaction().begin();
        entityManager.persist(despesa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return despesa;
    }

    public Despesas atualizarDespesa(Despesas despesa) {
        entityManager.getTransaction().begin();
        entityManager.merge(despesa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return despesa;
    }

    public void removerDespesa(long id) {
        Despesas despesa = this.buscarDespesa(id);
        entityManager.getTransaction().begin();
        entityManager.remove(despesa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
