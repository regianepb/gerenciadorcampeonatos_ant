package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.CampeonatosDespesas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CampeonatoDespesaDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<CampeonatosDespesas> buscarTodosCampeonatosDespesas() {
        List<CampeonatosDespesas> campeonatosDespesas = new ArrayList<CampeonatosDespesas>();
        Query query = entityManager.createQuery("select t from CAMPEONATOS_DESPESAS as t ");
        campeonatosDespesas = query.getResultList();
        return campeonatosDespesas;
    }

    public CampeonatosDespesas buscarCampeonatoDespesa(long id) {
        CampeonatosDespesas campeonatoDespesa = entityManager.find(CampeonatosDespesas.class, id);
        return campeonatoDespesa;
    }

    public CampeonatosDespesas criarCampeonatoDespesa(CampeonatosDespesas campeonatoDespesa) {
        entityManager.getTransaction().begin();
        entityManager.persist(campeonatoDespesa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoDespesa;
    }

    public CampeonatosDespesas atualizarCampeonatoDespesa(CampeonatosDespesas campeonatoDespesa) {
        entityManager.getTransaction().begin();
        entityManager.merge(campeonatoDespesa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return campeonatoDespesa;
    }

    public void removerCampeonatoDespesa(long id) {
        CampeonatosDespesas campeonatoDespesa = this.buscarCampeonatoDespesa(id);
        entityManager.getTransaction().begin();
        entityManager.remove(campeonatoDespesa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
