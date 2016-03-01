package br.com.gerenciadorcampeonatos.resource;

import br.com.gerenciadorcampeonatos.dao.EnderecoDao;
import br.com.gerenciadorcampeonatos.modelo.Enderecos;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {
    private EnderecoDao enderecoDao = new EnderecoDao();

    @GET
    public List<Enderecos> buscarTodosEnderecos() {
        return enderecoDao.buscarTodosEnderecos();
    }

    @GET
    @Path("{id}")
    public Enderecos buscarEndereco(@PathParam("id") long id) {
        return enderecoDao.buscarEndereco(id);
    }

    @POST
    public Enderecos criarEndereco(Enderecos endereco) {
        return enderecoDao.criarEndereco(endereco);
    }

    @PUT
    public Enderecos atualizarEndereco(Enderecos endereco) {
        return enderecoDao.atualizarEndereco(endereco);
    }

    @DELETE
    @Path("{id}")
    public void removerEndereco(@PathParam("id") long id) {
        enderecoDao.removerEndereco(id);
    }

}
