package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Municipios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MunicipioDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Municipios> buscarTodosMunicipios() {
        List<Municipios> municipios = new ArrayList<Municipios>();
        Query query = entityManager.createQuery("select t from MUNICIPIOS as t ");
        municipios = query.getResultList();
        return municipios;
    }

    public Municipios buscarMunicipio(long id) {
        Municipios municipio = entityManager.find(Municipios.class, id);
        return municipio;
    }

    public Municipios criarMunicipio(Municipios municipio) {
        entityManager.getTransaction().begin();
        entityManager.persist(municipio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return municipio;
    }

    public Municipios atualizarMunicipio(Municipios municipio) {
        entityManager.getTransaction().begin();
        entityManager.merge(municipio);
        entityManager.getTransaction().commit();
        entityManager.close();
        return municipio;
    }

    public void removerMunicipio(long id) {
        Municipios municipio = this.buscarMunicipio(id);
        entityManager.getTransaction().begin();
        entityManager.remove(municipio);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
