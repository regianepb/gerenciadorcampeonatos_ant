package br.com.gerenciadorcampeonatos.dao;

import br.com.gerenciadorcampeonatos.modelo.Enderecos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EnderecoDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gecampeonatoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<Enderecos> buscarTodosEnderecos() {
        List<Enderecos> enderecos = new ArrayList<Enderecos>();
        Query query = entityManager.createQuery("select t from ENDERECOS as t ");
        enderecos = query.getResultList();
        return enderecos;
    }

    public Enderecos buscarEndereco(long id) {
        Enderecos endereco = entityManager.find(Enderecos.class, id);
        return endereco;
    }

    public Enderecos criarEndereco(Enderecos endereco) {
        entityManager.getTransaction().begin();
        entityManager.persist(endereco);
        entityManager.getTransaction().commit();
        entityManager.close();
        return endereco;
    }

    public Enderecos atualizarEndereco(Enderecos endereco) {
        entityManager.getTransaction().begin();
        entityManager.merge(endereco);
        entityManager.getTransaction().commit();
        entityManager.close();
        return endereco;
    }

    public void removerEndereco(long id) {
        Enderecos endereco = this.buscarEndereco(id);
        entityManager.getTransaction().begin();
        entityManager.remove(endereco);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
